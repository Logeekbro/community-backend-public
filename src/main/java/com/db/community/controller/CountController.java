package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.enums.CountType;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.service.CountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/count")
public class CountController {

    @Resource
    private CountService countService;

    /**
     * 查询点赞数
     * @param id 文章或评论id
     * @return 点赞数
     */
    @RequestMapping("/open/like/{id}")
    public ResponseEntity<SingleKeyVO> getLikeCountByArticleId(@PathVariable String id) {
        Double count = countService.getLikeCountById(id);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }

    /**
     * 查询文章的评论数
     * @param articleId 文章id
     * @return 评论数
     */
    @RequestMapping("/open/comment/{articleId}")
    public ResponseEntity<SingleKeyVO> getCommentCountByArticleId(@PathVariable String articleId) {
        Integer count = countService.getCount(CountType.COMMENT, articleId);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }

    /**
     * 查询文章浏览量
     * @param articleId 文章id
     * @return 浏览量
     */
    @RequestMapping("/open/view/{articleId}")
    public ResponseEntity<SingleKeyVO> getViewCountByArticleId(@PathVariable String articleId) {
        Integer count = countService.getCount(CountType.VIEW, articleId);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }
}
