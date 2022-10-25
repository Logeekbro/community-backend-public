package com.db.community.model.vo.impl;

import com.db.community.model.vo.ArticleVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章的预览信息
 */
@Data
public class ArticlePreviewInfoVO implements ArticleVO, Serializable {

    private Serializable articleId;

    private String title;

    private Date createTime;

    private Long viewCount;
}
