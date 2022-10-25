package com.db.community.service;

import com.db.community.model.dto.VerifyDTO;

import java.io.Serializable;

public interface CacheService {

    <T> T getCacheObject(String key);

    <T> void setCacheObject(String key, final T value);

    boolean deleteObject(String key);

    void refreshArticleIdSetCache();

    void refreshUserIdSetCache();

    Boolean isArticleIdSetMember(Serializable id);

    Boolean isUserIdSetMember(Serializable id);

    void saveCache(String mapKey, String objectKey, Object value);

    void setLoginVerifyCode(String verifyId, VerifyDTO value);

    VerifyDTO getLoginVerifyCode(String verifyId);

    boolean deleteLoginVerifyCode(String verifyId);

    void setLoginAccessToken(String account, String value);

    String getLoginAccessToken(String account);

    boolean deleteLoginAccessToken(String account);
}
