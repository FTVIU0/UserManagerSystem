package com.nlte.usersys.usermgr.business.service;

import com.nlte.usersys.usermgr.business.dao.UserDAOImpl;
import com.nlte.usersys.usermgr.domain.User;

import java.util.List;

/**
 * Created by hp on 2016/11/15.
 */
public class UserServiceImpl implements UserService {

    UserDAOImpl userDao = new UserDAOImpl();

    private static UserServiceImpl userService= null;

    public static UserServiceImpl getUserService() {
        if (userService == null){
            return new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean delUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User login(String username, String pwd) {
        return userDao.login(username, pwd);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
