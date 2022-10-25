package com.db.community.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记在Controller方法上，且方法的返回值必须为：ResponseEntity T=SingleKeyVO
 * 用于回收从 SingleKeyVOFactory 中获取的 SingleKeyVO
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleKeyVORecycle {
}
