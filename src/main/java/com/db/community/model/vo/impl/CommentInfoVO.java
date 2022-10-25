package com.db.community.model.vo.impl;

import com.db.community.model.vo.CommentVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论信息
 */
@Data
public class CommentInfoVO implements CommentVO, Serializable {

    private Serializable commentId;

    private String content;

    private Date createTime;
}
