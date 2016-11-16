package com.nlte.usersys.usermgr.view;

import com.nlte.usersys.common.util.ScannerUtil;
import com.nlte.usersys.usermgr.domain.User;

import java.util.List;
import java.util.Scanner;

/**
 * Created by hp on 2016/11/15.
 */
public class AdminFrame extends NormalFrame {

    public AdminFrame(User user) {
        super(user);
    }


    @Override
    public void show() {
        while (true) {
            System.out.println("-----管理员界面-----");
            System.out.println("1、添加用户");
            System.out.println("2、更新用户信息");
            System.out.println("3、查询用户信息");
            System.out.println("4、删除用户信息");
            System.out.println("5、退出登录");

            Scanner in = ScannerUtil.getScanner();
            int i = in.nextInt();

            switch (i) {
                case 1:
                    addShow();
                    break;
                case 2:
                    updateShow();
                    break;
                case 3:
                    searchShow();
                    break;
                case 4:
                    delShow();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("请输入正确选项");
                    break;
            }
        }
    }

    @Override
    public void searchShow() {
        System.out.println("1、根据用户id查询");
        System.out.println("2、根据用户名查询");
        System.out.println("3、查询所有用户");

        Scanner in = ScannerUtil.getScanner();

        int i = in.nextInt();

        switch (i) {
            case 1:
                System.out.println("请输入用户id：");
                User user = userController.doFindById(in.nextInt());
                System.out.println(user.toString());
                break;
            case 2:
                System.out.println("请输入用户名：");
                List<User> userList = userController.doFindByName(in.next());
                listShow(userList);
                break;
            case 3:
                System.out.println("用户的所有信息为：");
                List<User> userList1 = userController.doFindAllUsers();
                listShow(userList1);
                break;
            default:
                System.out.println("请输入正确的选项");
                break;
        }
    }

    @Override
    public void updateShow() {
        super.updateShow();
    }

    @Override
    public void addShow() {
        User user = new User();
        Scanner in = ScannerUtil.getScanner();

        System.out.println("------添加用户------");
        System.out.println("请输入用户名：");
        user.setUsername(in.next());

        System.out.println("请输入密码：");
        user.setPassword(in.next());

        System.out.println("请输入用户权限：");
        user.setRule(in.next());

        System.out.println("请输入真实姓名：");
        user.setRealName(in.next());

        System.out.println("请输入性别(1、男 2、女)：");
        user.setSex(in.nextInt());

        System.out.println("请输入生日(格式：yyyy/MM/dd)：");
        user.setBirthday(in.next());

        boolean b = userController.doAdd(user);
        if (b) {
            System.out.println("添加用户成功");
            return;
        } else {
            System.out.println("添加用户失败，请重新添加用户！");
        }
    }

    public void loginSuccShow() {

    }

    public void delShow() {
        System.out.println("请输入用户id");
        Scanner in = ScannerUtil.getScanner();
        boolean b = userController.doDel(in.nextInt());
        if (b) {
            System.out.println("删除用户成功");
        } else {
            System.out.println("删除用户失败");
        }
    }

    public void listShow(List<User> userList) {
        for (User user :
                userList) {
            System.out.println(user.toString());
        }
    }
}
