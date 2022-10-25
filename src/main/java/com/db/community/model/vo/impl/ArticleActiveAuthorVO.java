package com.db.community.model.vo.impl;

import com.db.community.model.vo.ArticleVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ArticleActiveAuthorVO implements ArticleVO, Serializable {

    private Integer authorId;

    private Long articleCount;
}
