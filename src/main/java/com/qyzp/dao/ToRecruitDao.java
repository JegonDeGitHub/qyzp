package com.qyzp.dao;

import com.qyzp.bean.ToRecruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToRecruitDao {
    //添加应聘信息
    int insert(ToRecruit toRecruit);
    //查询全部应聘信息
    List<ToRecruit> selectAll();
    //根据id查询单个应聘信息
    ToRecruit select( Integer id);
    //根据用户id查询用户所属的应聘信息
    List<ToRecruit> selectByUserId(Integer userId);
    //根据用户id和是否收到面试通知查询用户所属的应聘信息
    List<ToRecruit> selectByUserIdAndInterview(@Param("userId") Integer userId,@Param("interview") String interview);
    //根据id修改单个应聘信息
    int update(ToRecruit toRecruit);
    //根据id 删除应聘信息
    int delete(Integer id);

    //企业中心调用本模块
    //根据企业id查询简历id集合
    List<Integer> selectRIdByCId(Integer companyId);
    //根据企业id查询通过面试的应聘信息
    List<ToRecruit> selectByCompanyIdAndInterview(@Param("companyId") Integer userId,@Param("interview") String interview);
    //根据简历id修改
    int updateByResumeId(ToRecruit toRecruit);
    //根据简历id 公司id 查询到求职者用这份简历投过哪些岗位id
    List<Integer> selectJIdByRIdCId(@Param("resumeId") Integer resumeId,@Param("companyId") Integer companyId);
    //根据查回来的jobId集合和简历id查询求职者用这份简历和投过哪些应聘信息
    List<Integer> selectIdByJIdRId(@Param("jids") List<Integer> jids,@Param("resumeId") Integer resumeId);
}
