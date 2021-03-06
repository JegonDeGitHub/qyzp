package com.qyzp.service;

import com.qyzp.bean.Company;
import com.qyzp.bean.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    //注册公司
    int registerCompany(Company company);
    //批量注册公司
    int registerCompanys(Company... company);
    //登录
    Company loginByUname(String uname);
    Company loginByPhone(String tel);
    Company loginByEmail(String email);
    //查询所有公司信息
    List<Company> queryAllCompany();
    //修改公司信息
    int updateCompany(Company company);
    //修改头像
    int updateHead(Integer id,String headPic);
    //批量修改公司信息
    int updateCompanys(Company[] companys,Integer... ids);
    //根据id查询公司
    Company queryCompanyById(Integer id);
    //修改密码
    int updatePassword(Integer id,String newPassword);
    //根据id删除公司
    int deleteCompanyById(Integer id);
    //批量根据id删除公司
    int deleteCompanyByIds(int[] ids);
}
