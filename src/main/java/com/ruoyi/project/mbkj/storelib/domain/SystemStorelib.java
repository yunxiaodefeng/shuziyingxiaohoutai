package com.ruoyi.project.mbkj.storelib.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 网点指标详情对象 system_storelib
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public class SystemStorelib extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 公库 */
    @Excel(name = "公库")
    private String libid;

    /** 是否必须0否1是 */
    @Excel(name = "是否必须0否1是")
    private String ismust;

    /** 0否1是 */
    @Excel(name = "0否1是")
    private String ispublicmust;

    /** null */
    @Excel(name = "null")
    private Long storeid;

    /** null */
    @Excel(name = "null")
    private String sorts;

    /** null */
    @Excel(name = "null")
    private String status;

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
    public void setLibid(String libid)
    {
        this.libid = libid;
    }

    public String getLibid()
    {
        return libid;
    }
    public void setIsmust(String ismust)
    {
        this.ismust = ismust;
    }

    public String getIsmust()
    {
        return ismust;
    }
    public void setIspublicmust(String ispublicmust)
    {
        this.ispublicmust = ispublicmust;
    }

    public String getIspublicmust()
    {
        return ispublicmust;
    }
    public void setStoreid(Long storeid)
    {
        this.storeid = storeid;
    }

    public Long getStoreid()
    {
        return storeid;
    }
    public void setSorts(String sorts)
    {
        this.sorts = sorts;
    }

    public String getSorts()
    {
        return sorts;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("libid", getLibid())
            .append("ismust", getIsmust())
            .append("ispublicmust", getIspublicmust())
            .append("createtime", getCreatetime())
            .append("storeid", getStoreid())
            .append("sorts", getSorts())
            .append("status", getStatus())
            .toString();
    }
}
