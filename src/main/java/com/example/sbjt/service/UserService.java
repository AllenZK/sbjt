package com.example.sbjt.service;

import com.example.sbjt.po.User;

import java.util.List;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
public interface UserService {

    List<User> list();

    User addUser(User user);

    boolean deleteUser(long uid);

    User get(long aid);
}
