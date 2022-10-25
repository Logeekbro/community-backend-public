package com.db.community.service;

import com.db.community.model.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.TagVO;
import com.db.community.model.vo.impl.TagIdAndNameVO;
import com.db.community.model.vo.impl.TagInfoVO;
import com.db.community.utils.MySimplePage;

import java.util.List;
import java.util.Set;

/**
* @author 86136
* @description 针对表【tb_tag】的数据库操作Service
* @createDate 2022-05-23 20:31:14
*/
public interface TagService extends IService<Tag> {
    Set<String> getTagNameSetByArticleId(String articleId);

    MySimplePage<TagInfoVO> getTagInfoByTagName(String tagName, Long current, Long size);

    Long getArticleCountByTagName(String tagName);

    Boolean handleArticleTagCreate(String articleId, List<TagIdAndNameVO> tags);

    List<TagIdAndNameVO> getTagIdAndNameVOListBySimilarTagName(String tagName);

    List<? extends TagVO> getHotTags(Integer n);

    String getTagNameByTagId(String tagId);
}
