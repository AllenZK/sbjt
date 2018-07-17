package com.example.sbjt.common.annos;

import java.lang.annotation.*;

/**
 * @auth: Created by zk on 2018/7/12
 * @description: 日志注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Alog {

    String value() default "";
}
