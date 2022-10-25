package com.db.community;

import com.db.community.mapper.TagMapper;
import com.db.community.model.vo.impl.TagInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestSelectTag {

    @Resource
    private TagMapper tagMapper;

    @Test
    public void test() {
        List<TagInfoVO> vos = tagMapper.selectTagInfoByTagName("%", 0L, 3L);
        vos.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Long aLong = tagMapper.selectTagCountByTagName("%");
        System.out.println(aLong);
    }
}
