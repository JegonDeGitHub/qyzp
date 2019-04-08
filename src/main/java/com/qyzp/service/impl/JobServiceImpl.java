package com.qyzp.service.impl;

import com.qyzp.bean.Job;
import com.qyzp.dao.JobDao;
import com.qyzp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public int addJob(Job job) {
        return jobDao.addJob(job);
    }

    @Override
    public int addJobs(Job... jobs) {
        return jobDao.addJobs(jobs);
    }

    @Override
    public List<Job> queryAllJob() {
        return jobDao.queryAllJob();
    }

    @Override
    public List<Job> queryByCompanyId(Integer companyId) {
        return jobDao.queryByCompanyId(companyId);
    }

    @Override
    public int updateJob(Job job) {
        return jobDao.updateJob(job);
    }

    @Override
    public int updateJobs(Job[] jobs, Integer... ids) {
        return jobDao.updateJobs(jobs, ids);
    }

    @Override
    public Job queryJobById(Integer id) {
        return jobDao.queryJobById(id);
    }

    @Override
    public int deleteJobById(Integer id) {
        return jobDao.deleteJobById(id);
    }

    @Override
    public int deleteJobByIds(int[] ids) {
        return jobDao.deleteJobByIds(ids);
    }

    @Override
    public List<Job> search(String key) {
        return jobDao.search(key);
    }
}
