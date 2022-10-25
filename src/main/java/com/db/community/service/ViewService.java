package com.db.community.service;

import com.db.community.model.entity.View;
import com.baomidou.mybatisplus.extension.service.IService;
import com.db.community.model.vo.impl.ViewHistoryInfoVO;
import com.db.community.model.vo.impl.ViewHistoryInfoWithDateVO;
import com.db.community.utils.MySimplePage;

/**
* @author bin
* @description 针对表【tb_view】的数据库操作Service
* @createDate 2022-06-21 14:34:13
*/
public interface ViewService extends IService<View> {

    void handleUserView(String articleId, Integer userId);

    boolean deleteById(String viewId, Integer userId);

    boolean deleteAllByUserId(Integer userId);

    MySimplePage<ViewHistoryInfoVO> getUserHistory(String userToken, Long current, Long size);

    ViewHistoryInfoWithDateVO getUserHistoryByDate(Integer userId, String targetDate);

    void saveToDB();
}
