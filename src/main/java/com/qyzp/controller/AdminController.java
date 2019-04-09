package com.qyzp.controller;

import com.qyzp.bean.Admin;
import com.qyzp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController extends  BaseApiController{

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")//登录
    public Map<String,Object> login(String uname, String password, HttpSession session) {
        Admin admin =null ;
        admin = adminService.login(uname);
        if(admin == null){return request(400,"该用户不存在",null);}
        if(!admin.getPassword().equals(password)){return request(400,"密码错误",null);}
        session.setAttribute("admin",admin);//session域中放入用户对象
        return resp(200,"登录成功",admin);
    }
}
