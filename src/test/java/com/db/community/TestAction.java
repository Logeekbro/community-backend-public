package com.db.community;


import com.db.community.service.ActionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestAction {

    @Resource
    private ActionService actionService;

    @Test
    public void testSaveToDB() {
        actionService.saveLikeCountToDB();
    }
}
