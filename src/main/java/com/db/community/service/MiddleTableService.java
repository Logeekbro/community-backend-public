package com.db.community.service;


import java.util.List;
import java.util.Set;

/**
 * 用于操作中间表
 */
public interface MiddleTableService {

    void saveArticleAndTagRelation(String articleId, String tagId);

    void saveFollowRelation(int parentId, Integer userId);

    void removeFollowRelation(int parentId, Integer userId);

    boolean checkFollowRelation(int parentId, int userId);

    Long getFollowerCount(String userId);

    List<String> getUserFollowIdList(Integer userId);

    Long getArticleCountByTagId(String tagId);

    List<String> getArticleIdListByTagId(String tagId);

    Long getLikeCountById(String id);

    boolean doLikeAction(Integer userId, String id);

    boolean checkLikeRelation(Integer userId, String id);

    Set<Integer> getLikeUserIdSetByAOCId(String aocId);
}
