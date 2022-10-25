package com.db.community.controller;


import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.TagVO;
import com.db.community.model.vo.impl.TagIdAndNameVO;
import com.db.community.service.TagService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 通过文章id获取文章的标签集合
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getTagNameSetByArticleId(@PathVariable String articleId) {
        Set<String> tagSet = tagService.getTagNameSetByArticleId(articleId);
        SingleKeyVO vo = new SingleKeyVO(tagSet);
        return ResponseEntity.success(vo);
    }

    /**
     * 通过标签名模糊查询与之相关的标签列表
     * @param tagName 要查询的标签名
     * @return 标签信息列表
     */
    @RequestMapping(value = "/list/similarTagName", method = RequestMethod.GET)
    public ResponseEntity<List<TagIdAndNameVO>> getTagIdAndNameVOListBySimilarTagName(@RequestParam String tagName) {
        List<TagIdAndNameVO> list = tagService.getTagIdAndNameVOListBySimilarTagName(tagName);
        return ResponseEntity.success(list);
    }

    /**
     * 根据TagId获取标签名称
     */
    @RequestMapping("/open/tagName/id/{tagId}")
    public ResponseEntity<SingleKeyVO> getTagNameByTagId(@PathVariable String tagId) {
        String tagName = tagService.getTagNameByTagId(tagId);
        SingleKeyVO vo = new SingleKeyVO(tagName);
        return ResponseEntity.success(vo);
    }

    /**
     * 获取前N个热门标签
     */
    @RequestMapping(value = "/open/hotTags/{n}", method = RequestMethod.GET)
    public ResponseEntity<List<? extends TagVO>> getHotTags(@PathVariable Integer n) {
        List<? extends TagVO> vos = tagService.getHotTags(n);
        return ResponseEntity.success(vos);
    }
}
