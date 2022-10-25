package com.db.community.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.model.entity.Notification;
import com.db.community.model.vo.impl.NotificationVO;
import com.db.community.service.NotificationService;
import com.db.community.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86136
* @description 针对表【tb_notification】的数据库操作Service实现
* @createDate 2022-05-19 20:29:22
*/
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification>
    implements NotificationService{

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public NotificationVO getNotification() {
        LambdaQueryWrapper<Notification> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Notification::getDisplay, 1);
        queryWrapper.orderByDesc(Notification::getCreateTime);
        queryWrapper.last("limit 1");
        Notification notification = notificationMapper.selectOne(queryWrapper);
        NotificationVO notificationVO = new NotificationVO();
        BeanUtil.copyProperties(notification, notificationVO);
        return notificationVO;
    }
}




