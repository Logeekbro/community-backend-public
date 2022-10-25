package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.service.ActionService;
import com.db.community.service.MiddleTableService;
import com.db.community.utils.RequestUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Resource
    private ActionService actionService;

    /**
     * 点赞文章或评论
     * @param id 文章或评论id
     */
    @RequestMapping(value = "/like/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> addLike(@PathVariable String id, HttpServletRequest request) {
//        boolean result = middleTableService.doLikeAction(RequestUtil.getUserId(request), id);
        actionService.handleLike(RequestUtil.getUserId(request), id);
        return ResponseEntity.success();

    }

    /**
     * 查询是否点赞
     * @param id 文章或评论id
     * @return true：已点赞  false：未点赞
     */
    @RequestMapping(value = "/like/check/{id}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> checkIsLiked(@PathVariable String id, HttpServletRequest request) {
//        boolean result = middleTableService.checkLikeRelation(RequestUtil.getUserId(request), id);
        Boolean result = actionService.checkLike(RequestUtil.getUserId(request), id);
        SingleKeyVO vo = new SingleKeyVO(result);
        return ResponseEntity.success(vo);
    }

    /**
     * 处理游客对文章的点赞请求
     * @param articleId 文章id
     * @return 处理结果
     */
    @RequestMapping("/open/like/{articleId}/guest")
    public ResponseEntity<Void> handleGuestLike(@PathVariable String articleId) {
        // TODO 发送消息通知给作者
        actionService.handleGuestLike(articleId);
        return ResponseEntity.success();
    }

}
