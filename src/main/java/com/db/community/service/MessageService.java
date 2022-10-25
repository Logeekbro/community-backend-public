package com.db.community.service;

import com.db.community.model.document.message.Message;
import com.db.community.model.document.message.Notion;
import com.db.community.model.document.message.SystemMessage;
import com.db.community.model.document.message.UserPrivateMessage;
import com.db.community.model.dto.SendMessageDTO;
import java.util.List;

/**
* @author bin
* @description 针对表【tb_message】的数据库操作Service
* @createDate 2022-07-04 18:13:16
*/
public interface MessageService {

    Message createMessage(SendMessageDTO messageDTO);

    List<UserPrivateMessage> getAllHasReadMessageByUserId(Integer userId);

    void updateReadStatus(Integer senderId, Integer userId);

    Long getAllUnReadCount(Integer userId);

    List<UserPrivateMessage> getAllUnReadMessageByUserId(Integer userId);

    List<Notion> getAllSystemMessageByUserId(Integer userId);
}
