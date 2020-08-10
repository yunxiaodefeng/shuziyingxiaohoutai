package com.ruoyi.project.mbkj.systemtransactionlog.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 交易记录对象 system_transaction_log
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public class SystemTransactionLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 客户id */
    @Excel(name = "客户id")
    private Long clientid;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 指标id */
    @Excel(name = "指标id")
    private Long standardid;

    /** 指标数 */
    @Excel(name = "指标数")
    private String mytarget;

    /** st_usertarget表中的主键 */
    @Excel(name = "st_usertarget表中的主键")
    private Long usertargetid;

    /** 资产类型 1 正资产 2负资产 */
    @Excel(name = "资产类型 1 正资产 2负资产")
    private Long assettype;

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
    public void setClientid(Long clientid)
    {
        this.clientid = clientid;
    }

    public Long getClientid()
    {
        return clientid;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setStandardid(Long standardid)
    {
        this.standardid = standardid;
    }

    public Long getStandardid()
    {
        return standardid;
    }
    public void setMytarget(String mytarget)
    {
        this.mytarget = mytarget;
    }

    public String getMytarget()
    {
        return mytarget;
    }
    public void setUsertargetid(Long usertargetid)
    {
        this.usertargetid = usertargetid;
    }

    public Long getUsertargetid()
    {
        return usertargetid;
    }
    public void setAssettype(Long assettype)
    {
        this.assettype = assettype;
    }

    public Long getAssettype()
    {
        return assettype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clientid", getClientid())
            .append("userid", getUserid())
            .append("standardid", getStandardid())
            .append("mytarget", getMytarget())
            .append("usertargetid", getUsertargetid())
            .append("createtime", getCreatetime())
            .append("assettype", getAssettype())
            .toString();
    }
}
