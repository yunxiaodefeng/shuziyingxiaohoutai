package com.ruoyi.project.mbkj.systemDic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 客户标签信息基础表对象 system_dic
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public class SystemDic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 值 */
    @Excel(name = "值")
    private String key;

    /** 标签 */
    @Excel(name = "标签")
    private String value;

    /** 描述 */
    @Excel(name = "描述")
    private String des;

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
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
    public void setDes(String des)
    {
        this.des = des;
    }

    public String getDes()
    {
        return des;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("key", getKey())
            .append("value", getValue())
            .append("createtime", getCreatetime())
            .append("des", getDes())
            .toString();
    }
}
