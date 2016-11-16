package com.nlte.usersys.usermgr.view;

import com.nlte.usersys.common.util.ScannerUtil;
import com.nlte.usersys.usermgr.domain.User;

import java.util.Scanner;

/**
 * Created by hp on 2016/11/15.
 */
public class NormalFrame extends IndexFrame {
    private User user;

    public NormalFrame(User user) {
        this.user = user;
    }

    @Override
    public void show() {

        while (true) {
            System.out.println("-----普通用户界面-----");
            System.out.println("1、查询个人信息");
            System.out.println("2、更新个人信息");
            System.out.println("3、退出登录");

            Scanner in = ScannerUtil.getScanner();
            int i = in.nextInt();
            switch (i) {
                case 1:
                    searchShow();
                    break;
                case 2:
                    updateShow();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("请输入正确选项（1、2、3）");
                    break;
            }
        }
    }

    @Override
    public void searchShow() {
        User user = userController.doFindById(this.user.getId());
        System.out.println(user.toString());
    }

    @Override
    public void updateShow() {
        Scanner in = ScannerUtil.getScanner();

        System.out.println("更新个人信息");
        System.out.println("1、修改用户名");
        System.out.println("2、修改密码");
        System.out.println("3、修改真实姓名");
        System.out.println("4、修改性别(1、男 2、女)");
        System.out.println("5、修改生日(格式：yyyy/MM/dd)");
        System.out.println("6、完成修改");

        int i = in.nextInt();

        switch (i) {
            case 1:
                System.out.println("请输入用户名：");
                user.setUsername(in.next());
                break;
            case 2:
                System.out.println("请输入密码：");
                user.setPassword(in.next());
                break;
            case 3:
                System.out.println("请输入真实姓名：");
                user.setRealName(in.next());
                break;
            case 4:
                System.out.println("请输入性别(1、男 2、女)：");
                user.setSex(in.nextInt());
                break;
            case 5:
                System.out.println("请输入生日(格式：yyyy/MM/dd)：");
                user.setBirthday(in.next());
                break;
            case 6:
                return;
            default:
                System.out.println("请输入正确选项！");
        }
        boolean b = userController.doUpdate(user);
        if (b) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }
}
