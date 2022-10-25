package com.db.community.mapper;

import com.db.community.model.entity.Notification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86136
* @description 针对表【tb_notification】的数据库操作Mapper
* @createDate 2022-05-19 20:29:22
* @Entity com.db.community.model.entity.Notification
*/
@Mapper
public interface NotificationMapper extends BaseMapper<Notification> {

}




