package com.qyzp.bean;

//id jobName jobType company_id company_name company_address recruitNumber educationRequire salary detail
public class Job {
    private Integer id;
    private String jobName;
    private String jobType;
    private Integer companyId;
    private String companyName;
    private String companyAddress;
    private Integer recruitNumber;
    private String educationRequire;
    private Integer salary;
    private String detail;

    public Integer getId() {
        return id;
    }

    public Job setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public Job setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public String getJobType() {
        return jobType;
    }

    public Job setJobType(String jobType) {
        this.jobType = jobType;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Job setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Job setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public Job setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    public Integer getRecruitNumber() {
        return recruitNumber;
    }

    public Job setRecruitNumber(Integer recruitNumber) {
        this.recruitNumber = recruitNumber;
        return this;
    }

    public String getEducationRequire() {
        return educationRequire;
    }

    public Job setEducationRequire(String educationRequire) {
        this.educationRequire = educationRequire;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Job setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Job setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
