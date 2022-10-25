package com.db.community.model.vo.impl;

import com.db.community.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户的预览信息
 */
@Data
public class UserPreviewInfoVO implements UserVO, Serializable {

    private Serializable userId;

    private String nickName;

    private String avatar;

    private String introduce;
}
