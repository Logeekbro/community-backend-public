package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.dto.VerifyDTO;
import com.db.community.model.vo.SingleKeyVO;
import com.db.community.model.vo.VerifyVO;
import com.db.community.service.CacheService;
import com.db.community.service.VerifyService;
import com.db.community.utils.ImageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Resource
    private CacheService cacheService;

    @Resource
    private VerifyService verifyService;

    /**
     * 开始验证
     * @return 本次验证的id
     */
    @RequestMapping(value = "/open/start", method = RequestMethod.GET)
    public ResponseEntity<VerifyVO> startVerify() {
        VerifyVO verifyVO = verifyService.startVerify();
        return ResponseEntity.success(verifyVO);
    }

    /**
     * 获取验证码图片
     * @param verifyId 验证的id
     * @param response 响应
     */
    @RequestMapping(value = "/open/img/{verifyId}", method = RequestMethod.GET)
    public void getRuleImg(@PathVariable String verifyId, HttpServletResponse response) throws IOException {
        VerifyDTO verifyDTO = cacheService.getLoginVerifyCode(verifyId);
        if (verifyDTO == null) return;
        ImageUtil.strToResponseImage(response, verifyDTO.getStrArr());
    }


    /**
     * 验证是否正确
     * @param verifyId 验证的id
     * @param value 用于验证的验证码
     * @return true：验证成功  false：验证失败
     */
    @RequestMapping(value = "/open/verify/{verifyId}", method = RequestMethod.GET)
    public ResponseEntity<SingleKeyVO> handleVerify(@PathVariable String verifyId,
                                                    @RequestParam String value) {
        String accessToken = verifyService.handleVerify(verifyId, value);
        SingleKeyVO vo = new SingleKeyVO(accessToken);
        return ResponseEntity.success(vo);
    }

}
