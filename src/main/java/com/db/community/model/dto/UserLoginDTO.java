package com.db.community.model.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserLoginDTO {

    @NotEmpty(message = "账号不能为空")
    @Size(min = 1, max = 16, message = "账号长度必须在1-16位之间")
    private String account;
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6-20位之间")
    private String password;
    private String accessToken;
}
