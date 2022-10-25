package com.db.community.controller;


import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.TagInfoVO;
import com.db.community.service.SearchService;
import com.db.community.utils.MyPage;
import com.db.community.utils.MySimplePage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * openAPI
     * 通过关键字搜索文章
     *
     * @param keyword 用于模糊搜索的关键字
     * @param current 当前页
     * @param size 每页的记录数
     * @return 查询出的记录分页
     */
    @RequestMapping("/open/article")
    public ResponseEntity<MySimplePage<ArticleAndAuthorInfoVO>> searchArticleByKeyword(@RequestParam String keyword,
                                                                                       Long current,
                                                                                       Long size) {
        MySimplePage<ArticleAndAuthorInfoVO> list = searchService.searchArticleByKeyword(keyword, current, size);
        return ResponseEntity.success(list);
    }

    /**
     * openAPI
     * 根据关键字搜素标签，以及标签对应的文章数量
     *
     * @param tagName 用于模糊搜索的标签名称
     * @param current 当前页
     * @param size 每页的记录数
     * @return 查询出的记录分页
     */
    @RequestMapping(value = "/open/tag", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<TagInfoVO>> searchTagByKeyWord(@RequestParam String tagName,
                                                                      Long current,
                                                                      Long size) {
        MySimplePage<TagInfoVO> page = searchService.searchTagInfoByTagName(tagName, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * openAPI
     * 根据用户昵称或id搜索用户
     */
    @RequestMapping(value = "/open/user", method = RequestMethod.GET)
    public ResponseEntity<MyPage<? extends UserVO>> searchUserByNickName(@RequestParam String idOrName,
                                                                         Long current,
                                                                         Long size) {
        MyPage<? extends UserVO> page = searchService.searchByUserIdOrNickname(idOrName, current, size);
        return ResponseEntity.success(page);
    }

    /**
     * 根据标签名称查询文章
     *
     * @param tagName 要查询的标签名
     * @param current 当前页
     * @param size 每页的记录数
     * @return 查询出的记录分页
     */
    @RequestMapping(value = "/open/article/byTag/{tagName}", method = RequestMethod.GET)
    public ResponseEntity<MySimplePage<ArticleAndAuthorInfoVO>> searchArticleByTag(@PathVariable("tagName") String tagName,
                                                                                   Long current,
                                                                                   Long size) {
        MySimplePage<ArticleAndAuthorInfoVO> page = searchService.searchArticleByTag(tagName, current, size);
        return ResponseEntity.success(page);
    }
}
