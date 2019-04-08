package com.qyzp.dao;

import com.qyzp.bean.Resume;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ResumeDao {
    boolean insert(Resume resume);
    boolean delete(Integer id);
    boolean update(Resume resume);
    List<Resume> selectById(Integer id);
    List<Resume> selectByUserId(Integer userId);
    List<Resume> select();
    Integer selectTotal(Integer userId);

    //企业中心
    //根据传进来的简历id集合搜索
    List<Resume> selectResumeByCompanyId(List<Integer> ids);
}
