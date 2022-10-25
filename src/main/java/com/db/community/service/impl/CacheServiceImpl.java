package com.db.community.service.impl;

import com.db.community.mapper.ArticleMapper;
import com.db.community.mapper.UserMapper;
import com.db.community.model.dto.VerifyDTO;
import com.db.community.service.CacheService;
import com.db.community.utils.RedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.db.community.common.RedisNameSpace.*;

@Service
public class CacheServiceImpl implements CacheService {

    public static final Integer LOGIN_VERIFY_CODE_EXPIRE_TIME = 3 * 60;

    public static final Integer LOGIN_ACCESS_TOKEN_EXPIRE_TIME= 5 * 60;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisCache redisCache;

    @Override
    public <T> T getCacheObject(String key) {
        return redisCache.getCacheObject(key);
    }

    @Override
    public <T> void setCacheObject(String key, final T value) {
        redisCache.setCacheObject(key, value);
    }

    @Override
    public boolean deleteObject(String key) {
        return redisCache.deleteObject(key);
    }

    @Override
    public void refreshArticleIdSetCache() {
        Set<String> articleIdSet = articleMapper.getArticleIdSet();
        redisCache.setCacheSet(ARTICLE_ID_SET_KEY, articleIdSet);
    }

    @Override
    public void refreshUserIdSetCache() {
        Set<Integer> userIdSet = userMapper.getUserIdSet();
        redisCache.setCacheSet(USER_ID_SET_KEY, userIdSet);
    }

    @Override
    public Boolean isArticleIdSetMember(Serializable id) {
        return redisCache.isSetMember(ARTICLE_ID_SET_KEY, id);
    }

    @Override
    public Boolean isUserIdSetMember(Serializable id) {
        return redisCache.isSetMember(USER_ID_SET_KEY, id);
    }

    @Override
    public void saveCache(String mapKey, String objectKey, Object value) {
        redisCache.saveCache(mapKey, objectKey, value);
    }

    @Override
    public void setLoginVerifyCode(String verifyId, VerifyDTO value) {
        redisCache.setCacheObject(LOGIN_VERIFY_CODE_PREFIX + verifyId, value, LOGIN_VERIFY_CODE_EXPIRE_TIME, TimeUnit.SECONDS);
    }

    @Override
    public VerifyDTO getLoginVerifyCode(String verifyId) {
        return redisCache.getCacheObject(LOGIN_VERIFY_CODE_PREFIX + verifyId);
    }

    @Override
    public boolean deleteLoginVerifyCode(String verifyId) {
        return redisCache.deleteObject(LOGIN_VERIFY_CODE_PREFIX + verifyId);
    }

    @Override
    public void setLoginAccessToken(String account, String value) {
        redisCache.setCacheObject(LOGIN_ACCESS_TOKEN_PREFIX + account, value, LOGIN_ACCESS_TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
    }

    @Override
    public String getLoginAccessToken(String account) {
        return redisCache.getCacheObject(LOGIN_ACCESS_TOKEN_PREFIX + account);
    }

    @Override
    public boolean deleteLoginAccessToken(String account) {
        return redisCache.deleteObject(LOGIN_ACCESS_TOKEN_PREFIX + account);
    }
}
