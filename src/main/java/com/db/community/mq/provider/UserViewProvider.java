package com.db.community.mq.provider;

import com.db.community.model.entity.View;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserViewProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void saveUserView(String articleId, Integer userId) {
        View view = new View();
        view.setArticleId(articleId);
        view.setReaderId(userId);
        rabbitTemplate.convertAndSend("userView.save", view);
    }
}
