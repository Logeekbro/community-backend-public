package com.db.community.model.vo.impl;

import com.db.community.model.vo.ArticleVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户自己的文章列表
 */
@Data
public class UserArticleListVO implements ArticleVO, Serializable {

    private String articleId;

    private String authorId;

    private String title;

    private Date createTime;

    private Date modifyTime;
}
