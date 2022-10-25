package com.db.community.model.document.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document("comments")
public class Comment {

    @Id
    private String commentId;

    /**
     * 评论的类型 0：文章的评论  1：评论的评论(也叫回复)
     */
    private int type;

    /**
     * 发送者的id，游客的id统一为 -1
     */
    private Integer userId;

    /**
     * 评论的目标id，可以是文章id或评论id
     */
    private String targetId;

    /**
     * 评论内容
     */
    private String content;

    private Date createTime;

    private Date modifyTime;

    private Boolean deleted;

    /**
     * 新增评论时最常用的构造器方法
     */
    public Comment(int type, Integer userId, String targetId, String content) {
        // 调用基本构造方法
        this(type, targetId, content);
        this.userId = userId;
    }

    /**
     * 只包含基本信息的构造方法
     */
    public Comment(int type, String targetId, String content) {
        this.type = type;
        this.targetId = targetId;
        this.content = content;
        // 对一些未传值的字段进行初始化
        Date now = new Date();
        this.createTime = now;
        this.modifyTime = now;
        this.deleted = false;
        // 没有发送者id时视为游客发布的评论，使用默认id
        this.userId = -1;
    }

    public Comment(int type, Integer userId, String targetId, String content, Date createTime, Date modifyTime, Boolean deleted) {
        this.type = type;
        this.userId = userId;
        this.targetId = targetId;
        this.content = content;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.deleted = deleted;
    }
}
