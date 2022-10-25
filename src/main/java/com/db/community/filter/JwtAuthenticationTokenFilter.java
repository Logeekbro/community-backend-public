package com.db.community.filter;

import com.db.community.model.auth.LoginUser;
import com.db.community.utils.JwtUtil;
import com.db.community.utils.RedisCache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 自定义过滤器，检测请求头中的token是否有效
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 检测请求头中是否携带userToken
        String token = request.getHeader("userToken");
        if (!StringUtils.hasText(token)) {
            // 如果不存在则放行到下一个过滤器并终止程序
            filterChain.doFilter(request, response);
            return;
        }
        // 使用Jwt工具解析token中的userId
        Integer userId;
        try {
            userId = JwtUtil.getUserId(token);
            // 将本次请求的userId放入request以便控制器方法获取
            request.setAttribute("userId", userId);
        } catch (Exception e) {
            e.printStackTrace();
            filterChain.doFilter(request, response);
            return;
        }
        // 获取已登录用户的信息
        LoginUser loginUser = null;
        try {
            loginUser = redisCache.getCacheObject("login:" + userId);
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            e.printStackTrace();
            return;

        }
        if(Objects.isNull(loginUser)){
            filterChain.doFilter(request, response);
            return;
        }
        // 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        // 存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
