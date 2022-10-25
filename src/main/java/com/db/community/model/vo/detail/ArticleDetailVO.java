package com.db.community.model.vo.detail;

import com.db.community.model.vo.ArticleVO;
import com.db.community.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * 与一篇文章有关的所有信息
 */
@Data
public class ArticleDetailVO implements Serializable {

    private UserVO author;

    private ArticleVO article;

    private Set<String> tags;

}
