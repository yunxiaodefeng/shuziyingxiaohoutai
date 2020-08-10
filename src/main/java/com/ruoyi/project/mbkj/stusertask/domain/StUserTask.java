package com.ruoyi.project.mbkj.stusertask.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 存储设置的用户绩效对象 st_user_task
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
public class StUserTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 网点 */
    @Excel(name = "网点")
    private Long storeid;

    /** 员工id */
    @Excel(name = "员工id")
    private Long userid;

    /** 指标 */
    @Excel(name = "指标")
    private String score;

    /** 月份 */
    @Excel(name = "月份")
    private String month;

    /** 指标 */
    @Excel(name = "指标")
    private Long stid;

    /** 0权重 1目标 2积分 */
    @Excel(name = "0权重 1目标 2积分")
    private String type;

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
    public void setStoreid(Long storeid)
    {
        this.storeid = storeid;
    }

    public Long getStoreid()
    {
        return storeid;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setScore(String score)
    {
        this.score = score;
    }

    public String getScore()
    {
        return score;
    }
    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getMonth()
    {
        return month;
    }
    public void setStid(Long stid)
    {
        this.stid = stid;
    }

    public Long getStid()
    {
        return stid;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storeid", getStoreid())
            .append("userid", getUserid())
            .append("score", getScore())
            .append("month", getMonth())
            .append("createtime", getCreatetime())
            .append("stid", getStid())
            .append("type", getType())
            .toString();
    }
}
