package com.db.community.service.impl;

import com.db.community.mapper.SectionMapper;
import com.db.community.model.vo.SectionVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.SectionInfoVO;
import com.db.community.service.ArticleService;
import com.db.community.service.SectionService;
import com.db.community.utils.MySimplePage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Resource
    private SectionMapper sectionMapper;

    @Resource
    private ArticleService articleService;

    @Override
    public List<SectionInfoVO> getSectionList() {
        return sectionMapper.selectSectionInfoList();
    }

    @Override
    public SectionVO getSectionInfoByArticleId(String articleId) {
        return sectionMapper.selectSectionInfoByArticleId(articleId);
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getArticleListBySectionId(Long current, Long size, Integer sectionId) {
        return articleService.getArticleDetailsBySectionId(current, size, sectionId);
    }

    @Override
    public String getSectionNameBySectionId(String sectionId) {
        return sectionMapper.selectSectionNameBySectionId(sectionId);
    }
}
