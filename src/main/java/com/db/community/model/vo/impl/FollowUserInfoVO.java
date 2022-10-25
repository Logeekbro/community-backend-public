package com.db.community.model.vo.impl;

import com.db.community.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FollowUserInfoVO implements UserVO, Serializable {

    private Integer userId;

    private String nickName;

    private String avatar;

    private String introduce;

    private Date createTime;
}
