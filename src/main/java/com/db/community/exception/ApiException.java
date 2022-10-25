package com.db.community.exception;

import com.db.community.common.api.ResultDetail;


public class ApiException extends RuntimeException {
    private ResultDetail errorCode;

    public ApiException(ResultDetail errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ResultDetail getErrorCode() {
        return errorCode;
    }
}
