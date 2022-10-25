package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.db.community.model.enums.MessageType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName tb_message
 */
@TableName(value ="tb_message")
@Data
@Accessors(chain = true)
public class Message implements Serializable {
    /**
     * 主键，消息id
     */
    @TableId
    private String messageId;

    /**
     * 消息发送者的id
     */
    private Integer senderId;

    /**
     * 消息发送的目标id
     */
    private Integer targetId;

    /**
     * 是否被读取，0-未读取 1-已读取 默认0
     */
    private Boolean isRead;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息类型
     */
    private MessageType type;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    /**
     * 逻辑删除， 0-未删除  1-已删除
     */
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}