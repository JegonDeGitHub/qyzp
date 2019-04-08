package com.qyzp.dao;

import com.qyzp.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //注册用户
    int registerUser( User user);
    //批量注册用户
    int registerUsers(User[] users);
    //登录
    //User login(@Param("uname") String uname);
    User loginByUname(@Param("uname") String uname);
    User loginByPhone(@Param("tel") String tel);
    User loginByEmail(@Param("email") String email);
    //User login(User user);
    //查询所有用户信息
    List<User> queryAllUser();
    //修改用户信息
    int updateUser(User user);
    //批量修改用户信息
    int updateUsers(@Param("users") User[] users, @Param("ids") Integer... ids);
    // 根据id查用户
    User queryUserById(@Param("id") Integer id);
    //修改密码
    int updatePassword(@Param("id") Integer id,@Param("newPassword") String newPassword);
    //修改头像
    int updateHead(@Param("id") Integer id,@Param("headPic") String headPic);
    //根据id删除用户
    int deleteUserById(@Param("id") Integer id);
    //批量根据id删除用户
    int deleteUserByIds(int[] ids);
}
