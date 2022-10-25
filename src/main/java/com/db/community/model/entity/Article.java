package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_article
 */
@TableName(value ="tb_article")
@Data
public class Article implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 作者id
     */
    private Integer authorId;

    /**
     * 文章封面
     */
    private String mainPic;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 分区id
     */
    private Integer sectionId;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 是否置顶，0-不置顶  1-置顶
     */
    private Boolean top;

    /**
     * 状态 0-正常 1-待审核 2-审核不通过 3-新发布且还未被管理员查看的文章  状态为1或2的记录对应的deleted字段应为1
     */
    private Integer status;

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
     * 逻辑删除， 0-未删除  1-删除
     */
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}