package com.qyzp.service;

import com.qyzp.bean.User;

import java.util.List;

public interface UserService {
    //注册用户
    int registerUser(User user);
    //批量注册用户
    int registerUsers(User... users);
    // 根据用户id查询用户信息
    //登录
    User loginByUname(String uname);
    User loginByPhone(String tel);
    User loginByEmail(String email);
    //查询所有用户信息
    List<User> queryAllUser();
    //修改用户信息
    int updateUser(User user);
    //批量修改用户信息
    int updateUsers(User[] users,Integer... ids);
    //根据id查询用户
    User queryUserById(Integer id);
    //修改密码
    int updatePassword(Integer id,String newPassword);
    //修改头像
    int updateHead(Integer id,String headPic);
    //根据id删除用户
    int deleteUserById(Integer id);
    //批量根据id删除用户
    int deleteUserByIds(int[] ids);

}
