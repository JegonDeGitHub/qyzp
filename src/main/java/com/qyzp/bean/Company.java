package com.qyzp.bean;

import com.qyzp.bean.enums.RoleType;

import java.util.List;

public class Company {
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private String tel;
    private String companyName;
    private String address;
    private String headPic;
    private String detail;
    private RoleType roleType;
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public Company setJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Company setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public Company setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Company setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public Company setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHeadPic() {
        return headPic;
    }

    public Company setHeadPic(String headPic) {
        this.headPic = headPic;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Company setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Company setRoleType(RoleType roleType) {
        this.roleType = roleType;
        return this;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", headPic='" + headPic + '\'' +
                ", detail='" + detail + '\'' +
                ", roleType=" + roleType +
                '}';
    }
}
