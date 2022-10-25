package com.db.community;

import com.db.community.mapper.PermissionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestGetPermission {

    @Resource
    private PermissionMapper permissionMapper;

    @Test
    public void getPerms() {
        List<String> permissionsByUserId = permissionMapper.selectPermissionsByUserId(1);
        permissionsByUserId.forEach(System.out::println);
    }
}
