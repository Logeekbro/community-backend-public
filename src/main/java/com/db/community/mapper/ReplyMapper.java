package com.db.community.mapper;

import com.db.community.model.entity.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 86136
* @description 针对表【tb_reply】的数据库操作Mapper
* @createDate 2022-06-04 17:29:35
* @Entity com.db.community.model.entity.Reply
*/
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {

    @Select("SELECT COUNT(*) FROM tb_reply WHERE comment_id=#{commentId} AND deleted=0")
    Long selectCountByCommentId(String commentId);
}




