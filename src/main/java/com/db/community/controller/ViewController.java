package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.impl.ViewHistoryInfoVO;
import com.db.community.model.vo.impl.ViewHistoryInfoWithDateVO;
import com.db.community.service.ViewService;
import com.db.community.utils.MySimplePage;
import com.db.community.utils.RequestUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Resource
    private ViewService viewService;

    /**
     * 记录用户浏览历史
     *
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.POST)
    public ResponseEntity<Void> addView(@PathVariable("articleId") String articleId,
                                        HttpServletRequest request) {
        viewService.handleUserView(articleId, RequestUtil.getUserId(request));
        return ResponseEntity.success();
    }

    /**
     * 获取用户的文章浏览记录
     *
     */
    @Deprecated
    @RequestMapping(value = "/history/{userToken}", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<ViewHistoryInfoVO>> getUserHistory(@PathVariable("userToken") String userToken,
                                                                          Long current, Long size) {
        MySimplePage<ViewHistoryInfoVO> page = viewService.getUserHistory(userToken, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * 通过日期获取浏览记录
     *
     */
    @RequestMapping(value = "/history/date", method = RequestMethod.GET)
    public ResponseEntity<ViewHistoryInfoWithDateVO> getUserHistoryByDate(@RequestParam String targetDate,
                                                                          HttpServletRequest request) {
        ViewHistoryInfoWithDateVO list = viewService.getUserHistoryByDate(RequestUtil.getUserId(request), targetDate);
        return ResponseEntity.success(list);
    }


    /**
     * 通过id删除浏览记录
     *
     */
    @RequestMapping(value = "/{viewId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteView(@PathVariable("viewId") String viewId,
                                           HttpServletRequest request) {
        if (viewService.deleteById(viewId, RequestUtil.getUserId(request))) {
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 删除用户的所有历史记录
     *
     */
    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAll(HttpServletRequest request) {
        boolean result = viewService.deleteAllByUserId(RequestUtil.getUserId(request));
        if (result) return ResponseEntity.success();
        return ResponseEntity.failed();
    }

}
