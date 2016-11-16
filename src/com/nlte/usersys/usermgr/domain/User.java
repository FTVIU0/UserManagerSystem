package com.nlte.usersys.usermgr.domain;

/**
 * M（模型层）（用户实体类(Bean)）
 * Created by hp on 2016/11/14.
 */
public class User {
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限(1、管理员 2、普通用户)
     */
    private String rule;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private int sex;
    /**
     * 市信息字典ID值
     */
    private int city;
    /**
     * 证件类型字典ID值
     */
    private int certType;
    /**
     * 证件号码
     */
    private String cert;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 旅客类型字典ID值
     */
    private int userType;
    /**
     * 备注
     */
    private String content;
    /**
     * 用户状态（0、无效  1、有效 ）
     */
    private int status;
    /**
     * 登陆IP
     */
    private String loginIp;
    /**
     * 用户头像路径
     */
    private String imagepath;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        if (username == null) {
            username = "默认";
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        if (password == null) {
            password = "0000";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        if (rule == null) {
            rule = "2";
        }
        return rule;
    }

    public void setRule(String rule) {

        this.rule = rule;
    }

    public String getRealName() {
        if (realName == null) {
            realName = "默认";
        }
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getCity() {
        if (city == 0) {
            city = 110;
        }
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getCertType() {
        if (certType == 0) {
            certType = 110;
        }
        return certType;
    }

    public void setCertType(int certType) {
        this.certType = certType;
    }

    public String getCert() {
        if (cert == null) {
            cert = "11111";
        }
        return cert;
    }

    public void setCert(String cert) {

        this.cert = cert;
    }

    public String getBirthday() {
        if (birthday == null) {
            birthday = "2016/11/13";
        }
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getUserType() {
        if (userType == 0) {
            userType = 112;
        }
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getContent() {
        if (content == null) {
            content = "默认";
        }
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        if (status == 0) {
            status = 0;
        }
        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public String getLoginIp() {
        if (loginIp == null) {
            loginIp = "默认";
        }
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getImagepath() {
        if (imagepath == null) {
            imagepath = "123";
        }
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rule='" + rule + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", city=" + city +
                ", certType=" + certType +
                ", cert='" + cert + '\'' +
                ", birthday=" + birthday +
                ", userType=" + userType +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}
