package com.db.community.mapper;

import com.db.community.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.FollowUserInfoVO;
import com.db.community.model.vo.impl.UserPreviewInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @author 86136
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2022-05-19 20:29:22
* @Entity com.db.community.model.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT user_id FROM tb_user WHERE deleted=0")
    Set<Integer> getUserIdSet();

    List<FollowUserInfoVO> getUserFollowListById(Integer userId);

    @Select("SELECT avatar FROM tb_user WHERE user_id=#{userId} AND deleted=0")
    String selectAvatarById(Integer userId);

    @Select("SELECT nick_name FROM tb_user WHERE user_id=#{userId} AND deleted=0")
    String selectNickNameByUserId(Integer userId);

    @Select("SELECT u.user_id userId,u.nick_name nickName FROM tb_user u INNER JOIN tb_article a ON a.author_id=u.user_id WHERE a.article_id=#{articleId} AND a.deleted=0")
    Map<String, Object> selectAuthorIdAndNickNameByArticleId(String articleId);
}




