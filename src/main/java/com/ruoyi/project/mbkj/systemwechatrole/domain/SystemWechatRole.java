package com.ruoyi.project.mbkj.systemwechatrole.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 小程序角色对象 system_wechat_role
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
public class SystemWechatRole extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 是否显示 */
    @Excel(name = "是否显示")
    private Long isshow;

    private Long parentid;
    private String ztrees;
    private String valuas;

    public String getValuas() {
        return valuas;
    }

    public void setValuas(String valuas) {
        this.valuas = valuas;
    }

    public String getZtrees() {
        return ztrees;
    }

    public void setZtrees(String ztrees) {
        this.ztrees = ztrees;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
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
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setIsshow(Long isshow)
    {
        this.isshow = isshow;
    }

    public Long getIsshow()
    {
        return isshow;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("parentid", getParentid())
            .append("sort", getSort())
            .append("isshow", getIsshow())
            .toString();
    }
}
