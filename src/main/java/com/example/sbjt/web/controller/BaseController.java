package com.example.sbjt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
public class BaseController {

    private final Logger log  = LoggerFactory.getLogger(this.getClass());

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
    }*/
}
