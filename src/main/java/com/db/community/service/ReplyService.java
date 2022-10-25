package com.db.community.service;

import com.db.community.model.dto.ReplyCreateDTO;
import com.db.community.model.entity.Reply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.detail.ReplyDetailVO;
import com.db.community.utils.MyPage;

/**
* @author 86136
* @description 针对表【tb_reply】的数据库操作Service
* @createDate 2022-06-04 17:29:35
*/
public interface ReplyService extends IService<Reply> {

    boolean saveReply(String commentId, Integer userId, ReplyCreateDTO replyCreateDTO);

    MyPage<ReplyDetailVO> getListByCommentId(String commentId, Long current, Long size);

    boolean deleteById(String replyId, Integer userId);

    Long getCountByCommentId(String commentId);
}
