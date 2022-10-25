package com.db.community.model.vo.impl;

import com.db.community.model.vo.ViewVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ViewInfoVO implements ViewVO, Serializable {

    private String viewId;

    private Date createTime;
}
