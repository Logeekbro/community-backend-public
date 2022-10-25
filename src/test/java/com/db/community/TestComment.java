package com.db.community;

import com.db.community.mapper.CommentMapper;
import com.db.community.model.vo.detail.CommentDetailInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestComment {

    @Resource
    private CommentMapper commentMapper;

    @Test
    public void test1() {
        List<CommentDetailInfoVO> commentDetailInfoVOS =
                commentMapper.selectCommentWithUserInfoListByArticleId("1538832627030269953", 0L, 5L);
        commentDetailInfoVOS.forEach(System.out::println);
    }
}
