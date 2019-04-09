package com.qyzp.service.impl;

import com.qyzp.bean.Admin;
import com.qyzp.dao.AdminDao;
import com.qyzp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String uname) {
        return adminDao.login(uname);
    }
}
