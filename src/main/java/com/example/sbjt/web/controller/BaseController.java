package com.example.sbjt.web.controller;

import com.example.sbjt.common.annos.Alog;
import com.sun.beans.editors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
public class BaseController {

    public final Logger log  = LoggerFactory.getLogger(this.getClass());

    @Alog("mvc解决绑定参数类型转换问题")
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
        binder.registerCustomEditor(String.class, new StringEditor());
    }
}
