package com.qyzp.service;


import com.qyzp.bean.Job;

import java.util.List;

//岗位Service
public interface JobService {
    //添加岗位
    int addJob(Job job);
    //批量添加岗位
    int addJobs(Job... jobs);
    //查询所有岗位信息
    List<Job> queryAllJob();
    //修改岗位信息
    int updateJob(Job job);
    //批量修改岗位信息
    int updateJobs(Job[]  jobs,Integer... ids);
    //根据id查询岗位
    Job  queryJobById(Integer id);
    //根据公司id查询岗位
    List<Job>  queryByCompanyId(Integer companyId);
    //根据id删除岗位
    int deleteJobById(Integer id);
    //批量根据id删除岗位
    int deleteJobByIds(int[] ids);
    //根据字段名搜索Job
    List<Job> search(String key);

}
