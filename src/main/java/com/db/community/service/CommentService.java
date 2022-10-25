package com.db.community.service;

import com.db.community.model.dto.CommentCreateDTO;
import com.db.community.model.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.detail.CommentDetailInfoVO;
import com.db.community.utils.MySimplePage;

/**
* @author 86136
* @description 针对表【tb_comment】的数据库操作Service
* @createDate 2022-05-30 15:36:42
*/
public interface CommentService extends IService<Comment> {

    Boolean createComment(Integer userId, CommentCreateDTO commentCreateDTO);

    MySimplePage<CommentDetailInfoVO> getCommentList(String articleId, Long current, Long size);

    Boolean removeById(String commentId, Integer userId);

    Integer getCountByArticleId(String articleId);
}
