package com.db.community.exception;

import com.db.community.common.api.ApiResultDetail;
import com.db.community.common.api.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获自定义异常
     */
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Map<String, Object>> apiExceptionHandler(ApiException e) {
        if (e.getErrorCode() != null) {
            return ResponseEntity.failed(e.getErrorCode());
        }
        return ResponseEntity.failed(e.getMessage());
    }


    /**
     * 参数绑定失败抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String, Object>> bindExceptionHandler(BindException e) {
        FieldError error = e.getFieldError();
        if(error == null) {
            return ResponseEntity.failed(ApiResultDetail.VALIDATE_FAILED);
        }
        return ResponseEntity.failed(error.getDefaultMessage());
    }

    /**
     * 参数校验失败抛出的异常
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        FieldError error = ex.getBindingResult().getFieldError();
        ex.printStackTrace();
        if(error == null) {
            return ResponseEntity.failed(ApiResultDetail.VALIDATE_FAILED);
        }
        else {
            return ResponseEntity.failed(error.getDefaultMessage());
        }
    }

    /**
     * Spring Security校验失败时抛出的异常
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> authenticationExceptionHandler(AuthenticationException ex) {
        if(ex instanceof BadCredentialsException){
            return ResponseEntity.failed(ex.getMessage());
        }
        return ResponseEntity.unauthorized(null);
    }

    /**
     * 权限不足抛出的异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> accessDeniedExceptionHandler(AccessDeniedException ex) {
        return ResponseEntity.forbidden(null);
    }

    /**
     * 用户名不存在时抛出的异常
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, Object>> usernameNotFoundExceptionHandler(AccessDeniedException ex) {
        return ResponseEntity.failed("用户不存在");
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Map<String, Object>> systemExceptionHandler(Throwable ex) {
        ex.printStackTrace();
        return ResponseEntity.failed("服务器异常");
    }

}
