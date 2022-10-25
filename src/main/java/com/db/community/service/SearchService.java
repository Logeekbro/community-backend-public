package com.db.community.service;

import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.TagInfoVO;
import com.db.community.utils.MyPage;
import com.db.community.utils.MySimplePage;

public interface SearchService {


    MySimplePage<ArticleAndAuthorInfoVO> searchArticleByKeyword(String keyword, Long current, Long size);

    MySimplePage<TagInfoVO> searchTagInfoByTagName(String tagName, Long current, Long size);

    MyPage<? extends UserVO> searchByUserIdOrNickname(String idOrName, Long current, Long size);

    MySimplePage<ArticleAndAuthorInfoVO> searchArticleByTag(String tagName, Long current, Long size);
}
