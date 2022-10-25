package com.db.community.model.vo.detail;

import com.db.community.model.vo.ArticleVO;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.ViewInfoVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ViewDetailVO implements Serializable {

    private ArticleVO article;

    private UserVO author;

    private ViewInfoVO view;
}
