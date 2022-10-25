package com.db.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.model.entity.Tag;
import com.db.community.model.vo.TagVO;
import com.db.community.model.vo.impl.TagIdAndNameVO;
import com.db.community.model.vo.impl.TagInfoVO;
import com.db.community.service.MiddleTableService;
import com.db.community.service.TagService;
import com.db.community.mapper.TagMapper;
import com.db.community.utils.MySimplePage;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author 86136
* @description 针对表【tb_tag】的数据库操作Service实现
* @createDate 2022-05-23 20:31:14
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

    @Resource
    private TagMapper tagMapper;

    @Resource
    private MiddleTableService middleTableService;

    @Override
    public Set<String> getTagNameSetByArticleId(String articleId) {
        return tagMapper.selectTagNameSetByArticleId(articleId);
    }

    @Override
    public MySimplePage<TagInfoVO> getTagInfoByTagName(String tagName, Long current, Long size) {
        Long total = tagMapper.selectTagCountByTagName(tagName);
        MySimplePage<TagInfoVO> page = new MySimplePage<>(current, size, total);
        List<TagInfoVO> vos = tagMapper.selectTagInfoByTagName(tagName, page.offset(), page.getSize());
        page.setRecords(vos);
        return page;
    }

    @Override
    public Long getArticleCountByTagName(String tagName) {
        return tagMapper.selectArticleCountByTagName(tagName);
    }

    @Override
    public Boolean handleArticleTagCreate(@NotNull String articleId, @NotNull List<TagIdAndNameVO> tags) {
        // 标签去重
        List<TagIdAndNameVO> tagList = tags.stream().distinct().collect(Collectors.toList());
        // 所有标签信息列表
        List<TagIdAndNameVO> allTagList = tagMapper.selectIdAndNameList(null);
        // 获取所有标签名
        Set<String> allTagNameSet = allTagList.stream().map(TagIdAndNameVO::getTagName).collect(Collectors.toSet());
        tagList.forEach(tagVO -> {
            if(allTagList.contains(tagVO)) {
                middleTableService.saveArticleAndTagRelation(articleId, tagVO.getTagId());
            }
            else if(tagVO.getTagId() == null && !allTagNameSet.contains(tagVO.getTagName())) {
                Tag tag = new Tag();
                tag.setTagName(tagVO.getTagName());
                tagMapper.insert(tag);
                middleTableService.saveArticleAndTagRelation(articleId, tag.getTagId());
            }
        });
        return true;
    }

    @Override
    public List<TagIdAndNameVO> getTagIdAndNameVOListBySimilarTagName(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        return tagMapper.selectIdAndNameList(tag);
    }

    @Override
    public List<? extends TagVO> getHotTags(Integer n) {
        return tagMapper.selectHotTags(n);
    }

    @Override
    public String getTagNameByTagId(String tagId) {
        return tagMapper.selectTagNameByTagId(tagId);
    }
}




