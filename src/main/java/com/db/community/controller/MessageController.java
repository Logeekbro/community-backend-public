package com.db.community.controller;


import com.db.community.common.api.ResponseEntity;
import com.db.community.model.document.message.Message;
import com.db.community.model.document.message.Notion;
import com.db.community.model.document.message.SystemMessage;
import com.db.community.model.document.message.UserPrivateMessage;
import com.db.community.model.dto.SendMessageDTO;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.impl.MessageInfoVO;
import com.db.community.service.MessageService;
import com.db.community.utils.RequestUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;


    /**
     * 发送消息
     *
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<Message> sendMessage(@RequestBody SendMessageDTO messageDTO,
                                                     HttpServletRequest request) {
        messageDTO.setSenderId(RequestUtil.getUserId(request));
        Message messageInfoVO = messageService.createMessage(messageDTO);
        if (messageInfoVO != null) return ResponseEntity.success(messageInfoVO);
        return ResponseEntity.failed();
    }

    /**
     * 获取与用户有关的所有私信已读消息
     */
    @RequestMapping("/private/all")
    public ResponseEntity<List<UserPrivateMessage>> getAllMessage(HttpServletRequest request) {
        List<UserPrivateMessage> list = messageService.getAllHasReadMessageByUserId(RequestUtil.getUserId(request));
        return ResponseEntity.success(list);
    }

    /**
     * 获取与用户有关的所有私信未读消息
     */
    @RequestMapping("/unRead/all")
    public ResponseEntity<List<UserPrivateMessage>> getAllUnReadMessage(HttpServletRequest request) {
        List<UserPrivateMessage> list = messageService.getAllUnReadMessageByUserId(RequestUtil.getUserId(request));
        return ResponseEntity.success(list);
    }

    /**
     * 获取所有系统消息
     */
    @RequestMapping("/system")
    public ResponseEntity<List<Notion>> getAllSystemMessage(HttpServletRequest request) {
        List<Notion> list = messageService.getAllSystemMessageByUserId(RequestUtil.getUserId(request));
        return ResponseEntity.success(list);
    }

    /**
     * 将消息设为已读
     */
    @RequestMapping(value = "/hasRead/{senderId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateReadStatus(@PathVariable("senderId") Integer senderId,
                                                 HttpServletRequest request) {
        messageService.updateReadStatus(senderId, RequestUtil.getUserId(request));
        return ResponseEntity.success();
    }

    /**
     * 获取用户所有未读消息数
     */
    @RequestMapping(value = "/unReadCount/all", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getAllUnReadCount(HttpServletRequest request) {
        Long count = messageService.getAllUnReadCount(RequestUtil.getUserId(request));
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }

}
