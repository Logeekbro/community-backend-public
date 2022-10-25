package com.db.community;

import com.db.community.mapper.ArticleMapper;
import com.db.community.model.vo.impl.ArticleInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestArticleReview {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void testGetById() {
        List<ArticleInfoVO> articleInfoVOS = articleMapper.selectArticleListByStatusAndDeleted(2,2,true);
        articleInfoVOS.forEach(System.out::println);
    }
}
