package com.db.community.model.vo.impl;

import com.db.community.model.vo.ArticleVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章的主要信息
 */
@Data
public class ArticleInfoVO implements ArticleVO, Serializable {
    /**
     * 主键
     */
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
     * 分区id
     */
    private Integer sectionId;

    /**
     * 文章封面图片
     */
    private String mainPic;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 创建时间
     */
    private Date createTime;


}
