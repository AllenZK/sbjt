package com.example.sbjt.web.controller;

import com.example.sbjt.common.annos.Alog;
import com.example.sbjt.common.beans.StateCode;
import com.example.sbjt.po.User;
import com.example.sbjt.service.UserService;
import com.example.sbjt.web.forms.UserForm;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Alog("用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<User> users = userService.list();
        request.setAttribute("users",users);
        return "list";
    }

    @Alog("添加、修改用户")
    @RequestMapping(value = "/{aid}",method = {RequestMethod.GET,RequestMethod.POST})
    public String addUser(@PathVariable("aid")long aid, @ModelAttribute UserForm userForm, HttpServletRequest request){
        if ("POST".equals(request.getMethod())){
            if (userForm.validate(request)){
                User user = userForm.excute(request);
                if (user == null){
                    return "error";
                }
            }
            return "redirect:/user/list";
        }
        User user = userService.get(aid);
        if (user == null){
            user = new User();
        }
        request.setAttribute("uuu",user);
        return "add";
    }

    @Alog("删除用户")
    @RequestMapping(value = "/{uid}",method = RequestMethod.DELETE)
    @ResponseBody
    public StateCode deleteUser(@PathVariable("uid")long uid){
        StateCode sc = new StateCode("success","删除成功");
        boolean b = userService.deleteUser(uid);
        if (b){
            return sc;
        }else {
            sc.setCode("error");
            sc.setMessage("删除失败");
            return sc;
        }

    }

}
