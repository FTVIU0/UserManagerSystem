package com.nlte.usersys.usermgr.business.dao;

import com.nlte.usersys.usermgr.domain.User;

import java.util.List;

/**
 * Created by hp on 2016/11/14.
 */
public interface UserDAO {
    boolean addUser(User user);
    boolean deleteUser(int id);
    List<User> findAll();
    int findMaxId();
    User findUserById(int id);
    List<User> findUserByName(String name);
    int getRecordCount();
    User login(String username, String pwd);
    boolean updateUser(User user);
}
