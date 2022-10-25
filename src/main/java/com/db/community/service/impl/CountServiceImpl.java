package com.db.community.service.impl;

import com.db.community.model.entity.Article;
import com.db.community.model.enums.CountType;
import com.db.community.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.db.community.common.RedisNameSpace.*;

@Slf4j
@Service
public class CountServiceImpl implements CountService {

    @Resource
    private ArticleService articleService;

    @Resource
    private ActionService actionService;

    @Resource
    private CommentService commentService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Double getLikeCountById(String id) {
        return actionService.getLikeCount(id);
    }

    @Override
    public void handleCount(CountType countType, String id, Boolean isAdd) {
        BoundValueOperations<String, Object> operations = null;
        switch (countType) {
            case COMMENT:
                operations = redisTemplate.boundValueOps(COMMENT_COUNT_PREFIX + id);
                break;
            case VIEW:
                operations = redisTemplate.boundValueOps(VIEW_COUNT_PREFIX + id);
                break;
        }
        Object o = operations.get();
        if (null == o) {
            operations.set(1);
        } else if (isAdd) {
            operations.increment();
        } else {
            operations.decrement();
        }
    }

    @Override
    public Integer getCount(CountType countType, String id) {
        switch (countType) {
            case COMMENT:
                return (Integer) redisTemplate.opsForValue().get(COMMENT_COUNT_PREFIX + id);
            case VIEW:
                return (Integer) redisTemplate.opsForValue().get(VIEW_COUNT_PREFIX + id);
        }
        return 0;
    }

    @Override
    public void loadCacheFromDB() {
        BoundSetOperations<String, Object> articleIdOps = redisTemplate.boundSetOps(ARTICLE_ID_SET_KEY);
        Set<Object> articleIdSet = articleIdOps.members();
        if (articleIdSet == null) return;
        for (Object o : articleIdSet) {
            CompletableFuture.runAsync(() -> {
                String articleId = (String) o;
                Integer count = articleService.getViewCountByArticleId(articleId);
                redisTemplate.opsForValue().set(VIEW_COUNT_PREFIX + articleId, count);
                count = commentService.getCountByArticleId(articleId);
                redisTemplate.opsForValue().set(COMMENT_COUNT_PREFIX + articleId, count);
            });
        }
    }

    @Override
    public void saveCacheToDB() {
        BoundSetOperations<String, Object> userIdOps = redisTemplate.boundSetOps(ARTICLE_ID_SET_KEY);
        Set<Object> articleIdSet = userIdOps.members();
        if (articleIdSet == null) return;
        List<Article> articles = new LinkedList<>();
        for (Object o : articleIdSet) {
            String articleId = (String) o;
            Article article = new Article();
            article.setArticleId(articleId);
            Integer count = (Integer) redisTemplate.opsForValue().get(VIEW_COUNT_PREFIX + articleId);
            article.setViewCount(count);
            articles.add(article);
            count = commentService.getCountByArticleId(articleId);
            redisTemplate.opsForValue().set(COMMENT_COUNT_PREFIX + articleId, count);
        }
        boolean result = articleService.updateBatchById(articles);
        if(result) {
            log.info("已将浏览量同步到数据库，已读取最新评论数");
        }
    }


}
