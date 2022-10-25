package com.db.community.service;

import com.db.community.model.vo.impl.ArticleImgVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    boolean uploadAvatar(MultipartFile file, Integer userId, boolean haveAvatar);

    ArticleImgVO uploadArticleImg(MultipartFile[] files);

    String uploadArticleMainPic(MultipartFile file);
}
