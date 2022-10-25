package com.db.community;

import com.db.community.utils.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Queue;

@SpringBootTest
public class TestRandomInt {

    @Test
    public void test() {

        long start = System.currentTimeMillis();
        Queue<Integer> distinctRandomIntQueue = RandomUtil.getDistinctRandomAsciiIntQueue(6);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end -start));
    }
}
