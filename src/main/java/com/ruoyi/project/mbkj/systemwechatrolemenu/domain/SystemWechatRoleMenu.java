package com.ruoyi.project.mbkj.systemwechatrolemenu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 小程序角色权限中间对象 system_wechat_role_menu
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
public class SystemWechatRoleMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 角色id */
    @Excel(name = "角色id")
    private Long roleid;

    /** 菜单id */
    @Excel(name = "菜单id")
    private Long menuid;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRoleid(Long roleid)
    {
        this.roleid = roleid;
    }

    public Long getRoleid()
    {
        return roleid;
    }
    public void setMenuid(Long menuid)
    {
        this.menuid = menuid;
    }

    public Long getMenuid()
    {
        return menuid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roleid", getRoleid())
            .append("menuid", getMenuid())
            .toString();
    }
}
