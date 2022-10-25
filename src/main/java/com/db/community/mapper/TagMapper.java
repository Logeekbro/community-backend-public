package com.db.community.mapper;

import com.db.community.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.impl.TagNameAndArticleCountVO;
import com.db.community.model.vo.impl.TagIdAndNameVO;
import com.db.community.model.vo.impl.TagInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
* @author 86136
* @description 针对表【tb_tag】的数据库操作Mapper
* @createDate 2022-05-23 20:31:14
* @Entity com.db.community.model.entity.Tag
*/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    Set<String> selectTagNameSetByArticleId(String articleId);

    List<TagInfoVO> selectTagInfoByTagName(String tagName, Long offset, Long size);

    Long selectTagCountByTagName(String tagName);

    Long selectArticleCountByTagName(String tagName);

    List<TagIdAndNameVO> selectIdAndNameList(Tag tag);

    List<TagNameAndArticleCountVO> selectHotTags(Integer n);

    @Select("SELECT tag_name FROM tb_tag WHERE tag_id=#{tagId}")
    String selectTagNameByTagId(String tagId);
}




