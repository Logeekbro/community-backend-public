package com.db.community.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 接收前端创建文章时传来的文章数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateDTO implements Serializable {

    /**
     * 作者的id
     */
    @JsonProperty("authorId")
    private Integer authorId;

    /**
     * Article-文章标题
     */
    @JsonProperty("title")
    @NotEmpty(message = "标题不能为空")
    @Size(min = 1, max = 30, message = "标题长度必须在1-30之间")
    private String title;

    /**
     * Article-文章内容
     */
    @JsonProperty("content")
    @NotEmpty(message = "文章内容不能为空")
    @Size(min = 1, message = "文章内容不能为空")
    private String content;

    /**
     * 文章摘要
     */
    @JsonProperty("summary")
    @Size(max = 255, message = "摘要字数不能超过255")
    private String summary;

    /**
     * 文章分区id
     */
    @JsonProperty("sectionId")
    @NotNull(message = "文章分区不能为空")
    private Integer sectionId;

    /**
     * Tag-文章标签
     */
    @JsonProperty("tags")
    @NotEmpty(message = "文章标签不能为空")
    private String tags;

    /**
     * 是否需要审核
     */
    @JsonProperty("needReview")
    @NotNull(message = "请选择是否需要进行审核")
    private Boolean needReview;
}
