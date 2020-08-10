package com.ruoyi.project.mbkj.systemlibdetail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 客户标签信息详情对象 system_libdetail
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public class SystemLibdetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 选项 */
    @Excel(name = "选项")
    private Long libid;

    private String identification;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** null */
    @Excel(name = "null")
    private String sorts;
    private Date createtime;
    private boolean  checked;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
    public void setLibid(Long libid)
    {
        this.libid = libid;
    }

    public Long getLibid()
    {
        return libid;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
            .append("libid", getLibid())
            .append("title", getTitle())
            .append("createtime", getCreatetime())
            .append("identification", getIdentification())
            .append("status", getStatus())
            .append("sorts", getSorts())
            .toString();
    }
}
