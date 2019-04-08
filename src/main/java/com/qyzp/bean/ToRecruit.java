package com.qyzp.bean;

//应聘
//id,user_id,user_name,job_id,job_name,company_id,company_name,expectSalary,resume_id,resume_name,interview
public class ToRecruit {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer jobId;
    private String jobName;
    private Integer companyId;
    private String companyName;
    private Integer expectSalary;
    private Integer resumeId;
    private String resumeName;
    private String interview;

    public Integer getId() {
        return id;
    }

    public ToRecruit setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public ToRecruit setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ToRecruit setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getJobId() {
        return jobId;
    }

    public ToRecruit setJobId(Integer jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public ToRecruit setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public ToRecruit setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ToRecruit setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Integer getExpectSalary() {
        return expectSalary;
    }

    public ToRecruit setExpectSalary(Integer expectSalary) {
        this.expectSalary = expectSalary;
        return this;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public ToRecruit setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
        return this;
    }

    public String getResumeName() {
        return resumeName;
    }

    public ToRecruit setResumeName(String resumeName) {
        this.resumeName = resumeName;
        return this;
    }

    public String getInterview() {
        return interview;
    }

    public ToRecruit setInterview(String interview) {
        this.interview = interview;
        return this;
    }
}
