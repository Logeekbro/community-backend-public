package com.db.community.mq.provider;


import com.db.community.model.document.message.LikeNotion;
import com.db.community.model.document.message.ReviewResultNotion;
import com.db.community.mq.QueueNameSpace;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Component
public class SystemMessageProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;



    public void sendSystemMessageWhenArticleBeLike(String articleId, Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);
        map.put("userId", userId);
        rabbitTemplate.convertAndSend("mySystem.message", map);
    }

    public void sendLikeNotion(LikeNotion likeNotion) {
        rabbitTemplate.convertAndSend(QueueNameSpace.LIKE_NOTION, likeNotion);
    }

    public void sendReviewResultNotion(ReviewResultNotion reviewResultNotion) {
        rabbitTemplate.convertAndSend(QueueNameSpace.REVIEW_RESULT_NOTION, reviewResultNotion);
    }
}
