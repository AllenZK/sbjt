package com.example.sbjt.web.controller;

import com.example.sbjt.common.annos.Alog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auth: Created by zk on 2018/7/13
 * @description:
 */
@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    @Alog("通用页面跳转")
    @RequestMapping(value = "/page/{page}",method = RequestMethod.GET)
    private String toPage(@PathVariable("page")String page){
        return page;
    }

}
