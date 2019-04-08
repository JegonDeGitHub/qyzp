package com.qyzp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyzp.bean.ToRecruit;
import com.qyzp.service.ToRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/torecruit")
public class ToRecruitController extends BaseApiController {
    @Autowired
    private ToRecruitService toRecruitService;

    @PostMapping("/insert")
    //id,user_id,user_name,job_id,job_name,company_id,company_name,expectSalary,resume_id,resume_name,interview
    public Map<String,Object> insert(Integer userId,String userName,Integer jobId,String jobName,Integer companyId,String companyName,
                                     Integer expectSalary,Integer resumeId,String resumeName,String interview) {
        ToRecruit toRecruit = new ToRecruit().setUserId(userId).setUserName(userName).setJobId(jobId).setJobName(jobName).setCompanyId(companyId)
                .setCompanyName(companyName).setResumeId(resumeId).setResumeName(resumeName).setExpectSalary(expectSalary).setInterview(interview);
        if (toRecruitService.insert(toRecruit)==0) {
            return resp(405,"添加失败");
        }
        return resp(200,"添加成功",toRecruit);
    }

    @GetMapping("/select")
    public Map<String,Object> select (Integer id) {
        ToRecruit toRecruit = toRecruitService.select(id);
        if (toRecruit==null) {
            return  resp(405,"应聘信息不存在",toRecruit);
        }
        return resp(200,"查询成功",toRecruit);
    }

    @GetMapping("/selectAll")
    public Map<String,Object> selectAll (@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ToRecruit> toRecruits = toRecruitService.selectAll();
        PageInfo<ToRecruit> pageInfo = new PageInfo<>(toRecruits);
        if (toRecruits==null) {
            return  resp(405,"没有数据",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @GetMapping("/selectByUserId")
    public Map<String,Object> selectByUserId (@RequestParam("userId") Integer userId,@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ToRecruit> toRecruits = toRecruitService.selectByUserId(userId);
        PageInfo<ToRecruit> pageInfo = new PageInfo<>(toRecruits);
        if (toRecruits==null) {
            return  resp(405,"没有数据",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @GetMapping("/selectByUserIdAndInterview")//根据用户id查询并且具有面试资格
    public Map<String,Object> selectByUserIdAndInterview (Integer userId,String interview,
                                                          @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ToRecruit> toRecruits = toRecruitService.selectByUserIdAndInterview(userId,interview);
        PageInfo<ToRecruit> pageInfo = new PageInfo<>(toRecruits);
        if (toRecruits==null) {
            return  resp(405,"没有数据",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @PostMapping("/delete")
    public Map<String,Object> delete (Integer id) {
        if (toRecruitService.select(id)==null) {
            return resp(405,"用户不存在");
        }
        if (toRecruitService.delete(id)==0) {
            return resp(406,"删除失败");
        }
        return resp(200,"删除成功");
    }

    @PostMapping("/update")
    public Map<String,Object> update(Integer id,Integer userId,String userName,Integer jobId,String jobName,Integer companyId,String companyName,
                                     Integer expectSalary,Integer resumeId,String resumeName,String interview) {
        ToRecruit toRecruit = toRecruitService.select(id);
        if (toRecruit!=null) {
            toRecruit = new ToRecruit().setId(id).setUserId(userId).setUserName(userName).setJobId(jobId).setJobName(jobName).setCompanyId(companyId)
                    .setCompanyName(companyName).setResumeId(resumeId).setResumeName(resumeName).setExpectSalary(expectSalary).setInterview(interview);
            if (toRecruitService.update(toRecruit)==0) {
                return resp(405,"修改失败");
            }
        }else {
            return resp(405,"数据不存在");
        }
        return resp(200,"修改成功",toRecruit);
    }

    //企业中心调用本模块
    //根据企业id查询简历id集合
    @GetMapping("/selectRIdByCId")
    public Map<String,Object> selectRIdByCId (Integer companyId,@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Integer> resumeIds = toRecruitService.selectRIdByCId(companyId);
        PageInfo<Integer> pageInfo = new PageInfo<>(resumeIds);
        if (resumeIds==null) {
            return  resp(405,"没有数据",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

    @GetMapping("/selectByCompanyIdAndInterview")//根据企业id查询并且具有面试资格
    public Map<String,Object> selectByCompanyIdAndInterview (@RequestParam("companyId") Integer companyId,@RequestParam("interview") String interview,
                                                             @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ToRecruit> toRecruits = toRecruitService.selectByCompanyIdAndInterview(companyId,interview);
        PageInfo<ToRecruit> pageInfo = new PageInfo<>(toRecruits);
        if (toRecruits==null) {
            return  resp(405,"没有数据",pageInfo);
        }
        return resp(200,"查询成功",pageInfo);
    }

}
