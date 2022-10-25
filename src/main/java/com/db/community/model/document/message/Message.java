package com.db.community.model.document.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
public abstract class Message {

    @Id
    private String messageId;

    private Boolean isRead;

    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    private Boolean deleted;

    public Message() {
        isRead = false;
        createTime = updateTime = new Date();
        deleted = false;
    }

}
