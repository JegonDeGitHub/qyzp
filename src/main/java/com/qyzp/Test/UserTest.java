package com.qyzp.Test;


import com.qyzp.bean.User;
import com.qyzp.controller.BaseApiController;
import com.qyzp.dao.UserDao;
import com.qyzp.service.UserService;
import com.qyzp.service.impl.UserServiceImpl;

public class UserTest extends BaseApiController {

    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        User user = new User().setUname("3435ggg").setPassword("4354654yuty");
        User user1 = new User().setUname("3435gggg").setPassword("4354654aaayuty");
        inserts(user,user1);//批量添加
//        inserts(null);
//        inserts(new User());
//        inserts(new User(),new User());
    }

    public static void inserts(User... users) {//默认长度为零
        User[] _users = users;
        if (userService.registerUsers(_users)==0){
            System.out.println("批量插入失败");
        }
        System.out.println("批量插入成功");
    }
}
