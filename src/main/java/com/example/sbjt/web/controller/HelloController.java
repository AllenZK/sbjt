package com.example.sbjt.web.controller;

import com.alibaba.fastjson.JSON;
import com.example.sbjt.common.annos.Alog;
import com.example.sbjt.po.Test;
import com.example.sbjt.po.TestInner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Alog("测试固定值")
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Test test(@RequestBody Test test){
        log.debug("提交的数据：{}", JSON.toJSONString(test));
        Test test1 = new Test();
        test1.setTestInner(new TestInner());
        test1.setName("测试名称");
        return test1;
    }

}
