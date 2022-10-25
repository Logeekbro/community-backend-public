package com.db.community.mq.consumer;


import com.db.community.model.document.message.LikeNotion;
import com.db.community.model.document.message.ReviewResultNotion;
import com.db.community.model.dto.SendMessageDTO;
import com.db.community.model.vo.impl.ArticleInfoVO;
import com.db.community.model.vo.impl.UserOpenInfoVO;
import com.db.community.mq.QueueNameSpace;
import com.db.community.service.ArticleService;
import com.db.community.service.MessageService;
import com.db.community.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;


@Component
@Slf4j
public class SystemMessageConsumer {

    @Resource
    private MessageService messageService;

    @Resource
    private UserService userService;

    @Resource
    private ArticleService articleService;

    @Resource
    private MongoTemplate mongoTemplate;


    @RabbitListener(queuesToDeclare = @Queue("mySystem.message"))
    public void handleSendSystemMessage(Map<String, Object> map) {
        try{
            String articleId = (String) map.get("articleId");
            Integer userId = (Integer) map.get("userId");
            UserOpenInfoVO userOpenInfo = userService.getUserOpenInfoById(userId);
            if(userOpenInfo == null) return;
            ArticleInfoVO articleDetail = (ArticleInfoVO) articleService.getArticleDetailByArticleId(articleId, false);
            if(!Objects.equals(userId, articleDetail.getAuthorId())) {
                String content = userOpenInfo.getNickName() + "(id:" + userId + ")" +
                        "点赞了你的文章：《" + articleDetail.getTitle() + "》" + "(id:" + articleId + ")";
                SendMessageDTO messageDTO = new SendMessageDTO();
                messageDTO.setSenderId(12);
                messageDTO.setTargetId(articleDetail.getAuthorId());
                messageDTO.setContent(content);
                messageService.createMessage(messageDTO);
            }
        }
        catch (Exception e) {
            log.info("发送系统消息失败->" + e.getCause() + ":" + e.getMessage());
        }
    }

    @RabbitListener(queuesToDeclare = @Queue(QueueNameSpace.LIKE_NOTION))
    public void handleSendLikeNotion(LikeNotion likeNotion) {
        Integer authorId = articleService.getAuthorIdByArticleId(likeNotion.getBeLikeId());
        // 当作者id存在且 作者id != 点赞者id 时发送通知
        if(authorId != null && !Objects.equals(likeNotion.getLikeUserId(), authorId)) {
            likeNotion.setTargetId(authorId);
            mongoTemplate.insert(likeNotion);
        }
    }

    @RabbitListener(queuesToDeclare = @Queue(QueueNameSpace.REVIEW_RESULT_NOTION))
    public void handleSendReviewResultNotion(ReviewResultNotion reviewResultNotion) {
        Integer authorId = articleService.getAuthorIdByArticleId(reviewResultNotion.getArticleId());
        reviewResultNotion.setTargetId(authorId);
        mongoTemplate.insert(reviewResultNotion);
    }
}
