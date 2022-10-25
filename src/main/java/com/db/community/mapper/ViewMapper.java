package com.db.community.mapper;

import com.db.community.model.entity.View;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.impl.ViewHistoryInfoVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author bin
* @description 针对表【tb_view】的数据库操作Mapper
* @createDate 2022-06-21 14:34:13
* @Entity com.db.community.model.entity.View
*/
public interface ViewMapper extends BaseMapper<View> {

    @Select("SELECT COUNT(*) FROM tb_view WHERE reader_id=#{userId} AND deleted=0")
    Long selectCountByUserId(Integer userId);

    @Select("SELECT COUNT(*) FROM tb_view WHERE reader_id=#{userId} AND article_id=#{articleId}")
    boolean exist(@Param("userId") Integer userId, @Param("articleId") String articleId);

    List<ViewHistoryInfoVO> selectViewHistoryByUserId(Long offset, Long size, Integer userId);


    List<ViewHistoryInfoVO> selectUserHistoryByDate(Integer userId, String targetDate);

    @Select("SELECT DATE(create_time) FROM tb_view " +
            "WHERE DATE(create_time) < #{date} AND reader_id=#{userId} AND deleted=0 " +
            "ORDER BY create_time DESC LIMIT 1")
    String selectBeforeDate(Integer userId, String date);
}




