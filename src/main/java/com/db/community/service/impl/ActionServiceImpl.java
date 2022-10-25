package com.db.community.service.impl;

import com.db.community.model.document.message.LikeNotion;
import com.db.community.model.entity.LikeCount;
import com.db.community.mq.provider.SystemMessageProvider;
import com.db.community.service.ActionService;
import com.db.community.service.LikeCountService;
import com.db.community.service.MiddleTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.db.community.common.RedisNameSpace.ARTICLE_ID_SET_KEY;

@Service
@Slf4j
public class ActionServiceImpl implements ActionService {

    private static final String LIKE_MAP = "like:map";
    private static final String LIKE_COUNT = "like:count";
    private final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private LikeCountService likeCountService;

    @Resource
    private MiddleTableService middleTableService;

    @Resource
    private SystemMessageProvider systemMessageProvider;

    @Override
    public boolean handleLike(Integer userId, String id) {
        boolean flag = true;
        BoundHashOperations<Object, String, Set<Integer>> cacheLikeMap = redisTemplate.boundHashOps(LIKE_MAP);
        Set<Integer> likeSet = cacheLikeMap.get(id);
        if(likeSet != null) {
            if(!likeSet.contains(userId)) {
                likeSet.add(userId);
            }
            else {
                likeSet.remove(userId);
                flag = false;
            }
            redisTemplate.opsForZSet().incrementScore(LIKE_COUNT, id, flag? 1 : -1);
        }
        else {
            likeSet = new HashSet<>();
            likeSet.add(userId);
            redisTemplate.opsForZSet().add(LIKE_COUNT, id, 1);
        }
        cacheLikeMap.put(id, likeSet);
        return flag;
    }

    @Override
    public Double getLikeCount(String id) {
        return redisTemplate.opsForZSet().score(LIKE_COUNT, id);
    }

    @Override
    public Boolean checkLike(Integer userId, String id) {
        HashOperations<Object, String, Set<Integer>> hashOps = redisTemplate.opsForHash();
        Set<Integer> set = hashOps.get(LIKE_MAP, id);
        if(set != null) {
            return set.contains(userId);
        }
        else {
            return false;
        }
    }


    // 存入数据库的LikeCount队列
    private final Queue<LikeCount> likeCountQueue = new ConcurrentLinkedQueue<>();
    // 计数器，用于记录线程的完成情况，因为是多线程场景，所以使用线程安全的AtomicInteger
    private final AtomicInteger taskCount = new AtomicInteger(0);
    @Override
    public void saveLikeCountToDB() {
        log.info("开始将点赞数持久化到数据库");
        // 获取保存点赞数的Zest中的所有数据
        Set<ZSetOperations.TypedTuple<Object>> typedTuples =
                redisTemplate.opsForZSet().rangeWithScores(LIKE_COUNT, 0, -1);
        if(typedTuples == null) return;
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = typedTuples.iterator();
        while (iterator.hasNext()) {
            // iterator.next() 操作必须在Lambda表达式外完成，表达式内部的iterator是外部的拷贝，会影响iterator.hasNext()的判断
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            // 多线程获取id和对应的点赞数信息，并存入likeCountList
            CompletableFuture.runAsync(() -> {
                LikeCount likeCount = new LikeCount();
                likeCount.setCount(typedTuple.getScore());
                likeCount.setAocId((String) typedTuple.getValue());
                // 多线程插入需使用线程安全的List，否则使用List时可能会出现NullPointerException
                likeCountQueue.add(likeCount);
            }, fixedThreadPool).whenComplete((result, ex) -> {
                // 每个线程完成后都会给计数器+1
                int count = taskCount.incrementAndGet();
                // 如果计数器 = Zset集合的元素个数，则说明所有线程已完成
                if(count == typedTuples.size()) {
                    log.info("数据获取完成，开始存入数据库");
                    // 此时将数据批量存入数据库，批量存的好处是只需获取一次数据库连接，节省资源
                    likeCountService.saveOrUpdateBatch(likeCountQueue);
                    log.info("保存成功");
                    // 清空List，以便下次使用
                    likeCountQueue.clear();
                    // 计数器归零
                    taskCount.set(0);
                }
            }).whenComplete((result, ex) -> {
                // 插入数据库时可能会出现异常，在此处理
                if(ex != null) ex.printStackTrace();
            });
        }

    }

    @Override
    public void loadLikeCountFromDB() {
        log.info("从数据库中读取点赞数");
        List<LikeCount> likeCountList = likeCountService.list();
        BoundZSetOperations<Object, Object> likeCountOps = redisTemplate.boundZSetOps(LIKE_COUNT);
        likeCountOps.removeRange(0, -1);
        for(LikeCount likeCount : likeCountList) {
            CompletableFuture.
                    runAsync(() -> likeCountOps.add(likeCount.getAocId(), likeCount.getCount()),
                            fixedThreadPool);
        }
    }

    @Override
    public void saveLikeRelationToDB() {
        log.info("将点赞关系保存到数据库");
        BoundHashOperations<Object, String, Set<Integer>> boundHashOps = redisTemplate.boundHashOps(LIKE_MAP);
        Map<String, Set<Integer>> entries = boundHashOps.entries();
        if(entries == null) return;
        entries.forEach((aocId, userIdSet) -> CompletableFuture.runAsync(() -> {
            for(Integer userId : userIdSet) {
                // 因为要将点赞消息通知用户，所以是一条一条存入数据库的
                middleTableService.doLikeAction(userId, aocId);
            }
        }, fixedThreadPool));
    }

    @Override
    public void loadLikeRelationFromDB() {
        log.info("从数据库中读取点赞关系");
        BoundSetOperations<Object, Object> articleIdOps = redisTemplate.boundSetOps(ARTICLE_ID_SET_KEY);
        Set<Object> articleIdSet = articleIdOps.members();
        if(articleIdSet == null) return;
        for(Object articleId : articleIdSet) {
            CompletableFuture.runAsync(() -> {
                Set<Integer> likeUserIdSet = middleTableService.getLikeUserIdSetByAOCId((String) articleId);
                redisTemplate.opsForHash().put(LIKE_MAP, articleId, likeUserIdSet);
            }, fixedThreadPool);
        }
    }

    @Override
    public void handleGuestLike(String articleId) {
        LikeNotion likeNotion = new LikeNotion(-1, articleId);
        systemMessageProvider.sendLikeNotion(likeNotion);
    }


}
