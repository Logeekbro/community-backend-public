package com.db.community.common;

import java.util.Set;

public class RedisNameSpace {

    // 用户id集合
    public static final String USER_ID_SET_KEY = "userIds";
    // 文章id集合
    public static final String ARTICLE_ID_SET_KEY = "articleIds";
    // 登录时的验证码前缀
    public static final String LOGIN_VERIFY_CODE_PREFIX = "user:login:verify:";
    // 验证成功的授权码前缀
    public static final String LOGIN_ACCESS_TOKEN_PREFIX = "user:login:accessToken:";
    // 评论数前缀
    public static final String COMMENT_COUNT_PREFIX = "comment:count:";
    // 浏览量前缀
    public static final String VIEW_COUNT_PREFIX = "view:count:";
    // 组成验证码的汉字集合
    public static final String VERIFY_WORD_SET = "verifyWord:set:";
}
