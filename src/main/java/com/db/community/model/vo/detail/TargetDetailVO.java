package com.db.community.model.vo.detail;

import com.db.community.model.vo.UserVO;
import lombok.Data;

/**
 * 用户聊天列表中显示的信息
 */
@Data
public class TargetDetailVO {

    private UserVO targetInfo;

    private String previewContent;
}
