package com.db.community.model.vo.impl;


import com.db.community.model.enums.MessageType;
import com.db.community.model.vo.MessageVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfoVO implements MessageVO, Serializable {

    private String messageId;

    private Integer senderId;

    private Integer targetId;

    private String content;

    private MessageType type;

    private Date createTime;
}
