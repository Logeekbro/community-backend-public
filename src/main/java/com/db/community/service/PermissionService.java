package com.db.community.service;

import java.util.List;

public interface PermissionService {

    List<String> getAuthoritiesByUserId(Integer userId);

    List<Integer> getUserRoleIdList(Integer userId);
}
