package com.db.community.model.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 接收前端传来的用户设置数据的DTO
 */
@Data
public class UserSettingInfoDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * User-昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickName;

    /**
     * User-头像
     */
    private String avatar;

    /**
     * User-邮箱
     */
    @Email(message = "邮箱格式有误")
    private String email;

    /**
     * User-QQ号
     */

    private String qq;

    /**
     * User-简介
     */
    private String introduce;
}
