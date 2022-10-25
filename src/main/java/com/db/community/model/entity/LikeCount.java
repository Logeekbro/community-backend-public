package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("tb_like_count")
@Data
public class LikeCount implements Serializable {

    /**
     * 文章或评论id
     */
    @TableId
    private String aocId;

    /**
     * 点赞数
     */
    private Double count;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date modifyTime;


    /**
     * 逻辑删除，0-未删除  1-删除
     */
    private Boolean deleted;
}
