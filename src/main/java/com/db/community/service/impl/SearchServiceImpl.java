package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.db.community.model.entity.Article;
import com.db.community.model.entity.Tag;
import com.db.community.model.entity.User;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.detail.ArticleDetailVO;
import com.db.community.model.vo.impl.ArticleAndAuthorInfoVO;
import com.db.community.model.vo.impl.TagInfoVO;
import com.db.community.model.vo.impl.UserPreviewInfoVO;
import com.db.community.service.*;
import com.db.community.utils.MyBeanUtil;
import com.db.community.utils.MyPage;
import com.db.community.utils.MySimplePage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private ArticleService articleService;

    @Resource
    private TagService tagService;

    @Resource
    private UserService userService;


    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> searchArticleByKeyword(String keyword, Long current, Long size) {
        return articleService.getArticleDetailByKeyword(keyword, current, size);
    }

    /**
     * 根据关键字查询文章的标签信息，信息(重要)包括：标签名、含有该标签的文章数量等
     * @param tagName 标签关键字
     * @param current 当前页
     * @param size  每页的记录数
     * @return 文章的标签信息
     */
    @Override
    public MySimplePage<TagInfoVO> searchTagInfoByTagName(String tagName, Long current, Long size) {
        return tagService.getTagInfoByTagName(tagName, current, size);
    }



    @Override
    public MyPage<? extends UserVO> searchByUserIdOrNickname(String idOrName, Long current, Long size) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, idOrName);
        queryWrapper.or().like(User::getNickName, idOrName);
        MyPage<UserPreviewInfoVO> page = new MyPage<>(userService.getBaseMapper(), queryWrapper, current, size);
        List<User> users = userService.list(queryWrapper);
        List<UserPreviewInfoVO> userVOList = users.stream()
                .map(user -> MyBeanUtil.copyProps(user, UserPreviewInfoVO.class))
                .collect(Collectors.toList());
        page.setRecords(userVOList);
        return page;
    }

    /**
     * 根据标签名获取相关的文章列表
     */
    @Override
    public MySimplePage<ArticleAndAuthorInfoVO> searchArticleByTag(String tagName, Long current, Long size) {
        return articleService.getArticlePageByTagName(tagName, current, size);
    }
}
