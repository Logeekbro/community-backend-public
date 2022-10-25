package com.db.community.model.vo.impl;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页公告信息
 */
@Data
public class NotificationVO implements Serializable {

    /**
     * 通知内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;


    private static final long serialVersionUID = 1L;

}