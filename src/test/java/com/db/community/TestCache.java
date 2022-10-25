package com.db.community;

import com.db.community.service.CacheService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestCache {

    @Resource
    private CacheService cacheService;

    @Test
    public void test1(){
        System.out.println(cacheService.isUserIdSetMember("8"));
    }
}
