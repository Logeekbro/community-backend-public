package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName tb_reply
 */
@TableName(value ="tb_reply")
@Data
@Accessors(chain = true)
public class Reply implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String replyId;

    /**
     * 回复的评论id
     */
    private String commentId;

    /**
     * 回复者的id
     */
    private Integer userId;

    /**
     * 回复的内容
     */
    private String content;

    /**
     * 要回复的用户id，如果为空则回复评论
     */
    private String target;

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
     * 逻辑删除， 0-未删除  1-删除
     */
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}