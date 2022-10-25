package com.db.community.common.api;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;


@Data
@NoArgsConstructor
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = -4153430394359594346L;
    /**
     * 业务状态码
     */
    private int code;
    /**
     * 结果集
     */
    private T data;
    /**
     * 接口描述
     */
    private String message;

    /**
     * 全参
     *
     * @param code    业务状态码
     * @param message 描述
     * @param data    结果集
     */
    public ResponseEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(ResultDetail errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(ApiResultDetail.FAILED);
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 成功
     *
     * @return {code:200,message:操作成功,data:自定义}
     */
    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>(ApiResultDetail.SUCCESS.getCode(), ApiResultDetail.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     *
     * @param data 结果集
     * @return {code:200,message:操作成功,data:自定义}
     */
    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>(ApiResultDetail.SUCCESS.getCode(), ApiResultDetail.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     *
     * @param data    结果集
     * @param message 自定义提示信息
     * @return {code:200,message:自定义,data:自定义}
     */
    public static <T> ResponseEntity<T> success(T data, String message) {
        return new ResponseEntity<T>(ApiResultDetail.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseEntity<T> failed() {
        return failed(ApiResultDetail.FAILED);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     * @return {code:枚举ApiErrorCode取,message:自定义,data:null}
     */
    public static <T> ResponseEntity<T> failed(String message) {
        return new ResponseEntity<T>(ApiResultDetail.FAILED.getCode(), message, null);
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return {code:封装接口取,message:封装接口取,data:null}
     */
    public static <T> ResponseEntity<T> failed(ResultDetail errorCode) {
        return new ResponseEntity<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     * @return {code:枚举ApiErrorCode取,message:自定义,data:null}
     */
    public static <T> ResponseEntity<T> failed(ResultDetail errorCode, String message) {
        return new ResponseEntity<T>(errorCode.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseEntity<T> validateFailed() {
        return failed(ApiResultDetail.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseEntity<T> validateFailed(String message) {
        return new ResponseEntity<T>(ApiResultDetail.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseEntity<T> unauthorized(T data) {
        return new ResponseEntity<T>(ApiResultDetail.UNAUTHORIZED.getCode(), ApiResultDetail.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseEntity<T> forbidden(T data) {
        return new ResponseEntity<T>(ApiResultDetail.FORBIDDEN.getCode(), ApiResultDetail.FORBIDDEN.getMessage(), data);
    }
}
