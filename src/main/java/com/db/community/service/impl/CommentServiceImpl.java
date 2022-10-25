package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.common.api.ApiResultDetail;
import com.db.community.exception.ApiAsserts;
import com.db.community.model.dto.CommentCreateDTO;
import com.db.community.model.entity.Comment;
import com.db.community.model.enums.CountType;
import com.db.community.model.vo.detail.CommentDetailInfoVO;
import com.db.community.service.CacheService;
import com.db.community.service.CommentService;
import com.db.community.mapper.CommentMapper;
import com.db.community.service.CountService;
import com.db.community.utils.MyBeanUtil;
import com.db.community.utils.MySimplePage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86136
* @description 针对表【tb_comment】的数据库操作Service实现
* @createDate 2022-05-30 15:36:42
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CacheService cacheService;

    @Override
    public Boolean createComment(Integer userId, CommentCreateDTO commentCreateDTO) {
        if(!cacheService.isArticleIdSetMember(commentCreateDTO.getArticleId())){
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        Comment comment = MyBeanUtil.copyProps(commentCreateDTO, Comment.class);
        comment.setUserId(userId);
        return commentMapper.insert(comment) > 0;

    }

    @Override
    public MySimplePage<CommentDetailInfoVO> getCommentList(String articleId, Long current, Long size) {
        if(!cacheService.isArticleIdSetMember(articleId)){
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        Long total = commentMapper.selectCountOnEqual(comment);
        MySimplePage<CommentDetailInfoVO> page = new MySimplePage<>(current, size, total);
        List<CommentDetailInfoVO> vos =
                commentMapper.selectCommentWithUserInfoListByArticleId(articleId, page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public Boolean removeById(String commentId, Integer userId) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getUserId, userId).eq(Comment::getCommentId, commentId);
        return commentMapper.delete(queryWrapper) > 0;
    }

    @Override
    public Integer getCountByArticleId(String articleId) {
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        return Math.toIntExact(commentMapper.selectCountOnEqual(comment));
    }
}




