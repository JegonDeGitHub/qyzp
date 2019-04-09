package com.qyzp.bean;

import com.qyzp.bean.enums.RoleType;

public class Admin {
    private Integer id;
    private String uname;
    private String password;
    private RoleType roleType;

    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public Admin setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Admin setRoleType(RoleType roleType) {
        this.roleType = roleType;
        return this;
    }
}
