package com.example.sbjt.persist;

import com.example.sbjt.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
public interface UserPersist extends JpaRepository<User,Long> {


}
