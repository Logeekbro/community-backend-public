package com.db.community.controller;

import com.db.community.common.api.ResponseEntity;
import com.db.community.model.vo.impl.ArticleImgVO;
import com.db.community.service.UploadService;
import com.db.community.utils.RequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/upload")
public class UploadController {



    @Resource
    private UploadService uploadService;

    /**
     * 上传头像
     */
    @RequestMapping(value = "/avatar", method = RequestMethod.POST)
    public ResponseEntity<Void> uploadAvatar(MultipartFile file, boolean haveAvatar, HttpServletRequest request){
        if(uploadService.uploadAvatar(file, RequestUtil.getUserId(request), haveAvatar)){
            return ResponseEntity.success();
        }
        return ResponseEntity.failed();
    }

    /**
     * 上传文章图片
     * @param files 多个图片文件
     * @return 前端编辑器指定的响应数据格式
     */
    @RequestMapping(value = "/article/img", method = RequestMethod.POST)
    public ResponseEntity<ArticleImgVO> uploadArticleImg(MultipartFile[] files){
        ArticleImgVO data = uploadService.uploadArticleImg(files);
        return new ResponseEntity<>(0, "上传成功", data);
    }
}
