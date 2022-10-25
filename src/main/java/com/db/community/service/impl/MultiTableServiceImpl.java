package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.db.community.mapper.*;
import com.db.community.model.dto.ArticleCreateDTO;
import com.db.community.model.entity.*;
import com.db.community.model.vo.detail.*;
import com.db.community.model.vo.impl.*;
import com.db.community.service.MiddleTableService;
import com.db.community.service.MultiTableService;
import com.db.community.utils.MyBeanUtil;
import com.db.community.utils.MyPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@Service
public class MultiTableServiceImpl implements MultiTableService {


    @Resource
    private TagMapper tagMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private ReplyMapper replyMapper;

    @Resource
    private MiddleTableService middleTableService;


    @Override
    public void createWithArticleDTO(ArticleCreateDTO articleDTO) {

    }

    @Override
    public MyPage<CommentDetailInfoVO> getCommentList(Serializable articleId, Long current, Long size) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId, articleId);
        queryWrapper.orderByDesc(Comment::getCreateTime);
        MyPage<CommentDetailInfoVO> page = new MyPage<>(commentMapper, queryWrapper, current, size);
        // 根据articleId查询文章对应的评论，并根据创建时间降序排序
        List<Comment> commentList = commentMapper.selectList(queryWrapper);
        // 如果评论数为0则直接返回空列表
        if (commentList.size() == 0) {
            return page;
        }
        // 初始化
        List<CommentDetailInfoVO> comments = new ArrayList<>(commentList.size());
        // 缓存已查询出的用户，在一篇文章中同一用户有多条评论的场景下，有较大的性能提升
        Map<Serializable, UserPreviewInfoVO> userCache = new HashMap<>();
        UserPreviewInfoVO userCommentInfo;
        Serializable userId;
        // 遍历查询出的评论集合
        for (Comment comment : commentList) {
            CommentDetailInfoVO commentDetail = new CommentDetailInfoVO();
            // 获取评论者的id
            userId = comment.getUserId();
            // 检测该id是否已缓存
            if (userCache.containsKey(userId)) {
                // 如果存在则直接赋值
                userCommentInfo = userCache.get(userId);
            } else {
                // 如果不存在则从数据库中查询对应的用户信息，赋值，并存入缓存中
                User user = userMapper.selectById(userId);
                userCommentInfo = MyBeanUtil.copyProps(user, UserPreviewInfoVO.class);
                userCache.put(userId, userCommentInfo);
            }
            CommentInfoVO commentInfo = MyBeanUtil.copyProps(comment, CommentInfoVO.class);
            commentDetail.setUser(userCommentInfo);
            commentDetail.setComment(commentInfo);
            comments.add(commentDetail);
        }
        page.setRecords(comments);
        return page;
    }

    @Override
    public List<ArticleDetailVO> getArticleDetailByArticleList(List<Article> articles) {
        List<ArticleDetailVO> list;
        Map<Serializable, UserPreviewInfoVO> cacheMap = new HashMap<>();
        list = new ArrayList<>(articles.size());
        for (Article article : articles) {
            ArticleDetailVO detailVO = new ArticleDetailVO();
            Set<String> tagNameSet = tagMapper.selectTagNameSetByArticleId(article.getArticleId());
            detailVO.setTags(tagNameSet);
            ArticlePreviewInfoVO articleVO = MyBeanUtil.copyProps(article, ArticlePreviewInfoVO.class);
            detailVO.setArticle(articleVO);
            Integer authorId = article.getAuthorId();
            if (cacheMap.containsKey(authorId)) {
                detailVO.setAuthor(cacheMap.get(authorId));
            } else {
                User user = userMapper.selectById(authorId);
                UserPreviewInfoVO userVo = MyBeanUtil.copyProps(user, UserPreviewInfoVO.class);
                detailVO.setAuthor(userVo);
                cacheMap.put(authorId, userVo);
            }
            list.add(detailVO);
        }
        return list;
    }

    @Override
    public MyPage<ReplyDetailVO> getReplyDetailListByCommentId(String commentId, Long current, Long size) {
        LambdaQueryWrapper<Reply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Reply::getCommentId, commentId);
        MyPage<ReplyDetailVO> page = new MyPage<>(replyMapper, queryWrapper, current, size);
        List<Reply> replyList = replyMapper.selectList(queryWrapper);
        List<ReplyDetailVO> replyDetailList = new ArrayList<>(replyList.size());
        for (Reply reply : replyList) {
            ReplyDetailVO replyDetail = new ReplyDetailVO();
            ReplyInfoVO replyInfoVO = MyBeanUtil.copyProps(reply, ReplyInfoVO.class);
            replyDetail.setReply(replyInfoVO);
            User user = userMapper.selectById(reply.getUserId());
            UserPreviewInfoVO userVO = MyBeanUtil.copyProps(user, UserPreviewInfoVO.class);
            replyDetail.setUser(userVO);
            if (reply.getTarget() != null) {
                User target = userMapper.selectById(reply.getTarget());
                UserPreviewInfoVO targetVO = MyBeanUtil.copyProps(target, UserPreviewInfoVO.class);
                replyDetail.setTarget(targetVO);
            }
            replyDetailList.add(replyDetail);

        }
        page.setRecords(replyDetailList);
        return page;
    }


}
