package com.db.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.community.model.entity.View;
import com.db.community.model.enums.CountType;
import com.db.community.model.vo.impl.ViewHistoryInfoVO;
import com.db.community.model.vo.impl.ViewHistoryInfoWithDateVO;
import com.db.community.mq.provider.UserViewProvider;
import com.db.community.service.ArticleService;
import com.db.community.service.CountService;
import com.db.community.service.ViewService;
import com.db.community.mapper.ViewMapper;
import com.db.community.utils.JwtUtil;
import com.db.community.utils.MySimplePage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.db.community.common.GlobalVars.VIEW_QUEUE;

/**
 * @author bin
 * @description 针对表【tb_view】的数据库操作Service实现
 * @createDate 2022-06-21 14:34:13
 */
@Slf4j
@Service
public class ViewServiceImpl extends ServiceImpl<ViewMapper, View>
        implements ViewService {

    @Resource
    private ViewMapper viewMapper;

    @Resource
    private CountService countService;

    @Resource
    private UserViewProvider userViewProvider;

    private final List<View> saveToDBViewList = new LinkedList<>();


    @Override
    public void handleUserView(String articleId, Integer userId) {
        CompletableFuture.runAsync(() -> {
            if (!viewMapper.exist(userId, articleId)) {
                countService.handleCount(CountType.VIEW, articleId, true);
            }
        });
        userViewProvider.saveUserView(articleId, userId);
    }

    @Override
    public boolean deleteById(String viewId, Integer userId) {
        LambdaQueryWrapper<View> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(View::getViewId, viewId);
        queryWrapper.eq(View::getReaderId, userId);
        return viewMapper.delete(queryWrapper) > 0;
    }

    @Override
    public boolean deleteAllByUserId(Integer userId) {
        LambdaQueryWrapper<View> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(View::getReaderId, userId);
        return viewMapper.delete(queryWrapper) > 0;
    }

    @Override
    public MySimplePage<ViewHistoryInfoVO> getUserHistory(String userToken, Long current, Long size) {
        Integer userId = JwtUtil.getUserId(userToken);
        Long total = viewMapper.selectCountByUserId(userId);
        MySimplePage<ViewHistoryInfoVO> page = new MySimplePage<>(current, size, total);
        List<ViewHistoryInfoVO> vos = viewMapper.selectViewHistoryByUserId(page.offset(), size, userId);
        page.setRecords(vos);
        return page;
    }

    @Override
    public ViewHistoryInfoWithDateVO getUserHistoryByDate(Integer userId, String targetDate) {
        List<ViewHistoryInfoVO> vos = viewMapper.selectUserHistoryByDate(userId, targetDate);
        ViewHistoryInfoWithDateVO vo = new ViewHistoryInfoWithDateVO();
        vo.setTargetDate(targetDate);
        vo.setRecords(vos);
        vo.setBeforeDate(viewMapper.selectBeforeDate(userId, targetDate));
        return vo;
    }

    @Override
    public void saveToDB() {
        int fetchCount = Math.min(VIEW_QUEUE.size(), 2000);
        if (fetchCount > 0) {
            log.info("开始将历史记录存入数据库...");
            for (int i = 0; i < fetchCount; i++) {
                saveToDBViewList.add(VIEW_QUEUE.poll());
            }
            saveBatch(saveToDBViewList, 2000);
            saveToDBViewList.clear();
            log.info("保存完毕");
        }
    }
}




