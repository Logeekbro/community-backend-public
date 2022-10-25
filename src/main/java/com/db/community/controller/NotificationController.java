package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.impl.NotificationVO;
import com.db.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Resource
    private NotificationService notificationService;

    /**
     * 获取公告信息
     */
    @RequestMapping("")
    public ResponseEntity<NotificationVO> getNotification(){
        return ResponseEntity.success(notificationService.getNotification());
    }
}
