package com.db.community.model.vo.impl;

import com.db.community.model.vo.ReplyVO;
import lombok.Data;

import java.util.Date;

@Data
public class ReplyInfoVO implements ReplyVO {

    private String replyId;

    private String content;

    private Date createTime;

}
