package com.db.community.common;

import com.db.community.model.entity.View;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 全局变量
 */
public class GlobalVars {

    // JWT密钥
    public static final String JWT_KEY = "xxx";

    // JWT token 过期时间
    public static final Long JWT_EXPIRE = 10 * 24 * (60 * 60 * 1000L); // 60 * 60 *1000 = 一个小时

    // 阿里云RAM用户的accessKeyId
    public static final String ALIYUN_AK = "xxx";

    // 阿里云RAM用户的accessKeySecret
    public static final String ALIYUN_AS = "xxx";

    // OSS的endpoint
    public static final String OSS_ENDPOINT = "oss-cn-guangzhou.aliyuncs.com";

    // OSS文件的访问url前缀
    public static final String OSS_FILE_PREFIX = "http://db-community.oss-cn-guangzhou.aliyuncs.com/";

    // 头像的url前缀
    public static final String AVATAR_URL_PREFIX = "avatar/";

    // 允许的文章和头像图片类型
    public static final List<String> ACCEPT_IMG_TYPE = new ArrayList<>(Arrays.asList("png", "jpg"));

    // 文章图片的url前缀
    public static final String ARTICLE_IMG_URL_PREFIX = "article/";

    // 文章封面图片的url前缀
    public static final String ARTICLE_MAIN_PIC_PREFIX = "article/mainPic/";

    // OSS BucketName
    public static final String BUCKET_NAME = "db-community";

    // 中间表前缀
    public static final String MTB_PREFIX = "mtb_";

    // ---------------------中间表可见性------------------------------

    // 中间表记录可见性的字段名
    public static final String VISIBLE_FILED_NAME = "visible";

    // 表示可见的值
    public static final String VISIBLE_VALUE = "1";

    // 表示不可见的值
    public static final String UN_VISIBLE_VALUE = "0";

    // ------------------------------------------------------------

    // 浏览记录队列
    public static final Queue<View> VIEW_QUEUE = new LinkedList<>();

    // 公共线程池
    public static final ExecutorService COMMON_THREAD_POOL = Executors.newFixedThreadPool(100);

    //
    public static final Integer SYSTEM_ID = -1;

}
