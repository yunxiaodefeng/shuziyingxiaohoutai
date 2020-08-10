package com.ruoyi.project.mbkj.systemLib.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 客户标签信息基础对象 system_lib
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public class SystemLib extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 商家所属 */
    @Excel(name = "商家所属")
    private Long storeid;

    /** 标题 */
    @Excel(name = "标题")
    private String name;

    /** 输入类型:0-文本框;1-下拉框;2-单选;3-多选 */
    @Excel(name = "输入类型:0-文本框;1-下拉框;2-单选;3-多选")
    private String type;

    /** 是否必选:0-非必须;1-必须 */
    @Excel(name = "是否必选:0-非必须;1-必须")
    private String must;

    /** 状态:0-启用;1-禁用 */
    @Excel(name = "状态:0-启用;1-禁用")
    private String status;

    /** 类型 */
    @Excel(name = "类型")
    private String libtype;

    /** null */
    @Excel(name = "null")
    private String sorts;

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
    public void setStoreid(Long storeid)
    {
        this.storeid = storeid;
    }

    public Long getStoreid()
    {
        return storeid;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setMust(String must)
    {
        this.must = must;
    }

    public String getMust()
    {
        return must;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setLibtype(String libtype)
    {
        this.libtype = libtype;
    }

    public String getLibtype()
    {
        return libtype;
    }
    public void setSorts(String sorts)
    {
        this.sorts = sorts;
    }

    public String getSorts()
    {
        return sorts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storeid", getStoreid())
            .append("name", getName())
            .append("type", getType())
            .append("must", getMust())
            .append("createtime", getCreatetime())
            .append("status", getStatus())
            .append("libtype", getLibtype())
            .append("sorts", getSorts())
            .toString();
    }
}
