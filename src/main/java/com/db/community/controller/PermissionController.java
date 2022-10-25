package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.service.PermissionService;
import com.db.community.utils.RequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 获取用户的角色id列表
     */
    @RequestMapping(value = "/roleIdList", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getUserRoleIdList(HttpServletRequest request) {
        List<Integer> roleIdList = permissionService.getUserRoleIdList(RequestUtil.getUserId(request));
        return ResponseEntity.success(roleIdList);
    }
}
