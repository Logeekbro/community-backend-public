package com.db.community.service;

import com.db.community.model.dto.ArticleCreateDTO;
import com.db.community.model.entity.Article;
import com.db.community.model.vo.detail.*;
import com.db.community.utils.MyPage;

import java.io.Serializable;
import java.util.List;

/**
 * 用于对多张表进行操作
 */
public interface MultiTableService {

    /**
     * 对新建文章的标签进行处理
     */
    void createWithArticleDTO(ArticleCreateDTO articleCreateDTO);

    /**
     * 获取评论列表
     * @param articleId
     * @return
     */
    MyPage<CommentDetailInfoVO> getCommentList(Serializable articleId, Long current, Long size);


    /**
     * 获取文章及其作者的预览信息
     * @param articles
     * @return
     */
    List<ArticleDetailVO> getArticleDetailByArticleList(List<Article> articles);

    /**
     * 获取评论的回复信息
     * @param commentId
     * @return
     */
    MyPage<ReplyDetailVO> getReplyDetailListByCommentId(String commentId, Long current, Long size);


}
