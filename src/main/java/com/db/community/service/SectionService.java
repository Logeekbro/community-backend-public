package com.db.community.service;

import com.db.community.model.vo.SectionVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.SectionInfoVO;
import com.db.community.utils.MySimplePage;

import java.util.List;

public interface SectionService {

    List<SectionInfoVO> getSectionList();

    SectionVO getSectionInfoByArticleId(String articleId);

    MySimplePage<ArticleAndAuthorInfoVO> getArticleListBySectionId(Long current, Long size, Integer sectionId);

    String getSectionNameBySectionId(String sectionId);
}
