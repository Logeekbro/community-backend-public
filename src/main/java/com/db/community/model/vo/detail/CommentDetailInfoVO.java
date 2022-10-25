package com.db.community.model.vo.detail;

import com.db.community.model.vo.CommentVO;
import com.db.community.model.vo.UserVO;
import com.db.community.model.vo.impl.CommentInfoVO;
import com.db.community.model.vo.impl.UserPreviewInfoVO;
import lombok.Data;

import java.io.Serializable;

/**
 * 评论列表中展示的信息
 */
@Data
public class CommentDetailInfoVO implements Serializable {

    private UserPreviewInfoVO user;

    private CommentInfoVO comment;

}
