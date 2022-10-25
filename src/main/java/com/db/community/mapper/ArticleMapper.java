package com.db.community.mapper;

import com.db.community.model.dto.ArticleUpdateDTO;
import com.db.community.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.impl.*;
import com.sun.istack.NotNull;
//import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
* @author 86136
* @description 针对表【tb_article】的数据库操作Mapper
* @createDate 2022-05-23 09:14:19
* @Entity com.db.community.model.entity.Article
*/

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<UserArticleListVO> getArticlePageByUserId(Long offset, Long size, Integer userId);

    Long selectTotal(Article article);

    @Select("SELECT article_id FROM tb_article where deleted=0")
    Set<String> getArticleIdSet();

    @Update("UPDATE tb_article SET view_count=view_count+1 WHERE article_id=#{articleId} AND deleted=0")
    void addViewCountByArticleId(String articleId);

    List<ArticleAndAuthorInfoVO> selectLatestArticleInfoWithAuthorAndTagList(Long offset, Long size);

    List<ArticleAndAuthorInfoVO> selectPopularArticleInfoWithAuthorAndTagList(Long offset, Long size);

    Long deleteOnEqual(@NotNull Article article);

    Long updateArticle(ArticleUpdateDTO articleUpdateDTO);

    ArticleInfoVO selectArticleInfoById(String articleId);

    @Select("SELECT view_count FROM tb_article WHERE article_id=#{articleId} AND deleted=0")
    Integer getViewCountById(String articleId);

    List<ArticleAndAuthorInfoVO> selectArticleInfoByKeyword(String keyword, Long offset, Long size);

    List<ArticleAndAuthorInfoVO> selectArticleInfoByTagName(String tagName, Long offset, Long size);

    List<ArticleAndAuthorInfoVO> selectIndexTopArticle();

    List<ArticleAndAuthorInfoVO> selectArticleInfoBySectionId(Integer sectionId, Long offset, Long size);

    @Select("SELECT author_id FROM tb_article WHERE article_id=#{articleId} AND (deleted=0 OR status != 0)")
    Integer selectAuthorIdByArticleId(String articleId);

    @Select("SELECT title FROM tb_article WHERE article_id=#{articleId} AND (deleted=0 OR status != 0)")
    String selectTitleByArticleId(String articleId);

    @Select("SELECT author_id, COUNT(*) articleCount FROM tb_article WHERE deleted=0 GROUP BY author_id ORDER BY COUNT(*) DESC LIMIT #{n}")
    List<ArticleActiveAuthorVO> selectActiveAuthors(Integer n);

    List<ArticleInfoVO> selectArticleListByStatusAndDeleted(Integer userId, Integer status, Boolean deleted);

    Long updateArticleStatusAndDeleted(String articleId, Integer status, Boolean deleted);

    @Update("UPDATE tb_article SET top=(top=0) WHERE article_id=#{articleId}")
    Boolean updateArticleTopStatus(String articleId);
}




