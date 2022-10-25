package com.db.community.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.community.aop.annotation.SingleKeyVORecycle;
import com.db.community.common.api.ResponseEntity;
import com.db.community.model.dto.ReplyCreateDTO;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.detail.ReplyDetailVO;
import com.db.community.service.ReplyService;
import com.db.community.utils.RequestUtil;
import com.db.community.utils.SingleKeyVOFactory;
import com.db.community.utils.MyPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    /**
     * 添加回复
     *
     */
    @RequestMapping(value = "/{commentId}", method = RequestMethod.POST)
    public ResponseEntity<Void> addReply(@PathVariable("commentId") String commentId,
                                         @RequestBody ReplyCreateDTO replyCreateDTO,
                                         HttpServletRequest request) {
        boolean result = replyService.saveReply(commentId, RequestUtil.getUserId(request), replyCreateDTO);
        if (result) {
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 获取回复列表
     *
     */
    @RequestMapping(value = "/list/{commentId}", method = RequestMethod.GET)
    public ResponseEntity<MyPage<ReplyDetailVO>> getListByCommentId(@PathVariable("commentId") String commentId,
                                                                    @RequestParam Long current,
                                                                    @RequestParam Long size) {
        MyPage<ReplyDetailVO> page = replyService.getListByCommentId(commentId, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * 删除回复
     *
     */
    @RequestMapping(value = "/{replyId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReply(@PathVariable("replyId") String replyId,
                                            HttpServletRequest request) {
        if (replyService.deleteById(replyId, RequestUtil.getUserId(request))) {
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 获取评论的回复数量
     *
     */

    @RequestMapping(value = "/count/{commentId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getCountByCommentId(@PathVariable("commentId") String commentId) {
        Long count = replyService.getCountByCommentId(commentId);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }
}
