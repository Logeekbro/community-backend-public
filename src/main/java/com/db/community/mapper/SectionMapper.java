package com.db.community.mapper;

import com.db.community.model.vo.SectionVO;
import com.db.community.model.vo.impl.SectionInfoVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionMapper {

    @Select("SELECT section_id,section_name FROM tb_section WHERE deleted=0")
    List<SectionInfoVO> selectSectionInfoList();

    SectionInfoVO selectSectionInfoByArticleId(String articleId);

    @Select("SELECT section_name FROM tb_section WHERE section_id=#{sectionId} AND deleted=0")
    String selectSectionNameBySectionId(String sectionId);
}
