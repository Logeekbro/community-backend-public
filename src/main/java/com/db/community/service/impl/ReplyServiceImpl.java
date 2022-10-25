package com.db.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.model.dto.ReplyCreateDTO;
import com.db.community.model.entity.Reply;
import com.db.community.model.vo.detail.ReplyDetailVO;
import com.db.community.service.MultiTableService;
import com.db.community.service.ReplyService;
import com.db.community.mapper.ReplyMapper;
import com.db.community.utils.JwtUtil;
import com.db.community.utils.MyPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 86136
 * @description 针对表【tb_reply】的数据库操作Service实现
 * @createDate 2022-06-04 17:29:35
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
        implements ReplyService {

    @Resource
    private ReplyMapper replyMapper;

    @Resource
    private MultiTableService multiTableService;


    @Override
    public boolean saveReply(String commentId, Integer userId, ReplyCreateDTO replyCreateDTO) {
        // TODO 检查commentId是否存在
        Reply reply = new Reply();
        reply.setUserId(userId)
                .setCommentId(commentId)
                .setContent(replyCreateDTO.getContent())
                .setTarget(replyCreateDTO.getTarget());
        return replyMapper.insert(reply) > 0;
    }

    @Override
    public MyPage<ReplyDetailVO> getListByCommentId(String commentId, Long current, Long size) {
        return multiTableService.getReplyDetailListByCommentId(commentId, current, size);
    }

    @Override
    public boolean deleteById(String replyId, Integer userId) {
        Reply reply = replyMapper.selectById(replyId);
        if (Objects.isNull(reply) || !userId.equals(reply.getUserId())) {
            return false;
        }
        return replyMapper.deleteById(replyId) > 0;
    }

    @Override
    public Long getCountByCommentId(String commentId) {
        return replyMapper.selectCountByCommentId(commentId);
    }
}




