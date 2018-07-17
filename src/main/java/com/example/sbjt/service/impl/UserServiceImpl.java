package com.example.sbjt.service.impl;

import com.example.sbjt.persist.UserPersist;
import com.example.sbjt.po.User;
import com.example.sbjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersist userPersist;

    @Override
    public List<User> list() {
        List<User> all = userPersist.findAll();
        return all;
    }

    @Override
    public User addUser(User user) {
        User save = null;
        try {
            save = userPersist.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return save;
    }

    @Override
    public boolean deleteUser(long uid) {
        try {
            userPersist.delete(uid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User get(long aid) {
        User one = userPersist.findOne(aid);
        return one;
    }
}
