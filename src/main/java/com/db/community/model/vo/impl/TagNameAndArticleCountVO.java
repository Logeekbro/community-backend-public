package com.db.community.model.vo.impl;

import com.db.community.model.vo.TagVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class TagNameAndArticleCountVO implements TagVO, Serializable {

    private String tagName;

    private Long articleCount;
}
