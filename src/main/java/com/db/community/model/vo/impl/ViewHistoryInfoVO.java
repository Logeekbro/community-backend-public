package com.db.community.model.vo.impl;


import com.db.community.model.vo.ViewVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ViewHistoryInfoVO implements ViewVO, Serializable {

    private String viewId;

    private String articleId;

    private String title;

    private String nickName;

    private String createTime;
}
