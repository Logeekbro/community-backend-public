package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.common.api.ApiResultDetail;
import com.db.community.exception.ApiAsserts;
import com.db.community.model.auth.LoginUser;
import com.db.community.model.dto.UserLoginDTO;
import com.db.community.model.dto.UserSettingInfoDTO;
import com.db.community.model.entity.User;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.UserDetailInfoVO;
import com.db.community.model.vo.impl.UserInfoVO;
import com.db.community.model.vo.impl.UserOpenInfoVO;
import com.db.community.service.CacheService;
import com.db.community.service.UserService;
import com.db.community.mapper.UserMapper;
import com.db.community.utils.JwtUtil;
import com.db.community.utils.MyBeanUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
* @author 86136
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2022-05-19 20:29:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{


    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CacheService cacheService;

    @Override
    public String login(UserLoginDTO userLoginDTO) {
        // 对验证码进行校验
        String account = userLoginDTO.getAccount();
        String accessToken = userLoginDTO.getAccessToken();
        String verify = cacheService.getLoginAccessToken(accessToken);
        if(verify == null || !verify.equals(accessToken)) ApiAsserts.fail(ApiResultDetail.VALIDATE_FAILED);
        Authentication authenticationToken =
                new UsernamePasswordAuthenticationToken(account, userLoginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            ApiAsserts.fail("登录失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String userToken = JwtUtil.createJWT(userId);
        cacheService.setCacheObject("login:" + userId, loginUser);
        cacheService.deleteLoginAccessToken(accessToken);
        return userToken;
    }

    @Override
    public void register(User userRegisterDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount, userRegisterDTO.getAccount());
        if(userMapper.exists(queryWrapper)){
            ApiAsserts.fail("该账号已存在");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userRegisterDTO.setPassword(encoder.encode(userRegisterDTO.getPassword()));
        if(userMapper.insert(userRegisterDTO) > 0){
            // 刷新缓存
            cacheService.refreshUserIdSetCache();
        }
        else{
            ApiAsserts.fail("注册失败");
        }
    }

    @Override
    public UserInfoVO getUserInfo(Integer userId) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, userId);
        User user = userMapper.selectOne(queryWrapper);
        return MyBeanUtil.copyProps(user, UserInfoVO.class);
    }

    @Override
    public void logout(Integer userId) {
        cacheService.deleteObject("login:" + userId);
    }

    @Override
    public boolean updateUserInfo(UserSettingInfoDTO userDTO) {
        User user = MyBeanUtil.copyProps(userDTO, User.class);
        return userMapper.updateById(user) > 0;
    }

    @Override
    public UserDetailInfoVO getUserInfoDetailById(Integer userId) {
        User user = userMapper.selectById(userId);
        return MyBeanUtil.copyProps(user, UserDetailInfoVO.class);
    }

    @Override
    public UserOpenInfoVO getUserOpenInfoById(Integer userId) {
        if(!cacheService.isUserIdSetMember(userId)){
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        User user = userMapper.selectById(userId);
        return MyBeanUtil.copyProps(user, UserOpenInfoVO.class);
    }

    @Override
    public Boolean updatePassword(String oldPassword, String newPassword, Integer userId) {
        if(newPassword.length() < 6) {
            ApiAsserts.fail("密码长度必须大于等于6位");
        }
        User user = userMapper.selectById(userId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 验证原密码
        if(encoder.matches(oldPassword, user.getPassword())){
            String encode = encoder.encode(newPassword);
            user.setPassword(encode);
            return userMapper.updateById(user) > 0;
        }
        else{
            ApiAsserts.fail("原密码不正确");
        }
        return false;
    }

    @Override
    public List<? extends UserVO> getUserFollowListById(Integer userId) {
        if(!cacheService.isUserIdSetMember(userId)){
            ApiAsserts.fail(ApiResultDetail.NOT_FOUND);
        }
        return userMapper.getUserFollowListById(userId);
    }

    @Override
    public String getAvatarById(Integer userId) {
        return userMapper.selectAvatarById(userId);
    }

    @Override
    public boolean updateAvatarById(String avatar, Integer userId) {
        User user = new User();
        user.setUserId(userId);
        user.setAvatar(avatar);
        return userMapper.updateById(user) > 0;
    }

    @Override
    public String getNickNameByUserId(Integer userId) {
        return userMapper.selectNickNameByUserId(userId);
    }

    @Override
    public Map<String, Object> getAuthorIdAndNickNameByArticleId(String articleId) {
        return userMapper.selectAuthorIdAndNickNameByArticleId(articleId);
    }


}




