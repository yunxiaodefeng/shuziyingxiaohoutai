package com.ruoyi.project.mbkj.clientuser.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * @program: ruoyi
 * @description:
 * @author: 云晓得峰
 * @create: 2020-08-07 09:55
 **/
public class UserDetail extends BaseEntity {

    private String name;
    private String phone;
    private String address;
    private String companyname;
    private String job;
    private String borthday;
    private String sex;
    private String marriage;
    private String gradename;
    private String makers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBorthday() {
        return borthday;
    }

    public void setBorthday(String borthday) {
        this.borthday = borthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getMakers() {
        return makers;
    }

    public void setMakers(String makers) {
        this.makers = makers;
    }
}
