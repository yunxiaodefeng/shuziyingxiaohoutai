package com.ruoyi.project.mbkj.store.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 网点对象 system_store
 * 
 * @author LJP
 * @date 2020-08-06
 */
public class SystemStore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 类型0省1市2县3区4网点 */
    @Excel(name = "类型0省1市2县3区4网点")
    private String type;

    /** 0正常1停业 */
    @Excel(name = "0正常1停业")
    private String status;

    /** 上级id */
    @Excel(name = "上级id")
    private Long prentid;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 县 */
    @Excel(name = "县")
    private String county;

    /** 区 */
    @Excel(name = "区")
    private String area;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** null */
    @Excel(name = "null")
    private String code;
    
    private Date createtime;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setPrentid(Long prentid)
    {
        this.prentid = prentid;
    }

    public Long getPrentid()
    {
        return prentid;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getCounty()
    {
        return county;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("status", getStatus())
            .append("createtime", getCreatetime())
            .append("prentid", getPrentid())
            .append("province", getProvince())
            .append("city", getCity())
            .append("county", getCounty())
            .append("area", getArea())
            .append("address", getAddress())
            .append("code", getCode())
            .toString();
    }
}
