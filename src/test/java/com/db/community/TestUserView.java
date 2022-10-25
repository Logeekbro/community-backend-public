package com.db.community;

import com.db.community.mq.provider.UserViewProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestUserView {

    @Resource
    UserViewProvider userViewProvider;

    @Test
    public void testConCurrentSaveView() throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                userViewProvider.saveUserView(finalI + "", finalI);
            });
        }
        TimeUnit.SECONDS.sleep(30);
    }
}
