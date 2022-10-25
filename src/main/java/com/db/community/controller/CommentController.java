package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.dto.CommentCreateDTO;
import com.db.community.model.vo.detail.CommentDetailInfoVO;
import com.db.community.service.CommentService;
import com.db.community.utils.MyPage;
import com.db.community.utils.MySimplePage;
import com.db.community.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    /**
     * 添加评论
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> addComment(@RequestBody CommentCreateDTO commentCreateDTO,
                                           HttpServletRequest request) {
        if (commentService.createComment(RequestUtil.getUserId(request), commentCreateDTO)) {
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 获取评论列表
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<CommentDetailInfoVO>> getCommentList(@PathVariable("articleId") String articleId,
                                                                            @RequestParam Long current,
                                                                            @RequestParam Long size) {
        MySimplePage<CommentDetailInfoVO> page = commentService.getCommentList(articleId, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * 删除评论
     *
     */
    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable("commentId") String commentId,
                                               HttpServletRequest request) {
        if (commentService.removeById(commentId, RequestUtil.getUserId(request))) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.failed();
        }
    }
}
