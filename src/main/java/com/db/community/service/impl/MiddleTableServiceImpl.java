package com.db.community.service.impl;


import com.db.community.exception.ApiAsserts;
import com.db.community.mapper.MiddleTableMapper;
import com.db.community.model.document.message.LikeNotion;
import com.db.community.model.mtb.*;
import com.db.community.mq.provider.SystemMessageProvider;
import com.db.community.service.MiddleTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MiddleTableServiceImpl implements MiddleTableService {

    @Resource
    private MiddleTableMapper middleTableMapper;

    @Resource
    private SystemMessageProvider systemMessageProvider;


    @Override
    public void saveArticleAndTagRelation(String articleId, String tagId) {
        MiddleTable articleTag = new MTBArticleTag();
        middleTableMapper.insertRelationById(articleTag, articleId, tagId);
    }

    @Override
    public void saveFollowRelation(int parentId, Integer userId) {
        MiddleTable follow = new MTBFollow();
        if(middleTableMapper.checkRelationById(follow, parentId, userId)){
            ApiAsserts.fail("不能重复关注");
        }
        else if(parentId == userId){
            ApiAsserts.fail("不能关注自己");
        }
        middleTableMapper.insertRelationById(follow, parentId, userId);
    }

    @Override
    public void removeFollowRelation(int parentId, Integer userId) {
        MiddleTable follow = new MTBFollow();
        middleTableMapper.deleteRelationById(follow, parentId, userId);
    }

    @Override
    public boolean checkFollowRelation(int parentId, int userId) {
        MiddleTable follow = new MTBFollow();
        return middleTableMapper.checkRelationById(follow, parentId, userId);
    }

    @Override
    public Long getFollowerCount(String userId) {
        MiddleTable follow = new MTBFollow();
        return middleTableMapper.selectCountById1(follow, userId);
    }

    @Override
    public List<String> getUserFollowIdList(Integer userId) {
        MiddleTable follow = new MTBFollow();
        return middleTableMapper.selectId1ListById2(follow, userId);
    }

    @Override
    public Long getArticleCountByTagId(String tagId) {
        MiddleTable articleTag = new MTBArticleTag();
        return middleTableMapper.selectCountById2(articleTag, tagId);
    }

    @Override
    public List<String> getArticleIdListByTagId(String tagId) {
        MiddleTable articleTag = new MTBArticleTag();
        return middleTableMapper.selectId1ListById2(articleTag, tagId);
    }

    @Override
    public Long getLikeCountById(String id) {
        MiddleTable like = new MTBLike();
        return middleTableMapper.selectCountById2(like, id);
    }

    @Override
    public boolean doLikeAction(Integer userId, String id) {
        MiddleTable like = new MTBLike();
        if(middleTableMapper.insertRelationIfNotExist(like, userId, id)) {
            LikeNotion likeNotion = new LikeNotion(userId, id);
            systemMessageProvider.sendLikeNotion(likeNotion);
            return true;
        }

        return false;
    }

    @Override
    public boolean checkLikeRelation(Integer userId, String id) {
        MiddleTable like = new MTBLike();
        return middleTableMapper.checkRelationById(like, userId, id);
    }

    @Override
    public Set<Integer> getLikeUserIdSetByAOCId(String aocId) {
        MiddleTable like = new MTBLike();
        List<String> strings = middleTableMapper.selectId1ListById2(like, aocId);
        return strings.stream().map(Integer::parseInt).collect(Collectors.toSet());
    }


}
