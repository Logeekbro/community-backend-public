package com.db.community.service.impl;


import com.db.community.exception.ApiAsserts;
import com.db.community.model.document.message.*;
import com.db.community.model.dto.SendMessageDTO;
import com.db.community.service.MessageService;
import com.db.community.utils.MongoUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.db.community.common.GlobalVars.SYSTEM_ID;

/**
* @author bin
* @description 针对表【tb_message】的数据库操作Service实现
* @createDate 2022-07-04 18:13:16
*/
@Service
public class MessageServiceImpl implements MessageService{


    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public Message createMessage(SendMessageDTO messageDTO) {
        if(Objects.equals(messageDTO.getTargetId(), messageDTO.getSenderId())) ApiAsserts.fail("不能发消息给自己");
        UserPrivateMessage userPrivateMessage = new UserPrivateMessage(messageDTO.getSenderId(), messageDTO.getTargetId(), messageDTO.getContent());
        return mongoTemplate.insert(userPrivateMessage);
    }

    @Override
    public List<UserPrivateMessage> getAllHasReadMessageByUserId(Integer userId) {
        Query query = new Query(MongoUtil.notDeletedCriteria().
                and("isRead").is(true).
                orOperator(Criteria.where("senderId").is(userId), Criteria.where("targetId").is(userId)));
        return mongoTemplate.find(query, UserPrivateMessage.class);
    }

    @Override
    public void updateReadStatus(Integer senderId, Integer userId) {
        Query query;
        Class<? extends Message> target;
        if(Objects.equals(senderId, SYSTEM_ID)) {
            query = new Query(MongoUtil.notDeletedCriteria().
                    and("isRead").is(false).
                    and("targetId").is(userId));
            target = LikeNotion.class;
        }
        else {
            query = new Query(MongoUtil.notDeletedCriteria().
                    and("isRead").is(false).
                    and("senderId").is(senderId).
                    and("targetId").is(userId));
            target = UserPrivateMessage.class;
        }
        Update update = new Update();
        update.set("isRead", true);
        mongoTemplate.updateMulti(query, update, target);
    }


    @Override
    public Long getAllUnReadCount(Integer userId) {
        Query query = new Query(MongoUtil.notDeletedCriteria().
                and("isRead").is(false).
                and("targetId").is(userId));
        return mongoTemplate.count(query, UserPrivateMessage.class) + mongoTemplate.count(query, Notion.class);
    }


    @Override
    public List<UserPrivateMessage> getAllUnReadMessageByUserId(Integer userId) {
        Query query = new Query(MongoUtil.notDeletedCriteria().
                and("isRead").is(false).
                and("targetId").is(userId));
        return mongoTemplate.find(query, UserPrivateMessage.class);
    }

    @Override
    public List<Notion> getAllSystemMessageByUserId(Integer userId) {
        Query query = new Query(MongoUtil.notDeletedCriteria().and("targetId").is(userId));
        List<Notion> all = mongoTemplate.find(query, Notion.class);
        return all;
    }

}




