package com.db.community.exception;

import com.db.community.common.api.ResultDetail;


public class ApiAsserts {
    /**
     * 抛失败异常
     *
     * @param message 说明
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * 抛失败异常
     *
     * @param errorCode 状态码
     */
    public static void fail(ResultDetail errorCode) {
        throw new ApiException(errorCode);
    }
}
