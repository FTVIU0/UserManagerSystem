package com.nlte.usersys.usermgr.business.service;

import com.nlte.usersys.usermgr.domain.User;

import java.util.List;

/**
 * Created by hp on 2016/11/15.
 */
public interface UserService {
    boolean addUser(User user);
    boolean delUser(int id);
    List<User> findAll();
    User findUserById(int id);
    List<User> findUserByName(String name);
    User login(String username, String pwd);
    boolean updateUser(User user);
}
