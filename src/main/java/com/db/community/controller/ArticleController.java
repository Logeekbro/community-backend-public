package com.db.community.controller;


import com.db.community.common.api.ApiResultDetail;
import com.db.community.common.api.ResponseEntity;
import com.db.community.model.dto.ArticleCreateDTO;
import com.db.community.model.dto.ArticleUpdateDTO;
import com.db.community.model.vo.ArticleVO;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.impl.ArticleActiveAuthorVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.ArticleInfoVO;
import com.db.community.model.vo.impl.UserArticleListVO;
import com.db.community.service.ArticleService;
import com.db.community.utils.MySimplePage;
import com.db.community.utils.RequestUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 创建文章
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<SingleKeyVO> createArticle(@Validated ArticleCreateDTO articleDTO,
                                                     MultipartFile file,
                                                     HttpServletRequest request) {
        articleDTO.setAuthorId(RequestUtil.getUserId(request));
        String id = articleService.create(articleDTO, file);
        SingleKeyVO vo = new SingleKeyVO(id);
        return ResponseEntity.success(vo);
    }

    /**
     * 更新文章
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateArticle(@Validated ArticleUpdateDTO articleUpdateDTO,
                                              MultipartFile file,
                                              HttpServletRequest request) {
        articleUpdateDTO.setAuthorId(RequestUtil.getUserId(request));
        articleService.updateById(articleUpdateDTO, file);
        return ResponseEntity.success();
    }

    /**
     * 获取用户主页文章列表
     * SQL Override Complete
     */
    @RequestMapping(value = "/open/user/list", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<UserArticleListVO>> getArticleListByUserId(@RequestParam Integer userId,
                                                                                  @RequestParam Long current,
                                                                                  @RequestParam Long size) {
        MySimplePage<UserArticleListVO> page = articleService.getArticlePageByUserId(userId, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * 删除文章
     * SQL Override Complete
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArticleById(@PathVariable("articleId") String articleId,
                                               HttpServletRequest request) {
        if (articleService.deleteArticleById(articleId, RequestUtil.getUserId(request))) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.failed();
        }
    }

    /**
     * openAPI
     * 获取文章的详细信息（包括作者id，标签，文章的内容、标题...等，详见返回值->ArticleInfoWithTagAndAuthorIdVO）
     * SQL Override Complete
     *
     * @param articleId 文章id
     * @param isReEdit  是否是重新编辑的文章
     * @return
     */
    @RequestMapping(value = "/open/detail/{articleId}", method = RequestMethod.GET)
    public ResponseEntity<ArticleVO> getArticleDetailById(@PathVariable("articleId") String articleId, @RequestParam(defaultValue = "false") Boolean isReEdit
            , HttpServletRequest request) {
        ArticleInfoVO vo = (ArticleInfoVO) articleService.getArticleDetailByArticleId(articleId, isReEdit);
        // 当该文章是重新编辑的文章时，内容只有作者本人能查看
        if (isReEdit && !vo.getAuthorId().equals(RequestUtil.getUserId(request)))
            return ResponseEntity.failed(ApiResultDetail.NOT_FOUND);
        return ResponseEntity.success(vo);
    }

    /**
     * openAPI
     * 获取最新文章
     * SQL Override Complete
     *
     * @return
     */
    @RequestMapping(value = "/open/latest", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<ArticleAndAuthorInfoVO>> getLatestArticles(@Param("current") Long current,
                                                                                  @Param("size") Long size) {
        MySimplePage<ArticleAndAuthorInfoVO> page =
                articleService.getLatestArticleDetails(current, size);
        return ResponseEntity.success(page);
    }

    /**
     * openAPI
     * 获取热门文章
     * SQL Override Complete
     *
     * @param current
     * @param size
     * @return
     */
    @RequestMapping(value = "/open/popular", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<ArticleAndAuthorInfoVO>> getPopularArticles(@Param("current") Long current,
                                                                                   @Param("size") Long size) {
        MySimplePage<ArticleAndAuthorInfoVO> page =
                articleService.getPopularArticleDetails(current, size);
        return ResponseEntity.success(page);
    }

    /**
     * openAPI
     * 获取用户发表的文章数量
     * SQL Override Complete
     *
     * @param authorId
     * @return
     */
    @RequestMapping(value = "/open/count/{authorId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getArticleCountByAuthorId(@PathVariable("authorId") int authorId) {
        Long count = articleService.getArticleCountByAuthorId(authorId);
        SingleKeyVO vo = new SingleKeyVO(count);
        return ResponseEntity.success(vo);
    }


    /**
     * openAPI
     * 获取置顶文章
     */
    @RequestMapping(value = "/open/index/top", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleAndAuthorInfoVO>> getIndexTopArticle() {
        List<ArticleAndAuthorInfoVO> vo = articleService.getIndexTopArticle();
        return ResponseEntity.success(vo);
    }

    /**
     * openAPI
     * 通过文章id获取文章标题
     */
    @RequestMapping("/open/title/{articleId}")
    public ResponseEntity<SingleKeyVO> getTitleByArticleId(@PathVariable String articleId) {
        String title = articleService.getTitleByArticleId(articleId);
        SingleKeyVO vo = new SingleKeyVO(title);
        return ResponseEntity.success(vo);
    }

    /**
     * openAPI
     * 获取TopN活跃作者的id及其发表的文章数量
     */
    @RequestMapping("/open/mostActiveAuthors/{n}")
    public ResponseEntity<List<ArticleActiveAuthorVO>> getActiveAuthors(@PathVariable Integer n) {
        List<ArticleActiveAuthorVO> authors = articleService.getActiveAuthors(n);
        return ResponseEntity.success(authors);
    }

    /**
     * AdminAPI
     * 直接根据id删除文章
     */
    @RequestMapping(value = "/admin/id", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('article.delete')")
    public ResponseEntity<Boolean> deleteArticleByArticleId(@RequestParam String articleId) {
        boolean result = articleService.removeById(articleId);
        if(result) return ResponseEntity.success();
        return ResponseEntity.failed("删除失败");
    }

    /**
     * AdminAPI
     * 获取所有待审核的文章
     */
    @RequestMapping("/admin/needReviewList")
    @PreAuthorize("hasAuthority('article.review')")
    public ResponseEntity<List<? extends ArticleVO>> getNeedReviewArticleList() {
        return ResponseEntity.success(articleService.getNeedReviewArticleList(null));
    }

    /**
     * AdminAPI
     * 更新文章审核状态
     */
    @RequestMapping(value = "/admin/review/id/{articleId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('article.review')")
    public ResponseEntity<?> passArticle(@PathVariable String articleId, @RequestParam(defaultValue = "") String description,
                                         @NotNull(message = "请选择是否通过审核") Boolean isPass,
                                         HttpServletRequest request) {
        Boolean result = articleService.changeArticleReviewStatus(articleId, RequestUtil.getUserId(request), description, isPass);
        if (result) return ResponseEntity.success();
        else return ResponseEntity.failed();
    }

    /**
     * 根据用户id获取该用户待审核的文章列表
     */
    @RequestMapping(value = "/needReviewList", method = RequestMethod.GET)
    public ResponseEntity<List<? extends ArticleVO>> getUserNeedReviewArticleList(HttpServletRequest request) {
        List<? extends ArticleVO> list = articleService.getNeedReviewArticleList(RequestUtil.getUserId(request));
        return ResponseEntity.success(list);
    }

    /**
     * 根据用户id获取该用户审核未通过的文章列表
     */
    @RequestMapping(value = "/unPassReviewList", method = RequestMethod.GET)
    public ResponseEntity<List<? extends ArticleVO>> getUnPassReviewList(HttpServletRequest request) {
        List<? extends ArticleVO> list = articleService.getUnPassReviewArticleList(RequestUtil.getUserId(request));
        return ResponseEntity.success(list);
    }

    /**
     * AdminAPI
     * 将文章设为置顶或取消置顶
     */
    @RequestMapping(value = "/admin/topStatus", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('article.setTop')")
    public ResponseEntity<SingleKeyVO> changeArticleTopStatus(@RequestParam String articleId) {
        Boolean result = articleService.changeArticleTopStatus(articleId);
        SingleKeyVO vo = new SingleKeyVO(result);
        return ResponseEntity.success(vo);
    }
}
