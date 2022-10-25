package com.db.community.model.vo.impl;

import com.db.community.model.vo.TagVO;
import lombok.Data;

import java.util.Date;

@Data
public class TagInfoVO implements TagVO {

    private String tagId;

    private String tagName;

    private Date createTime;

    private Long articleCount;
}
