package com.db.community.mapper;

import com.db.community.model.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.detail.CommentDetailInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86136
* @description 针对表【tb_comment】的数据库操作Mapper
* @createDate 2022-05-30 15:36:42
* @Entity com.db.community.model.entity.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    Long selectCountOnEqual(Comment comment);

    List<CommentDetailInfoVO> selectCommentWithUserInfoListByArticleId(String articleId, Long offset, Long size);

}




