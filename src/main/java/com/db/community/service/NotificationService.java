package com.db.community.service;

import com.db.community.model.entity.Notification;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.impl.NotificationVO;

/**
* @author 86136
* @description 针对表【tb_notification】的数据库操作Service
* @createDate 2022-05-19 20:29:22
*/
public interface NotificationService extends IService<Notification> {

    NotificationVO getNotification();
}
