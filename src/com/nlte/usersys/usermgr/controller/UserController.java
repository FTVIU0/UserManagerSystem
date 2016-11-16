package com.nlte.usersys.usermgr.controller;

import com.nlte.usersys.usermgr.business.service.UserServiceImpl;
import com.nlte.usersys.usermgr.domain.User;

import java.util.List;

/**
 * Created by hp on 2016/11/15.
 */
public class UserController {
    UserServiceImpl userService = UserServiceImpl.getUserService();

    public boolean doAdd(User user) {

        return userService.addUser(user);
    }

    public boolean doDel(int id) {
        return userService.delUser(id);
    }

    public List<User> doFindAllUsers() {
        return userService.findAll();
    }

    public User doFindById(int id) {
        return userService.findUserById(id);
    }

    public List<User> doFindByName(String name) {
        return userService.findUserByName(name);
    }

    public boolean doUpdate(User user) {
        return userService.updateUser(user);
    }

    public User doLogin(String username, String pwd){
        return userService.login(username, pwd);
    }

}
