package com.qyzp.bean;

import com.qyzp.bean.enums.RoleType;

import java.util.List;

public class User {
    private Integer id;
    private String uname;
    private String password;
    private String email ;
    private String tel;
    private RoleType roleType;//角色类型
    private String willPosition;//期待职位
    private String sex;//
    private String headPic;//头像路径
    private String detail;//详细信息
    private String userName;//真名

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public User setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public User setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public User setRoleType(RoleType roleType) {
        this.roleType = roleType;
        return this;
    }

    public String getWillPosition() {
        return willPosition;
    }

    public User setWillPosition(String willPosition) {
        this.willPosition = willPosition;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getHeadPic() {
        return headPic;
    }

    public User setHeadPic(String headPic) {
        this.headPic = headPic;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public User setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", roleType=" + roleType +
                ", willPosition='" + willPosition + '\'' +
                ", sex='" + sex + '\'' +
                ", headPic='" + headPic + '\'' +
                ", detail='" + detail + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
