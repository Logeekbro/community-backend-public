package com.db.community;

import com.db.community.mapper.TagMapper;
import com.db.community.model.vo.impl.TagIdAndNameVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestTag {

    @Resource
    private TagMapper tagMapper;

    @Test
    public void test1() {
        TagIdAndNameVO vo1 = new TagIdAndNameVO();
        vo1.setTagId("123");
        vo1.setTagName("abc");
        TagIdAndNameVO vo2 = new TagIdAndNameVO();
        vo2.setTagId("123");
        vo2.setTagName("abc");
        TagIdAndNameVO vo3 = new TagIdAndNameVO();
        vo3.setTagId("234");
        vo3.setTagName("efg");
        List<TagIdAndNameVO> list = new ArrayList<>();
        list.add(vo2);
        list.add(vo3);
        System.out.println(list.contains(vo1));
    }
}
