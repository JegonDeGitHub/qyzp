package com.qyzp.service.impl;

import com.qyzp.bean.User;
import com.qyzp.dao.UserDao;
import com.qyzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int registerUser(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public int updateUsers(User[] users,Integer... ids) {
        return userDao.updateUsers(users,ids);
    }

    @Override
    public int registerUsers(User[] users) {
        return userDao.registerUsers(users);
    }

    @Override
    public User loginByUname(String uname) { return userDao.loginByUname(uname); }
    @Override
    public User loginByPhone(String tel) {
        return userDao.loginByPhone(tel);
    }
    @Override
    public User loginByEmail(String email) {
        return userDao.loginByEmail(email);
    }

   /* @Override
    public User login(String uname) {
        return userDao.login(uname);
    }*/

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public int updatePassword(Integer id, String newPassword) {
        return userDao.updatePassword(id,newPassword);
    }

    @Override
    public int updateHead(Integer id, String headPic) {
        return userDao.updateHead(id,headPic);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int deleteUserByIds(int[] ids) {
        return userDao.deleteUserByIds(ids);
    }
}
