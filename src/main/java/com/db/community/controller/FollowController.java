package com.db.community.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.community.aop.annotation.SingleKeyVORecycle;
import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.service.MiddleTableService;
import com.db.community.utils.RequestUtil;
import com.db.community.utils.SingleKeyVOFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private MiddleTableService middleTableService;

    /**
     * 添加关注
     */
    @RequestMapping(value = "/{parentId}", method = RequestMethod.POST)
    public ResponseEntity<?> addFollowRelation(@PathVariable("parentId") int parentId,
                                               HttpServletRequest request) {
        middleTableService.saveFollowRelation(parentId, RequestUtil.getUserId(request));
        return ResponseEntity.success();
    }

    /**
     * 取消关注
     *
     */
    @RequestMapping(value = "/{parentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFollowRelation(@PathVariable("parentId") int parentId,
                                                     HttpServletRequest request) {
        middleTableService.removeFollowRelation(parentId, RequestUtil.getUserId(request));
        return ResponseEntity.success();
    }

    /**
     * 查询是否关注
     *
     * @param parentId 被关注者
     * @param userId 关注者
     * @return true：已关注  false：未关注
     */
    @RequestMapping(value = "/check/{parentId}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> checkFollowRelation(@PathVariable("parentId") int parentId,
                                                           @PathVariable("userId") int userId) {
        boolean hasFollow = middleTableService.checkFollowRelation(parentId, userId);
        SingleKeyVO vo = new SingleKeyVO(hasFollow);
        return ResponseEntity.success(vo);
    }

    /**
     * 查询粉丝数量
     *
     */
    @RequestMapping(value = "/open/count/{userId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getUserFollowCount(@PathVariable("userId") String userId) {
        long count = middleTableService.getFollowerCount(userId);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }

}
