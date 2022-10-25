package com.db.community.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.mapper.LikeCountMapper;
import com.db.community.model.entity.LikeCount;
import com.db.community.service.LikeCountService;
import org.springframework.stereotype.Service;

@Service
public class LikeCountServiceImpl extends ServiceImpl<LikeCountMapper, LikeCount> implements LikeCountService {
}
