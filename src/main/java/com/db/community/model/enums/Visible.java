package com.db.community.model.enums;

/**
 * 定义查询时的可见性类型
 * VISIBLE：只查询可见的记录
 * UN_VISIBLE: 只查询不可见的记录
 * ALL：查询所有记录
 */
public enum Visible {
    VISIBLE,
    UN_VISIBLE,
    ALL;

    Visible() {
    }
}
