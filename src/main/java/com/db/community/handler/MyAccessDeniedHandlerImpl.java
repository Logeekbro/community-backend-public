package com.db.community.handler;

import com.alibaba.fastjson.JSONObject;
import com.db.community.common.api.ResponseEntity;
import com.db.community.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用户权限不足的统一返回
 */
@Component
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseEntity<Object> result = ResponseEntity.forbidden(null);
        String jsonString = JSONObject.toJSONString(result);
        WebUtils.renderString(response, jsonString);
    }
}
