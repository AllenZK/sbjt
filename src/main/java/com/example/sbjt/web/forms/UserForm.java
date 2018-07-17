package com.example.sbjt.web.forms;

import com.example.sbjt.po.User;
import com.example.sbjt.service.UserService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * @auth: Created by zk on 2018/7/13
 * @description:
 */
public class UserForm implements BaseForm<User>{

    private long id;

    private String name;

    private String password;

    private int age;


    @Override
    public boolean validate(HttpServletRequest request) {
        return true;
    }

    @Override
    public User excute(HttpServletRequest request) {
        UserService userService = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean(UserService.class);
        User user = new User();
        if (id>0){
            user.setId(id);
        }
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        User _user = userService.addUser(user);
        return _user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
