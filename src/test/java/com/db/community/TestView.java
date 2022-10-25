package com.db.community;

import com.db.community.mapper.ViewMapper;
import com.db.community.model.vo.impl.ViewHistoryInfoVO;
import com.db.community.model.vo.impl.ViewHistoryInfoWithDateVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestView {

    @Resource
    private ViewMapper viewMapper;

    @Test
    public void testUserHistoryByDate() {
        List<ViewHistoryInfoVO> vo = viewMapper.selectUserHistoryByDate(1, "2022-6-18");
        System.out.println(vo);
    }

    @Test
    public void testBeforeDate() {
        String beforeDate = viewMapper.selectBeforeDate(1,"2022/6/18");
        System.out.println(beforeDate);
    }
}
