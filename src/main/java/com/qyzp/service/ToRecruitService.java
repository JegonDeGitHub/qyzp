package com.qyzp.service;

import com.qyzp.bean.ToRecruit;

import java.util.List;

public interface ToRecruitService {
    //添加应聘信息
    int insert(ToRecruit toRecruit);
    //查询全部应聘信息
    List<ToRecruit> selectAll();
    //根据用户id查询用户所属的应聘信息
    List<ToRecruit> selectByUserId(Integer userId);
    //根据用户id和是否收到面试通知查询用户所属的应聘信息
    List<ToRecruit> selectByUserIdAndInterview(Integer userId,String interview);
    //根据id查询单个应聘信息
    ToRecruit select(Integer id);
    //根据id修改单个应聘信息
    int update(ToRecruit toRecruit);
    //根据id 删除应聘信息
    int delete(Integer id);

    //企业中心调用本模块
    //根据企业id查询简历id集合
    List<Integer> selectRIdByCId(Integer companyId);
    //根据企业id查询通过面试的应聘信息
    List<ToRecruit> selectByCompanyIdAndInterview(Integer userId,String interview);

}
