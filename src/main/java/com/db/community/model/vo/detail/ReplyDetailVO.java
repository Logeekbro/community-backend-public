package com.db.community.model.vo.detail;

import com.db.community.model.vo.ReplyVO;
import com.db.community.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReplyDetailVO implements Serializable {

    private ReplyVO reply;

    private UserVO user;

    private UserVO target;
}
