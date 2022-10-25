package com.db.community.common.api;


public enum ApiResultDetail implements ResultDetail {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),
    /**
     * 未登录，Token过期
     */
    UNAUTHORIZED(401, "请先登录"),
    /**
     * 权限不足
     */
    FORBIDDEN(402, "权限不足"),
    /**
     * 参数校验错误
     */
    VALIDATE_FAILED(403, "参数检验失败"),

    /**
     * 资源不存在
     */
    NOT_FOUND(404, "资源不存在"),

    /**
     * 账号封禁中
     */
    BANED(601, "账号封禁中"),

    /**
     * 需要进行身份验证
     */
    NEED_VERIFY(701, "需要进行身份验证");

    private final Integer code;
    private final String message;

    ApiResultDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
