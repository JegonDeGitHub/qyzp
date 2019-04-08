package com.qyzp.bean;

import java.util.List;

public class CompanyAndJob {
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public CompanyAndJob setJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }
}
