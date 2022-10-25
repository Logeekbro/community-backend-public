package com.db.community;

import com.db.community.model.vo.SingleKeyVO;
import com.db.community.utils.SingleKeyVOFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class TestSingleKeyVOFactory {

    @Test
    public void testAdd() {
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                SingleKeyVO jsonObject = SingleKeyVOFactory.getSingleKeyVO();
                jsonObject.setValue(finalI);
                System.out.println("获取到json：" + jsonObject);
                SingleKeyVOFactory.recycleVO(jsonObject);
            });
        }
    }
}
