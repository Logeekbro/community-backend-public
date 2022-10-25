package com.db.community.model.vo.impl;

import com.db.community.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 具体的用户信息
 */

@Data
public class UserDetailInfoVO implements UserVO, Serializable {

    private Integer userId;

    private String account;

    private String nickName;

    private String avatar;

    private Date createTime;

    private String introduce;

    private String email;

    private String qq;
}
