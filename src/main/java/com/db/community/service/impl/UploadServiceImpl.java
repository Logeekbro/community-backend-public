package com.db.community.service.impl;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.lang.UUID;
import com.db.community.common.GlobalVars;
import com.db.community.exception.ApiAsserts;
import com.db.community.model.vo.impl.ArticleImgVO;
import com.db.community.service.UploadService;
import com.db.community.service.UserService;
import com.db.community.utils.ImageUtil;
import com.db.community.utils.OSSUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private UserService userService;

    @Override
    public boolean uploadAvatar(MultipartFile file, Integer userId, boolean haveAvatar) {
        try {
            String type = FileTypeUtil.getType(file.getInputStream());
            if(!GlobalVars.ACCEPT_IMG_TYPE.contains(type)){
                ApiAsserts.fail("只能上传jpg/png格式的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ApiAsserts.fail("上传失败");
        }
        String objectName = GlobalVars.AVATAR_URL_PREFIX + userId + ".jpg";
        OSSUtil.uploadObject(objectName, file);
        String avatar = GlobalVars.OSS_FILE_PREFIX + objectName;
        if(!haveAvatar){
            return userService.updateAvatarById(avatar, userId);
        }
        return true;
    }

    @Override
    public ArticleImgVO uploadArticleImg(MultipartFile[] files) {
        ArticleImgVO data = new ArticleImgVO();
        Map<String, String> succMap = new HashMap<>();
        List<String> errFiles = new ArrayList<>();
        for(MultipartFile file : files){
            try {
                String type = ImageUtil.getImgType(file);
                String objectName = GlobalVars.ARTICLE_IMG_URL_PREFIX + UUID.fastUUID().toString(true) + "." + type;
                if(OSSUtil.uploadObject(objectName, file)){
                    String url = GlobalVars.OSS_FILE_PREFIX + objectName;
                    succMap.put(file.getOriginalFilename(), url);
                }
                else{
                    errFiles.add(file.getOriginalFilename());
                }
            } catch (Exception e) {
                e.printStackTrace();
                errFiles.add(file.getOriginalFilename());
            }

        }
        data.setErrFiles(errFiles);
        data.setSuccMap(succMap);
        return data;
    }

    @Override
    public String uploadArticleMainPic(MultipartFile file) {
        String fileType = ImageUtil.getImgType(file);
        String objectName = GlobalVars.ARTICLE_MAIN_PIC_PREFIX + UUID.fastUUID().toString(true) + "." + fileType;
        if(OSSUtil.uploadObject(objectName, file)) {
            return GlobalVars.OSS_FILE_PREFIX + objectName;
        }
        return null;
    }
}
