package com.nlte.usersys.usermgr.business.dao;

import com.nlte.usersys.common.exception.DaoException;
import com.nlte.usersys.common.util.DBUtil;
import com.nlte.usersys.common.util.TypeUtils;
import com.nlte.usersys.usermgr.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2016/11/14.
 */
public class UserDAOImpl implements UserDAO {
    Connection conn = DBUtil.getConnection();


    /**
     * 添加用户
     *
     * @param user 用户
     * @return
     */
    @Override
    public boolean addUser(User user) {
        String sql =
                "insert into tab_user"
                        + "  (id, username, password, rule, realname, sex, birthday)"
                        + "values"
                        + "  (seq_tab_user.nextval, ?, ?, ?, ?, ?, to_date(?,'yyyy-MM-dd'))";

        int update = DBUtil.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getRule(),
                user.getRealName(),
                user.getSex(),
                user.getBirthday());

        if (update > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return
     */
    @Override
    public boolean deleteUser(int id) {
        String sql = "delete tab_user where id = ?";
        int update = DBUtil.update(sql, id);
        if (update > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询所有用户
     *
     * @return 返回用户信息列表
     */
    @Override
    public List<User> findAll() {
        String sql = "select * from tab_user";
        ResultSet search = DBUtil.search(sql);

        List<User> userList = new ArrayList<>();
        try {

            while (search.next()) {
                User user = new User();
                user.setId(search.getInt("id"));
                user.setUsername(search.getString("username"));
                user.setPassword(search.getString("password"));
                user.setRule(search.getString("rule"));
                user.setRealName(search.getString("realname"));

                //// TODO: 2016/11/14 此处格式转换有问题，请注意
                user.setBirthday(TypeUtils.dateToStr(search.getDate("birthday"), "yyyy-MM-dd"));
                user.setSex(search.getInt("sex"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("查询出错");
        }
        return userList;
    }

    /**
     * 查询用户的最大id
     *
     * @return
     */
    @Override
    public int findMaxId() {
        return -1;
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return
     */
    @Override
    public User findUserById(int id) {
        String sql = "select * from tab_user where id = ?";
        ResultSet search = DBUtil.search(sql, id);

        User user = new User();
        try {
            search.next();
            user.setId(search.getInt("id"));
            user.setUsername(search.getString("username"));
            user.setPassword(search.getString("password"));
            user.setRule(search.getString("rule"));
            user.setRealName(search.getString("realname"));

            //// TODO: 2016/11/14 此处格式转换有问题，请注意
            user.setSex(search.getInt("sex"));
            user.setBirthday(TypeUtils.dateToStr(search.getDate("birthday"), "yyyy-MM-dd"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("查询出错");
        }

        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        String sql = "select * from tab_user where username=?";
        ResultSet search = DBUtil.search(sql, name);

        List<User> userList = new ArrayList<>();
        try {
            while (search.next()) {
                User user = new User();
                user.setId(search.getInt("id"));
                user.setUsername(search.getString("username"));
                user.setPassword(search.getString("password"));
                user.setRealName(search.getString("realname"));
                user.setRule(search.getString("rule"));

                //// TODO: 2016/11/14 此处格式转换有问题，请注意
                user.setSex(search.getInt("sex"));
                user.setBirthday(TypeUtils.dateToStr(search.getDate("birthday"), "yyyy-MM-dd"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("查询出错");
        }
        return userList;
    }

    @Override
    public int getRecordCount() {
        String sql = "select count(*) from tab_user";
        int count = (int) DBUtil.searchObjects(sql);
        return count;
    }

    @Override
    public User login(String username, String pwd) {
        String sql = "select * from tab_user where username=? and password = ?";
        ResultSet search = DBUtil.search(sql, username, pwd);
        User user = null;
        try {
            while (search.next()) {
                user = new User();
                user.setId(search.getInt("id"));
                user.setUsername(search.getString("username"));
                user.setPassword(search.getString("password"));
                user.setRealName(search.getString("realname"));
                user.setRule(search.getString("rule"));

                //// TODO: 2016/11/14 此处格式转换有问题，请注意
                user.setSex(search.getInt("sex"));
                user.setBirthday(TypeUtils.dateToStr(search.getDate("birthday"), "yyyy-MM-dd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    /**
     * 对用户数据进行更新操作
     *
     * @param user 需要更新数据的用户
     * @return
     */
    @Override
    public boolean updateUser(User user) {

        String sql = "update tab_user "
                + "set username = ?, "
                + "password = ?, "
                + "realname = ?, "
                + "rule = ?, "
                + "sex = ?, "
                + "birthday = to_date(?, 'yyyy-MM-dd') "
                + "where id = ?";
        int update = DBUtil.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getRealName(),
                user.getRule(),
                user.getSex(),
                user.getBirthday(),
                user.getId());
        if (update > 0) {
            return true;
        }
        return false;
    }
}
