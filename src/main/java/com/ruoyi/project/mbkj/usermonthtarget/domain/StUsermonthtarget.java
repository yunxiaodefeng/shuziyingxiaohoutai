package com.ruoyi.project.mbkj.usermonthtarget.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 数据统计对象 st_usermonthtarget
 * 
 * @author LJP
 * @date 2020-08-06
 */
public class StUsermonthtarget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 指标 */
    @Excel(name = "指标")
    private String target;

    /** 已完成目标 */
    @Excel(name = "已完成目标")
    private String mytarget;

    /** 备注 */
    @Excel(name = "备注")
    private String markes;

    /** 网点指标 */
    @Excel(name = "网点指标")
    private Long storestid;
    
    private Date createtime;
    

    private String time;
    private String timeT;

    public String getTimeT() {
        return timeT;
    }

    public void setTimeT(String timeT) {
        this.timeT = timeT;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getTarget()
    {
        return target;
    }
    public void setMytarget(String mytarget)
    {
        this.mytarget = mytarget;
    }

    public String getMytarget()
    {
        return mytarget;
    }
    public void setMarkes(String markes)
    {
        this.markes = markes;
    }

    public String getMarkes()
    {
        return markes;
    }
    public void setStorestid(Long storestid)
    {
        this.storestid = storestid;
    }

    public Long getStorestid()
    {
        return storestid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("target", getTarget())
            .append("mytarget", getMytarget())
            .append("createtime", getCreatetime())
            .append("markes", getMarkes())
            .append("storestid", getStorestid())
            .toString();
    }
}
