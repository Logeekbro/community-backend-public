package com.db.community.model.vo.impl;

import com.db.community.model.vo.ArticleVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class ArticleAndAuthorInfoVO implements ArticleVO, Serializable {

    private String articleId;
    private String title;
    private String summary;
    private String mainPic;
    private Boolean top;
    private Date createTime;
    private Integer authorId;
    private String nickName;
}
