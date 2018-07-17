package com.example.sbjt.web.controller;

import com.example.sbjt.common.annos.Alog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {

    @Value("${test}")
    private String test;

    @Alog("hello测试")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String hello(){
        System.out.println(test);
        return "hello word!" +test;
    }



}
