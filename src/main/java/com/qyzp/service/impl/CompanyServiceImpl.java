package com.qyzp.service.impl;

import com.qyzp.bean.Company;
import com.qyzp.dao.CompanyDao;
import com.qyzp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public int registerCompany(Company company) {
        return companyDao.registerCompany(company);
    }

    @Override
    public int registerCompanys(Company... companys) {
        return companyDao.registerCompanys(companys);
    }

    @Override
    public Company loginByUname(String uname) {
        return companyDao.loginByUname(uname);
    }

    @Override
    public Company loginByPhone(String tel) {
        return companyDao.loginByPhone(tel);
    }

    @Override
    public Company loginByEmail(String email) {
        return companyDao.loginByEmail(email);
    }

    @Override
    public List<Company> queryAllCompany() {
        return companyDao.queryAllCompany();
    }

    @Override
    public int updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    @Override
    public int updateHead(Integer id, String headPic) {
        return companyDao.updateHead(id,headPic);
    }

    @Override
    public int updateCompanys(Company[] companys, Integer... ids) {
        return companyDao.updateCompanys(companys,ids);
    }

    @Override
    public Company queryCompanyById(Integer id) {
        return companyDao.queryCompanyById(id);
    }

    @Override
    public int updatePassword(Integer id, String newPassword) {
        return companyDao.updatePassword(id,newPassword);
    }

    @Override
    public int deleteCompanyById(Integer id) {
        return companyDao.deleteCompanyById(id);
    }

    @Override
    public int deleteCompanyByIds(int[] ids) {
        return companyDao.deleteCompanyByIds(ids);
    }
}
