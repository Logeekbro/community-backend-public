package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.db.community.common.api.ApiResultDetail;
import com.db.community.exception.ApiAsserts;
import com.db.community.mapper.UserMapper;
import com.db.community.model.auth.LoginUser;
import com.db.community.model.entity.User;
import com.db.community.service.PermissionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount, account);
        User user = userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(null);
        }
        else if(!user.getStatus()) {
            ApiAsserts.fail(ApiResultDetail.BANED);
        }
        // 设置用户权限信息
        return new LoginUser(user, permissionService.getAuthoritiesByUserId(user.getUserId()));
    }
}
