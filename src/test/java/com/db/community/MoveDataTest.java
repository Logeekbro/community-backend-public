package com.db.community;

import com.db.community.model.document.comment.Comment;
import com.db.community.model.entity.Reply;
import com.db.community.service.CommentService;
import com.db.community.service.ReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class MoveDataTest{

    private CommentService commentService;

    private MongoTemplate mongoTemplate;

    private ReplyService replyService;

    @Autowired
    public MoveDataTest(CommentService commentService, MongoTemplate mongoTemplate, ReplyService replyService) {
        this.commentService = commentService;
        this.mongoTemplate = mongoTemplate;
        this.replyService = replyService;
    }

    @Test
    public void MoveCommentsFromMySQLToMongoDB() {
//        List<Comment> commentList = commentService.list();
        List<Reply> commentList = replyService.list();
        List<Comment> collect = commentList.stream().map(comment -> new Comment(0, comment.getUserId(), "1", comment.getContent(),
                comment.getCreateTime(), comment.getModifyTime(), false)).collect(Collectors.toList());
        mongoTemplate.insert(collect, Comment.class);

    }
}
