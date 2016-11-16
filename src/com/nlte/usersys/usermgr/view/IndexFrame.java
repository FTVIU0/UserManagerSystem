package com.nlte.usersys.usermgr.view;

import com.nlte.usersys.common.util.ScannerUtil;
import com.nlte.usersys.usermgr.controller.UserController;
import com.nlte.usersys.usermgr.domain.User;

import java.util.Scanner;

/**
 * Created by hp on 2016/11/15.
 */
public class IndexFrame implements BaseFrame {

    UserController userController = new UserController();

    @Override
    public void addShow() {
        User user = new User();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = ScannerUtil.getScanner();

        System.out.println("用户注册");
        System.out.println("请输入用户名：");
        user.setUsername(in.next());

        System.out.println("请输入密码：");
        user.setPassword(in.next());

        System.out.println("请输入真实姓名：");
        user.setRealName(in.next());

        System.out.println("请输入性别(1、男 2、女)：");
        user.setSex(in.nextInt());

        System.out.println("请输入生日(格式：yyyy/MM/dd)：");
        user.setBirthday(in.next());

        boolean b = userController.doAdd(user);
        if (b) {
            System.out.println("注册成功");
            loginShow();
        } else {
            System.out.println("注册失败，请重新注册！");
        }
    }

    @Override
    public void searchShow() {

    }

    public void loginShow() {
        Scanner in = ScannerUtil.getScanner();

        System.out.println("登录");
        System.out.println("请输入用户名：");
        String username = in.next();

        System.out.println("请输入密码：");
        String pwd = in.next();

        User user = userController.doLogin(username, pwd);
        if (user != null) {
            System.out.println("登录成功！");
            if (user.getRule().equals("1")) {
                AdminFrame adminFrame = new AdminFrame(user);
                adminFrame.show();
            } else {
                NormalFrame normalFrame = new NormalFrame(user);
                normalFrame.show();
            }
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    @Override
    public void show() {
        System.out.println("欢迎");
        while (true) {
            System.out.println("1、登录");
            System.out.println("2、注册");
            System.out.println("3、退出系统");

            Scanner in = ScannerUtil.getScanner();


            switch (in.nextInt()) {
                case 1:
                    loginShow();
                    break;
                case 2:
                    addShow();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
            }
        }
    }

    @Override
    public void updateShow() {

    }
}
