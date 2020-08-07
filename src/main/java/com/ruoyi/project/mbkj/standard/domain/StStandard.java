package com.ruoyi.project.mbkj.standard.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 录入业绩类型信息对象 st_standard
 * 
 * @author ruoyi
 * @date 2020-08-07
 */
public class StStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String name;

    /** 状态 0禁用1启用 */
    @Excel(name = "状态 0禁用1启用")
    private String status;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** null */
    @Excel(name = "null")
    private String score;

    /** null */
    @Excel(name = "null")
    private Long sorts;

    /** 是否关联客户 0否 1是 */
    @Excel(name = "是否关联客户 0否 1是")
    private Integer linkuser;

    /** 资产类型 1 正资产 2负资产 */
    @Excel(name = "资产类型 1 正资产 2负资产")
    private Integer assettype;
    
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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setScore(String score)
    {
        this.score = score;
    }

    public String getScore()
    {
        return score;
    }
    public void setSorts(Long sorts)
    {
        this.sorts = sorts;
    }

    public Long getSorts()
    {
        return sorts;
    }
    public void setLinkuser(Integer linkuser)
    {
        this.linkuser = linkuser;
    }

    public Integer getLinkuser()
    {
        return linkuser;
    }
    public void setAssettype(Integer assettype)
    {
        this.assettype = assettype;
    }

    public Integer getAssettype()
    {
        return assettype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("createtime", getCreatetime())
            .append("status", getStatus())
            .append("unit", getUnit())
            .append("score", getScore())
            .append("sorts", getSorts())
            .append("linkuser", getLinkuser())
            .append("assettype", getAssettype())
            .toString();
    }
}
