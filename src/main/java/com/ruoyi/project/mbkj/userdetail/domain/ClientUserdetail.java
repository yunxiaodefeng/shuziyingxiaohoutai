package com.ruoyi.project.mbkj.userdetail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 客户标签信息详情中间表对象 client_userdetail
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public class ClientUserdetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 属性 */
    @Excel(name = "属性")
    private Long libid;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 销售人 */
    @Excel(name = "销售人")
    private Long userid;

    /** 客户id */
    @Excel(name = "客户id")
    private Long clientid;

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
    public void setLibid(Long libid)
    {
        this.libid = libid;
    }

    public Long getLibid()
    {
        return libid;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setClientid(Long clientid)
    {
        this.clientid = clientid;
    }

    public Long getClientid()
    {
        return clientid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("libid", getLibid())
            .append("content", getContent())
            .append("createtime", getCreatetime())
            .append("userid", getUserid())
            .append("clientid", getClientid())
            .toString();
    }
}
