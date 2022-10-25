package com.db.community.service.impl;

import com.db.community.mapper.PermissionMapper;
import com.db.community.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> getAuthoritiesByUserId(Integer userId) {
        return permissionMapper.selectPermissionsByUserId(userId);
    }

    @Override
    public List<Integer> getUserRoleIdList(Integer userId) {
        return permissionMapper.selectRoleIdListByUserId(userId);
    }
}
