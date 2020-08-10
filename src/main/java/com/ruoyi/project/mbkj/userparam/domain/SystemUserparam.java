package com.ruoyi.project.mbkj.userparam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 用户指标系数对象 system_userparam
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
public class SystemUserparam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户 */
    @Excel(name = "用户")
    private Long userid;

    /** 系数 */
    @Excel(name = "系数")
    private String paramvalue;

    /** null */
    @Excel(name = "null")
    private String month;

    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setParamvalue(String paramvalue)
    {
        this.paramvalue = paramvalue;
    }

    public String getParamvalue()
    {
        return paramvalue;
    }
    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getMonth()
    {
        return month;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("createtime", getCreatetime())
            .append("paramvalue", getParamvalue())
            .append("month", getMonth())
            .toString();
    }
}
