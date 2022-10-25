package com.db.community.model.vo.impl;

import com.db.community.model.vo.ViewVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ViewHistoryInfoWithDateVO implements ViewVO, Serializable {

    List<ViewHistoryInfoVO> records;

    /**
     * 前一个有历史记录的日期
     */
    private String beforeDate;

    /**
     * 当前历史记录列表的日期
     */
    private String targetDate;

}
