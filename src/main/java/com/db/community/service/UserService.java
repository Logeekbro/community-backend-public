package com.db.community.service;

import com.db.community.model.dto.UserLoginDTO;
import com.db.community.model.dto.UserSettingInfoDTO;
import com.db.community.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.UserDetailInfoVO;
import com.db.community.model.vo.impl.UserInfoVO;
import com.db.community.model.vo.impl.UserOpenInfoVO;

import java.util.List;
import java.util.Map;

/**
* @author 86136
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2022-05-19 20:29:22
*/
public interface UserService extends IService<User> {

    String login(UserLoginDTO userLoginDTO);

    void register(User userRegisterDTO);

    UserInfoVO getUserInfo(Integer userId);

    void logout(Integer userId);

    boolean updateUserInfo(UserSettingInfoDTO userDTO);

    UserDetailInfoVO getUserInfoDetailById(Integer userId);

    UserOpenInfoVO getUserOpenInfoById(Integer userId);

    Boolean updatePassword(String oldPassword, String newPassword, Integer userId);

    List<? extends UserVO> getUserFollowListById(Integer userId);

    String getAvatarById(Integer userId);

    boolean updateAvatarById(String avatar, Integer userId);

    String getNickNameByUserId(Integer userId);

    Map<String, Object> getAuthorIdAndNickNameByArticleId(String articleId);
}
