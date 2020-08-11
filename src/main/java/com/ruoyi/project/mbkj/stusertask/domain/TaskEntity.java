package com.ruoyi.project.mbkj.stusertask.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * @program: ruoyi
 * @description:
 * @author: 云晓得峰
 * @create: 2020-08-10 23:20
 **/
public class TaskEntity extends BaseEntity {
    @Excel(name = "姓名")
    private String username;
    @Excel(name = "绩效得分")
    private String totalscore;
    @Excel(name = "系数")
    private String paramvalue;
    @Excel(name = "绩效单价")
    private String price;
    @Excel(name = "绩效工资")
    private String totalmoney;
    private String total;
    private String totlescore;
    private String id;
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }

    public String getParamvalue() {
        return paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotlescore() {
        return totlescore;
    }

    public void setTotlescore(String totlescore) {
        this.totlescore = totlescore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
