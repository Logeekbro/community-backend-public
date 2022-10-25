package com.db.community;

import com.db.community.service.VerifyService;
import com.db.community.utils.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Queue;

@SpringBootTest
public class TestVerifyWord {


    @Resource
    private VerifyService verifyService;

    @Test
    public void test1() {
        Queue<Integer> intQueue = RandomUtil.getDistinctRandomAsciiIntQueue(12);
        for (int i = 0; i < intQueue.size(); i++) {
            System.out.println("================");
            Integer integer = intQueue.poll();
            int k = integer & 1;
            int j = integer | 1;
            System.out.println(integer);
            System.out.println(k);
            System.out.println(j);
        }

    }

    @Test
    public void test2() {
        verifyService.startVerify();
    }
}
