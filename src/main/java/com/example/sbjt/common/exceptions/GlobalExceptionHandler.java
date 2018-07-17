package com.example.sbjt.common.exceptions;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @auth: Created by zk on 2018/7/12
 * @description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 全局异常处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String quanju(HttpServletRequest request,Exception e){
        System.out.println("********产生异常*******");
        Map<String,String> map = new HashMap<>();

        map.put("error_type",e.getClass().getName());
        map.put("error_info",e.getMessage());
        return JSON.toJSONString(map);
    }

}
