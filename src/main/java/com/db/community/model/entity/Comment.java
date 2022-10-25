package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_comment
 */
@TableName(value ="tb_comment")
@Data
public class Comment implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String commentId;

    /**
     * 评论者id
     */
    private Integer userId;

    /**
     * 被评论的文章id
     */
    private String articleId;

    /**
     * 评论内容
     */
    private String content;

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
     * 逻辑删除，0-未删除  1-删除
     */
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 153215L;
}