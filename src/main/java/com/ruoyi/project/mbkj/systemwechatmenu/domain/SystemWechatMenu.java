package com.ruoyi.project.mbkj.systemwechatmenu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 小程序按钮权限对象 system_wechat_menu
 * 
 * @author 云晓得峰
 * @date 2020-08-13
 */
public class SystemWechatMenu extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图标 */
    @Excel(name = "图标")
    private String icon;

    /** 按钮名称 */
    @Excel(name = "按钮名称")
    private String btnname;

    /** 购买时间 */
    @Excel(name = "购买时间")
    private String paytime;

    /** 到期时间 */
    @Excel(name = "到期时间")
    private String endtime;

    /** 是否购买 0 是1否 */
    @Excel(name = "是否购买 0 是1否")
    private Integer ispay;

    /** 是否显示0 是1否 */
    @Excel(name = "是否显示0 是1否")
    private Integer isshow;

    /** 是否开发完成0 是1否 */
    @Excel(name = "是否开发完成0 是1否")
    private Integer iscreate;

    /** 排序 */
    @Excel(name = "排序")
    private Long sortid;

    /** 路由 */
    @Excel(name = "路由")
    private String pathurl;

    private Long parentid;
    //权限类型
    private  Long roletype;

    private Long[] ztrees;

    private String remark;

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long[] getZtrees() {
        return ztrees;
    }

    public void setZtrees(Long[] ztrees) {
        this.ztrees = ztrees;
    }

    public Long getRoletype() {
        return roletype;
    }

    public void setRoletype(Long roletype) {
        this.roletype = roletype;
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
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getIcon()
    {
        return icon;
    }
    public void setBtnname(String btnname)
    {
        this.btnname = btnname;
    }

    public String getBtnname()
    {
        return btnname;
    }
    public void setPaytime(String paytime)
    {
        this.paytime = paytime;
    }

    public String getPaytime()
    {
        return paytime;
    }
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public String getEndtime()
    {
        return endtime;
    }
    public void setIspay(Integer ispay)
    {
        this.ispay = ispay;
    }

    public Integer getIspay()
    {
        return ispay;
    }
    public void setIsshow(Integer isshow)
    {
        this.isshow = isshow;
    }

    public Integer getIsshow()
    {
        return isshow;
    }
    public void setIscreate(Integer iscreate)
    {
        this.iscreate = iscreate;
    }

    public Integer getIscreate()
    {
        return iscreate;
    }
    public void setSortid(Long sortid)
    {
        this.sortid = sortid;
    }

    public Long getSortid()
    {
        return sortid;
    }
    public void setPathurl(String pathurl)
    {
        this.pathurl = pathurl;
    }

    public String getPathurl()
    {
        return pathurl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("icon", getIcon())
            .append("btnname", getBtnname())
            .append("paytime", getPaytime())
            .append("endtime", getEndtime())
            .append("parentid", getParentid())
            .append("ispay", getIspay())
            .append("isshow", getIsshow())
            .append("iscreate", getIscreate())
            .append("sortid", getSortid())
            .append("pathurl", getPathurl())
            .toString();
    }
}
