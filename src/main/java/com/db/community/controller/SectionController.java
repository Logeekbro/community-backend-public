package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.SectionVO;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.SectionInfoVO;
import com.db.community.service.SectionService;
import com.db.community.utils.MySimplePage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Resource
    private SectionService sectionService;

    /**
     * 获取所有分区信息列表
     */
    @RequestMapping(value = "/open/list", method = RequestMethod.GET)
    public ResponseEntity<List<SectionInfoVO>> getSectionList() {
        List<SectionInfoVO> sectionList = sectionService.getSectionList();
        return ResponseEntity.success(sectionList);
    }

    /**
     * 根据文章id获取该文章的分区信息
     */
    @RequestMapping("/open/article/id/{articleId}")
    public ResponseEntity<SectionVO> getArticleSectionInfoById(@PathVariable String articleId) {
        SectionVO vo = sectionService.getSectionInfoByArticleId(articleId);
        return ResponseEntity.success(vo);
    }

    /**
     * 获取某个分区下的分页文章信息
     */
    @RequestMapping(value = "/open/articleList/{sectionId}", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<ArticleAndAuthorInfoVO>> getArticleListBySectionId(@PathVariable Integer sectionId,
                                                                                          Long current, Long size) {
        MySimplePage<ArticleAndAuthorInfoVO> page = sectionService.getArticleListBySectionId(current, size, sectionId);
        return ResponseEntity.success(page);
    }

    /**
     * 根据分区id获取对应的分区名称
     */
    @RequestMapping(value = "/open/sectionName/id/{sectionId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getSectionNameBySectionId(@PathVariable String sectionId) {
        String name = sectionService.getSectionNameBySectionId(sectionId);
        SingleKeyVO vo = new SingleKeyVO(name);
        return ResponseEntity.success(vo);
    }

}
