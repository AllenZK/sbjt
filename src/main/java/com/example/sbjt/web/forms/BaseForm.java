package com.example.sbjt.web.forms;

import javax.servlet.http.HttpServletRequest;

/**
 * @auth: Created by zk on 2018/7/13
 * @description: 表单基础接口
 */
public interface BaseForm<T> {

    public abstract boolean validate(HttpServletRequest request);

    public  abstract T excute(HttpServletRequest request);
}
