package com.qyzp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyzp.bean.Job;
import com.qyzp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/job")
public class JobController  extends  BaseApiController{
    @Autowired
    private JobService jobService;

    @PostMapping("/addJob")//添加岗位
    //id(自增不用加),jobName,jobType,company_id,company_name,company_address,recruitNumber,educationRequire,salary,detail
    public Map<String,Object> addJob(String jobName,String jobType,Integer companyId,String companyName,String companyAddress,
                                     Integer recruitNumber,String educationRequire,Integer salary,String detail) {
        Job job = new Job().setJobName(jobName).setJobType(jobType).setCompanyId(companyId).setCompanyName(companyName).setCompanyAddress(companyAddress)
                .setRecruitNumber(recruitNumber).setEducationRequire(educationRequire).setSalary(salary).setDetail(detail);
        if (jobService.addJob(job)==0) {
            return resp(405,"添加失败",job);
        }
        return resp(200,"添加成功",job);
    }

    @PostMapping("/queryJobById")//根据id查询岗位
    public  Map<String,Object> queryJobById( Integer id) {
        Job job= jobService.queryJobById(id);
        if(job==null){
            return resp(400,"岗位不存在",job);
        }
        return resp(200,"查询成功",job);
    }

    @PostMapping("/queryByCompanyId")//根据id查询岗位
    public  Map<String,Object> queryByCompanyId(@RequestParam("companyId") Integer companyId, @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage, @RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Job> jobs  = jobService.queryByCompanyId(companyId);
        PageInfo<Job> pageInfo = new PageInfo<>(jobs);
        if(jobs==null){
            return resp(400,"岗位不存在",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @GetMapping("/queryAllJob")//查询所有岗位
    public  Map<String,Object> queryAllJob(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Job> jobs = jobService.queryAllJob();
        PageInfo<Job> pageInfo = new PageInfo<>(jobs);
        if(jobs==null){
            return resp(400,"岗位不存在",jobs);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @PostMapping("/deleteJobById")//根据id删除岗位
    public Map<String,Object> deleteJobById (Integer id) {
        if (jobService.queryJobById(id)==null) {
            return resp(405,"用户不存在");
        }
        if (jobService.deleteJobById(id)==0) {
            return resp(405,"删除失败");
        }
        return resp(200," 删除成功");
    }

    @PostMapping("/updateJob")//修改岗位信息
    public Map<String,Object> updateJob(Integer id,String jobName,String jobType,Integer companyId,String companyName,String companyAddress,
                                        Integer recruitNumber,String educationRequire,Integer salary,String detail) {
        Job job = jobService.queryJobById(id);
        if (job!=null) {
            job = new Job().setId(id).setJobName(jobName).setJobType(jobType).setCompanyId(companyId).setCompanyName(companyName).setCompanyAddress(companyAddress)
                    .setRecruitNumber(recruitNumber).setEducationRequire(educationRequire).setSalary(salary).setDetail(detail);
            if (jobService.updateJob(job)==0) {
                return resp(405,"修改失败,原信息为：",jobService.queryJobById(id));
            }
        }else {
            return resp(405,"查无此岗位");
        }
        return resp(200,"修改成功,该岗位更新后信息为：",job);
    }

    @GetMapping("/search")
    public Map<String,Object> search(@RequestParam("key") String key,@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Job> jobs = jobService.search(key);
        PageInfo<Job> pageInfo = new PageInfo<>(jobs);
        if (jobs.size()==0) {
            return resp(405,"没有您想要的岗位信息");
        }
        return resp(200,"查询成功",pageInfo);
    }
}
