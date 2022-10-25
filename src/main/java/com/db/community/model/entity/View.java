package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_view
 */
@TableName(value ="tb_view")
@Data
public class View implements Serializable {
    /**
     * 主键，浏览记录id
     */
    @TableId
    private String viewId;

    /**
     * 阅读者id
     */
    private Integer readerId;

    /**
     * 阅读的文章id
     */
    private String articleId;

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
    private static final long serialVersionUID = 53752752L;
}