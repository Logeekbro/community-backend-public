package com.db.community.mapper;

import com.db.community.model.dto.SendMessageDTO;
import com.db.community.model.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.impl.MessageInfoVO;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;
import java.util.List;

/**
* @author bin
* @description 针对表【tb_message】的数据库操作Mapper
* @createDate 2022-07-04 18:13:16
* @Entity com.db.community.model.entity.Message
*/
public interface MessageMapper extends BaseMapper<Message> {

    List<MessageInfoVO> getAllReadMessageDetailByUserId(Integer userId);

    List<MessageInfoVO> getUnReadMessage(Integer targetId, Integer senderId);

    List<MessageInfoVO> getAllUnReadMessageDetailByUserId(Integer userId);

    void updateReadStatus(Integer senderId, Integer targetId);

}




