package com.db.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.common.api.ApiResultDetail;
import com.db.community.exception.ApiAsserts;
import com.db.community.model.document.history.ReviewHistory;
import com.db.community.model.document.message.ReviewResultNotion;
import com.db.community.model.dto.ArticleCreateDTO;
import com.db.community.model.dto.ArticleUpdateDTO;
import com.db.community.model.entity.Article;
import com.db.community.model.vo.ArticleVO;
import com.db.community.model.vo.impl.*;
import com.db.community.mq.provider.SystemMessageProvider;
import com.db.community.service.TagService;
import com.db.community.service.ArticleService;
import com.db.community.mapper.ArticleMapper;
import com.db.community.service.CacheService;
import com.db.community.service.UploadService;
import com.db.community.utils.MyBeanUtil;
import com.db.community.utils.MySimplePage;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 86136
 * @description 针对表【tb_article】的数据库操作Service实现
 * @createDate 2022-05-23 09:14:19
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CacheService cacheService;

    @Resource
    private UploadService uploadService;

    @Resource
    private TagService tagService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private SystemMessageProvider systemMessageProvider;


    @Transactional
    @Override
    public String create(ArticleCreateDTO articleCreateDTO, MultipartFile file) {
        Article article = MyBeanUtil.copyProps(articleCreateDTO, Article.class);
        if (file != null) {
            String mainPic = uploadService.uploadArticleMainPic(file);
            article.setMainPic(mainPic);
        }
        if (articleCreateDTO.getNeedReview()) {
            article.setStatus(1);
            article.setDeleted(true);
        } else {
            // 未经审核的文章需将状态标记为3，后续待管理员查看
            article.setStatus(3);
        }
        List<TagIdAndNameVO> tagList = JSON.parseArray(articleCreateDTO.getTags(), TagIdAndNameVO.class);
        if (articleMapper.insert(article) > 0) {
            tagService.handleArticleTagCreate(article.getArticleId(), tagList);
            // 刷新缓存
            cacheService.refreshArticleIdSetCache();
        } else {
            ApiAsserts.fail(ApiResultDetail.FAILED);
        }
        return article.getArticleId();
    }

    @Override
    public MySimplePage<UserArticleListVO> getArticlePageByUserId(Integer userId, Long current, Long size) {
        Article article = new Article();
        article.setAuthorId(userId);
        Long total = articleMapper.selectTotal(article);
        MySimplePage<UserArticleListVO> page = new MySimplePage<>(current, size, total);
        List<UserArticleListVO> vos = articleMapper.getArticlePageByUserId(page.offset(), page.getSize(), userId);
        page.setRecords(vos);
        return page;
    }

    @Override
    public boolean deleteArticleById(String articleId, Integer userId) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setAuthorId(userId);
        Long result = articleMapper.deleteOnEqual(article);
        if (result > 0) {
            cacheService.refreshArticleIdSetCache();
            return true;
        }
        return false;
    }

    @Override
    public ArticleInfoVO getArticleDetailByArticleId(String articleId, Boolean isReEdit) {
        if (!isReEdit && !cacheService.isArticleIdSetMember(articleId)) {
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        return articleMapper.selectArticleInfoById(articleId);
    }

    @Transactional
    @Override
    public void updateById(ArticleUpdateDTO articleUpdateDTO, MultipartFile file) {
        if (!articleUpdateDTO.getNeedReview() && !cacheService.isArticleIdSetMember(articleUpdateDTO.getArticleId())) {
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        if (file != null) {
            String mainPic = uploadService.uploadArticleMainPic(file);
            articleUpdateDTO.setMainPic(mainPic);
        }
        Article article = MyBeanUtil.copyProps(articleUpdateDTO, Article.class);
        if (articleUpdateDTO.getNeedReview()) {
            articleMapper.updateArticleStatusAndDeleted(article.getArticleId(), 1, false);
        }
        if (articleMapper.updateById(article) <= 0) {
            ApiAsserts.fail("更新失败");
        } else {
            // 如果需要审核，则先删除文章
            if (articleUpdateDTO.getNeedReview()) {
                articleMapper.updateArticleStatusAndDeleted(article.getArticleId(), 1, true);
            }
            // 刷新缓存
            cacheService.refreshArticleIdSetCache();
        }
    }

    @Override
    public Long getArticleCountByAuthorId(int authorId) {
        Article article = new Article();
        article.setAuthorId(authorId);
        return articleMapper.selectTotal(article);
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getLatestArticleDetails(Long current, Long size) {
        Long total = articleMapper.selectTotal(null);
        MySimplePage<ArticleAndAuthorInfoVO> page = new MySimplePage<>(current, size, total);
        List<ArticleAndAuthorInfoVO> vos =
                articleMapper.selectLatestArticleInfoWithAuthorAndTagList(page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getPopularArticleDetails(Long current, Long size) {
        Long total = articleMapper.selectTotal(null);
        MySimplePage<ArticleAndAuthorInfoVO> page = new MySimplePage<>(current, size, total);
        List<ArticleAndAuthorInfoVO> vos =
                articleMapper.selectPopularArticleInfoWithAuthorAndTagList(page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getArticleDetailByKeyword(String keyword, Long current, Long size) {
        Article article = new Article();
        article.setTitle(keyword);
        Long total = articleMapper.selectTotal(article);
        MySimplePage<ArticleAndAuthorInfoVO> page = new MySimplePage<>(current, size, total);
        List<ArticleAndAuthorInfoVO> vos =
                articleMapper.selectArticleInfoByKeyword(keyword, page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public void addViewCountByArticleId(String articleId) {
        articleMapper.addViewCountByArticleId(articleId);
    }

    @Override
    public Integer getViewCountByArticleId(String articleId) {
        return articleMapper.getViewCountById(articleId);
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getArticlePageByTagName(String tagName, Long current, Long size) {
        Long total = tagService.getArticleCountByTagName(tagName);
        MySimplePage<ArticleAndAuthorInfoVO> page = new MySimplePage<>(current, size, total);
        List<ArticleAndAuthorInfoVO> vos =
                articleMapper.selectArticleInfoByTagName(tagName, page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public List<ArticleAndAuthorInfoVO> getIndexTopArticle() {
        return articleMapper.selectIndexTopArticle();
    }

    @Override
    public Long getArticleCountBySectionId(Integer sectionId) {
        Article article = new Article();
        article.setSectionId(sectionId);
        return articleMapper.selectTotal(article);
    }

    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> getArticleDetailsBySectionId(Long current, Long size, Integer sectionId) {
        Article article = new Article();
        article.setSectionId(sectionId);
        Long total = articleMapper.selectTotal(article);
        MySimplePage<ArticleAndAuthorInfoVO> page = new MySimplePage<>(current, size, total);
        if (total <= 0) return page;
        List<ArticleAndAuthorInfoVO> vos = articleMapper.selectArticleInfoBySectionId(sectionId, page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public Integer getAuthorIdByArticleId(String articleId) {
        return articleMapper.selectAuthorIdByArticleId(articleId);
    }

    @Override
    public String getTitleByArticleId(String articleId) {
        return articleMapper.selectTitleByArticleId(articleId);
    }

    @Override
    public List<ArticleActiveAuthorVO> getActiveAuthors(Integer n) {
        return articleMapper.selectActiveAuthors(n);
    }

    @Override
    public List<? extends ArticleVO> getNeedReviewArticleList(Integer userId) {
        return articleMapper.selectArticleListByStatusAndDeleted(userId, 1, true);
    }

    @Override
    public Boolean changeArticleReviewStatus(String articleId, Integer userId, String description, Boolean isPass) {
        Long result;
        if (isPass) {
            result = articleMapper.updateArticleStatusAndDeleted(articleId, 0, false);
            if (result > 0) {
                // 刷新缓存
                cacheService.refreshArticleIdSetCache();
            }

        } else {
            result = articleMapper.updateArticleStatusAndDeleted(articleId, 2, true);
        }
        ReviewHistory reviewHistory = new ReviewHistory(articleId, userId, isPass, description);
        mongoTemplate.insert(reviewHistory);
        ReviewResultNotion reviewResultNotion = new ReviewResultNotion(userId, articleId, isPass, description);
        systemMessageProvider.sendReviewResultNotion(reviewResultNotion);
        return result > 0;
    }

    @Override
    public List<? extends ArticleVO> getUnPassReviewArticleList(Integer userId) {
        return articleMapper.selectArticleListByStatusAndDeleted(userId, 2, true);
    }

    @Override
    public Boolean changeArticleTopStatus(String articleId) {
        return articleMapper.updateArticleTopStatus(articleId);
    }

}




