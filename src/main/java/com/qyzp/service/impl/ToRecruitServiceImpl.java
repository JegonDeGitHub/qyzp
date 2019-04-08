package com.qyzp.service.impl;

import com.qyzp.bean.ToRecruit;
import com.qyzp.dao.ToRecruitDao;
import com.qyzp.service.ToRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToRecruitServiceImpl implements ToRecruitService {

    @Autowired
    private ToRecruitDao toRecruitDao;

    @Override
    public int insert(ToRecruit toRecruit) {
        return toRecruitDao.insert(toRecruit);
    }

    @Override
    public List<ToRecruit> selectAll() {
        return toRecruitDao.selectAll();
    }

    @Override
    public List<ToRecruit> selectByCompanyIdAndInterview(Integer userId,String interview) {
        return toRecruitDao.selectByCompanyIdAndInterview(userId,interview);
    }

    @Override
    public List<ToRecruit> selectByUserId(Integer userId) {
        return toRecruitDao.selectByUserId(userId);
    }

    @Override
    public List<Integer> selectRIdByCId(Integer companyId) {
        return toRecruitDao.selectRIdByCId(companyId);
    }

    @Override
    public List<ToRecruit> selectByUserIdAndInterview(Integer userId,String interview) {
        return toRecruitDao.selectByUserIdAndInterview(userId,interview);
    }

    @Override
    public ToRecruit select(Integer id) {
        return toRecruitDao.select(id);
    }

    @Override
    public int update(ToRecruit toRecruit) {
        return toRecruitDao.update(toRecruit);
    }

    @Override
    public int delete(Integer id) {
        return toRecruitDao.delete(id);
    }
}
