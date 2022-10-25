package com.db.community.handler;

import com.alibaba.fastjson.JSONObject;
import com.db.community.common.api.ResponseEntity;
import com.db.community.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未认证时的统一返回信息
 */
@Component
public class MyAuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseEntity<Object> result = ResponseEntity.unauthorized(null);
        if(authException instanceof BadCredentialsException){
            result = ResponseEntity.failed(authException.getMessage());
        }
        String jsonString = JSONObject.toJSONString(result);
        WebUtils.renderString(response, jsonString);
    }
}
