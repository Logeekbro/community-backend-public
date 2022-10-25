package com.db.community.common;

import com.db.community.service.ActionService;
import com.db.community.service.CacheService;
import com.db.community.service.CountService;
import com.db.community.service.VerifyService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 程序启动时执行的代码
 */
@Component
public class OnStart implements ApplicationRunner {

    @Resource
    private CacheService cacheService;

    @Resource
    private CountService countService;

    @Resource
    private ActionService actionService;

    @Resource
    private VerifyService verifyService;


    /**
     * 启动时的初始化任务
     * @param args
     *
     */
    @Override
    public void run(ApplicationArguments args) {
        // 将IdSet加载到Redis
        cacheService.refreshArticleIdSetCache();
        cacheService.refreshUserIdSetCache();
        // 将浏览量加载到Redis
        countService.loadCacheFromDB();
        // 将点赞数加载到Redis
        actionService.loadLikeCountFromDB();
        // 将点赞关系加载到Redis
        actionService.loadLikeRelationFromDB();
        // 将数据库中用于验证的汉字集合加载到Redis
        verifyService.loadVerifyWordFromDB();
        // 初始化SingleKeyVOFactory
//        SingleKeyVOFactory.init();

    }
}
