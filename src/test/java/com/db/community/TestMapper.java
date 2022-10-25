package com.db.community;

import com.db.community.mapper.MiddleTableMapper;
import com.db.community.model.mtb.MiddleTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMapper {

    @Autowired
    private MiddleTableMapper middleTableMapper;

}
