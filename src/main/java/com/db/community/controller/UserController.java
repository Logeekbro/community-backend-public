package com.db.community.controller;

import com.db.community.aop.annotation.SingleKeyVORecycle;
import com.db.community.common.api.ResponseEntity;
import com.db.community.model.dto.UserLoginDTO;
import com.db.community.model.dto.UserSettingInfoDTO;
import com.db.community.model.entity.User;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.UserDetailInfoVO;
import com.db.community.model.vo.impl.UserInfoVO;
import com.db.community.model.vo.impl.UserOpenInfoVO;
import com.db.community.service.UserService;
import com.db.community.utils.RequestUtil;
import com.db.community.utils.SingleKeyVOFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<SingleKeyVO> doLogin(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        String userToken = userService.login(userLoginDTO);
        SingleKeyVO vo = new SingleKeyVO(userToken);
        return ResponseEntity.success(vo);
    }

    /**
     * 用户注册
     *
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> doRegister(@Validated @RequestBody User userRegisterDTO) {
        userService.register(userRegisterDTO);
        return ResponseEntity.success("注册成功");
    }

    /**
     * 保存在客户端的用户信息
     *
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<UserInfoVO> getUserInfoByToken(HttpServletRequest request) {
        UserInfoVO userInfo = userService.getUserInfo(RequestUtil.getUserId(request));
        return ResponseEntity.success(userInfo);
    }

    /**
     * 用户的公开信息
     *
     */
    @RequestMapping(value = "/open/openInfo/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserOpenInfoVO> getUserOpenInfoById(@PathVariable("userId") Integer userId) {
        UserOpenInfoVO userInfo = userService.getUserOpenInfoById(userId);
        return ResponseEntity.success(userInfo);
    }

    /**
     * 用户的详细信息
     *
     */
    @RequestMapping(value = "/info/detail", method = RequestMethod.GET)
    public ResponseEntity<UserDetailInfoVO> getUserInfoById(HttpServletRequest request) {
        UserDetailInfoVO userInfo = userService.getUserInfoDetailById(RequestUtil.getUserId(request));
        return ResponseEntity.success(userInfo);
    }


    /**
     * 修改用户信息
     *
     */
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUserInfo(@RequestBody @Validated UserSettingInfoDTO userDTO,
                                               HttpServletRequest request) {
        userDTO.setUserId(RequestUtil.getUserId(request));
        if (userService.updateUserInfo(userDTO)) {
            return ResponseEntity.success();
        }
        return ResponseEntity.failed("更新失败");
    }

    /**
     * 获取用户关注列表
     */
    @RequestMapping(value = "/followList/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<? extends UserVO>> getUserFollowListById(@PathVariable("userId") Integer userId){
        List<? extends UserVO> list = userService.getUserFollowListById(userId);
        return ResponseEntity.success(list);
    }

    /**
     * 退出登录
     *
     */
    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public ResponseEntity<Void> userLogout(HttpServletRequest request) {
        userService.logout(RequestUtil.getUserId(request));
        return ResponseEntity.success();
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/password/{oldPassword}/{newPassword}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePassword(@PathVariable("oldPassword") String oldPassword,
                                            @PathVariable("newPassword") String newPassword,
                                            HttpServletRequest request) {
        Integer userId = RequestUtil.getUserId(request);
        if(userService.updatePassword(oldPassword, newPassword, userId)){
            userService.logout(userId);
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 获取用户头像
     */
    @RequestMapping(value = "/open/avatar/{userId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> getUserAvatar(@PathVariable Integer userId) {
        String src = userService.getAvatarById(userId);
        SingleKeyVO vo = new SingleKeyVO(src);
        return ResponseEntity.success(vo);
    }

    /**
     * 根据id获取用户昵称
     */
    @RequestMapping("/open/nickName/{userId}")
    public ResponseEntity<SingleKeyVO> getNickNameByUserId(@PathVariable Integer userId) {
        String nickName = userService.getNickNameByUserId(userId);
        SingleKeyVO vo = new SingleKeyVO(nickName);
        return ResponseEntity.success(vo);
    }

    /**
     * openAPI
     * 根据文章id获取作者的id和昵称
     */
    @RequestMapping(value = "/open/articleIdToAuthorInfo/{articleId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAuthorIdAndNickNameByArticleId(@PathVariable String articleId) {
        Map<String, Object> info  = userService.getAuthorIdAndNickNameByArticleId(articleId);
        return ResponseEntity.success(info);
    }


}
