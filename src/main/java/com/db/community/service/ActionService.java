package com.db.community.service;

public interface ActionService {

    /**
     * 进行点赞或取消点赞
     *
     * @param userId 点赞者的id
     * @param id     被点赞的id
     * @return true：点赞  false：取消点赞
     */
    boolean handleLike(Integer userId, String id);

    Double getLikeCount(String id);

    Boolean checkLike(Integer userId, String id);

    void saveLikeCountToDB();

    void loadLikeCountFromDB();

    void saveLikeRelationToDB();

    void loadLikeRelationFromDB();

    void handleGuestLike(String articleId);
}
