package com.db.community;

import com.db.community.model.document.message.LikeNotion;
import com.db.community.model.document.message.Message;
import com.db.community.model.document.message.UserPrivateMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class TestNewMessage {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TestNewMessage(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Test
    public void testAddNotion() {
//        LikeNotion message = new LikeNotion(3, "1");
//        message.setNotionUserId(1);
//        mongoTemplate.insert(message);

//        List<LikeNotion> all = mongoTemplate.findAll(LikeNotion.class);
//        all.forEach(ite -> {
//            System.out.println(ite.getMessageId());
//            System.out.println(ite.getCreateTime().toString());
//        });
        Message message = new UserPrivateMessage(2, 1, "测试");
        mongoTemplate.insert(message);

    }
}
