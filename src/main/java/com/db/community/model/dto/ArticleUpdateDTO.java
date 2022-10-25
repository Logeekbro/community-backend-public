package com.db.community.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 接收前端修改文章时传来的文章数据
 */
@Data
public class ArticleUpdateDTO {

    /**
     * 作者的用户id
     */
    private Integer authorId;

    /**
     * Article-文章id
     */
    private String articleId;

    /**
     * Article-文章标题
     */
    @NotEmpty(message = "标题不能为空")
    @Size(min = 1, max = 30, message = "标题长度必须在1-30之间")
    private String title;

    /**
     * 文章分区id
     */
    @NotNull(message = "文章分区不能为空")
    private Integer sectionId;

    /**
     * 文章封面url
     */
    private String mainPic;

    /**
     * Article-文章内容
     */
    private String content;

    /**
     * 文章摘要
     */
    @Size(max = 255, message = "摘要字数不能超过255")
    private String summary;

    /**
     * 是否需要审核
     */
    @NotNull(message = "请选择是否进行审核")
    private Boolean needReview;
}
