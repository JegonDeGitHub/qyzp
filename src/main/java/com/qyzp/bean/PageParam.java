package com.qyzp.bean;

//设定分页页面参数类(为了简化分页传参代码量)
public class PageParam {
    private Integer page_num = 1;
    private Integer page_size = 20;
    private String keyword;

    public Integer getPage_num() {
        return page_num;
    }

    public PageParam setPage_num(Integer page_num) {
        this.page_num = page_num;
        return this;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public PageParam setPage_size(Integer page_size) {
        this.page_size = page_size;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public PageParam setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }
}
