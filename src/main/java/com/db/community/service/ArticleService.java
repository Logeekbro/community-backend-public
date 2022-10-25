package com.db.community.service;

import com.db.community.model.dto.ArticleCreateDTO;
import com.db.community.model.dto.ArticleUpdateDTO;
import com.db.community.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.ArticleVO;
import com.db.community.model.vo.impl.ArticleActiveAuthorVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.UserArticleListVO;
import com.db.community.utils.MySimplePage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author 86136
* @description 针对表【tb_article】的数据库操作Service
* @createDate 2022-05-23 09:14:19
*/
public interface ArticleService extends IService<Article> {


    String create(ArticleCreateDTO articleDTO, MultipartFile file);

    MySimplePage<UserArticleListVO> getArticlePageByUserId(Integer userId, Long current, Long size);

    boolean deleteArticleById(String articleId, Integer userId);

    ArticleVO getArticleDetailByArticleId(String articleId, Boolean isReEdit);

    void updateById(ArticleUpdateDTO articleUpdateDTO, MultipartFile file);

    Long getArticleCountByAuthorId(int authorId);

    MySimplePage<ArticleAndAuthorInfoVO> getLatestArticleDetails(Long current, Long size);

    MySimplePage<ArticleAndAuthorInfoVO> getPopularArticleDetails(Long current, Long size);

    MySimplePage<ArticleAndAuthorInfoVO> getArticleDetailByKeyword(String keyword, Long current, Long size);

    void addViewCountByArticleId(String articleId);

    Integer getViewCountByArticleId(String articleId);

    MySimplePage<ArticleAndAuthorInfoVO> getArticlePageByTagName(String tagName, Long current, Long size);

    List<ArticleAndAuthorInfoVO> getIndexTopArticle();

    Long getArticleCountBySectionId(Integer sectionId);

    MySimplePage<ArticleAndAuthorInfoVO> getArticleDetailsBySectionId(Long current, Long size, Integer sectionId);

    Integer getAuthorIdByArticleId(String articleId);

    String getTitleByArticleId(String articleId);

    List<ArticleActiveAuthorVO> getActiveAuthors(Integer n);

    List<? extends ArticleVO> getNeedReviewArticleList(Integer userId);

    Boolean changeArticleReviewStatus(String articleId, Integer userId, String description, Boolean isPass);

    List<? extends ArticleVO> getUnPassReviewArticleList(Integer userId);

    Boolean changeArticleTopStatus(String articleId);
}
