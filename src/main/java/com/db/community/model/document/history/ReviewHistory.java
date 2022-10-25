package com.db.community.model.document.history;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document("review_histories")
@Data
public class ReviewHistory implements Serializable {

    @Id
    private String historyId;

    /**
     * 被审核的文章id
     */
    private String articleId;

    /**
     * 审核此篇文章的管理员的用户id
     */
    private Integer userId;

    /**
     * 是否审核通过
     */
    private Boolean isPass;

    /**
     * 审核不通过时的描述信息
     */
    private String description;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    public ReviewHistory(String articleId, Integer userId, Boolean isPass) {
        this.articleId = articleId;
        this.userId = userId;
        this.isPass = isPass;
        createTime = updateTime = new Date();
        deleted = false;
    }

    public ReviewHistory(String articleId, Integer userId, Boolean isPass, String description) {
        this(articleId, userId, isPass);
        this.description = description;
    }
}
