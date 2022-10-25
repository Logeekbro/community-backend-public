package com.db.community.common.api;


public interface ResultDetail {
    /**
     * 响应码: -1失败;200成功
     *
     * @return 响应码
     */
    Integer getCode();

    /**
     * 描述
     *
     * @return 描述
     */
    String getMessage();
}
