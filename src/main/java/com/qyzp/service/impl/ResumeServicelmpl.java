package com.qyzp.service.impl;

import com.qyzp.bean.Resume;
import com.qyzp.dao.ResumeDao;
import com.qyzp.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServicelmpl implements ResumeService {
    @Autowired
    ResumeDao resumeDao;

    @Override
    public boolean insert(Resume resume) {
        return resumeDao.insert(resume);
    }

    @Override
    public boolean delete(Integer id) {
        return resumeDao.delete(id);
    }

    @Override
    public boolean update(Resume resume) {
        return resumeDao.update(resume);
    }

    @Override
    public List<Resume> selectById(Integer id) {
        return resumeDao.selectById(id);
    }

    @Override
    public List<Resume> selectByUserId(Integer userId) {
        return resumeDao.selectByUserId(userId);
    }

    @Override
    public List<Resume> select() {
        return resumeDao.select();
    }

    @Override
    public Integer selectTotal(Integer userId) {
        return resumeDao.selectTotal(userId);
    }

    @Override
    public List<Resume> selectResumeByCompanyId(List<Integer> ids) {
        return resumeDao.selectResumeByCompanyId(ids);
    }
}
