package com.qyzp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyzp.bean.Company;
import com.qyzp.bean.Resume;
import com.qyzp.service.ResumeService;
import com.qyzp.service.ToRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resume")
public class ResumeController extends BaseApiController{
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ToRecruitService toRecruitService;

    @PostMapping("/insert")
    public Map<String,Object> insert(Resume resume){
        if(resumeService.insert(resume)){
            return resp(200,"增加成功！",resume);
        }else{
            return resp(500,"增加失败！",null);
        }
    }

    @DeleteMapping("/delete")
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        if(resumeService.delete(id)){
            return resp(200,"删除成功！",null);
        }else{
            return resp(500,"删除失败！",null);
        }
    }

    @PutMapping("/update")
    public Map<String,Object> update(Resume resume){
        if(resumeService.update(resume)){
            return resp(200,"修改成功！",null);
        }else{
            return resp(500,"修改失败！",null);
        }
    }

    @GetMapping("/selectById")
    public Map<String,Object> selectById(@RequestParam("id") Integer id){
        List<Resume> resume = new ArrayList<>();
        resume = resumeService.selectById(id);
        if(null != resume){
            return resp(200,"查询成功！",resume);
        }else{
            return resp(500,"查询失败！",null);
        }
    }

    @GetMapping("/selectByUserId")
    public Map<String,Object> selectByUserId(@RequestParam("userId") Integer userId,@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize){
        List<Resume> resumes = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        resumes = resumeService.selectByUserId(userId);
        PageInfo<Resume> pageInfo = new PageInfo<>(resumes);
        if(0 != resumes.size()){
            return resp(200,"查询成功！",pageInfo);
        }else{
            return resp(500,"查询失败！",null);
        }
    }

    @GetMapping("/selectResumeByCompanyId")
    public Map<String,Object> selectUserToCompany(@RequestParam("companyId") Integer companyId,@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize){
        List<Integer> resumeIds = toRecruitService.selectRIdByCId(companyId);//先根据companyId查询出简历id的集合先
        PageHelper.startPage(currentPage, pageSize);
        List<Resume> resumes = resumeService.selectResumeByCompanyId(resumeIds);
        PageInfo<Resume> pageInfo = new PageInfo<>(resumes);
        if(null != resumes){
            return resp(200,"查询成功！",pageInfo);
        }else{
            return resp(500,"查询失败！",null);
        }
    }

    @GetMapping("/select")
    public Map<String,Object> select(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage,@RequestParam(value="pageSize",defaultValue="10",required = false)  Integer pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Resume> resumes = resumeService.select();
        PageInfo<Resume> pageInfo = new PageInfo<>(resumes);
        if(null!= resumes){
            return resp(200,"查询成功！",pageInfo);
        }else{
            return resp(500,"查询失败！",null);
        }
    }

    @GetMapping("/selectTotal")
    public Map<String,Object> selectTotal(Integer userId){
        Integer total = null;
        total = resumeService.selectTotal(userId);
        if(0 != total){
            return resp(200,"查询成功！",total);
        }else{
            return resp(500,"查询失败！",null);
        }
    }
}
