package com.db.community.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CommentCreateDTO {

    private String articleId;

    @NotEmpty(message = "评论内容不能为空")
    @Size(min = 1, message = "评论内容不能为空")
    private String content;
}
