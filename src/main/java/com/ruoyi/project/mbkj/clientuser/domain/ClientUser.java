package com.ruoyi.project.mbkj.clientuser.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户信息对象 client_user
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public class ClientUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "等级")
    private String gradename;
    @Excel(name = "性别",readConverterExp = "0=男,1=女,2=未知")
    private String sex;
    @Excel(name = "手机号")
    private String phone;

    //标签
    @Excel(name = "标签")
    private String lablelist;

    //员工姓名
    @Excel(name = "员工姓名")
    private  String username;

    /** null */
    private Long id;

    /** 昵称 */
    private String nickname;

    /** 头像 */
    private String headurl;

    /** 销售id */
    private Long userid;

    /** 手机号 */


    /** 男女 */


    /** 沟通次数 */
    private Long ucount;

    /** 身份证 */
    private String idcard;

    /** 公司名称 */
    private String companyname;

    /** 上次沟通时间 */
    private Date lastupdatetime;

    /** 下次沟通时间 */
    private Date nextdatetime;

    private Date createtime;

    /** null */
    private String firstchar;

    /** 来源 */
    private String source;

    /** null */
    private String openid;

    /** 所属网点 */
    private Long storeid;

    /** 地址 */
    private String address;

    /** 职位 */
    private String job;

    /** 婚姻状态 */
    private String marriage;

    /** 备注 */
    private String makers;

    /** 等级 */
    private String grade;

    /** 营销阶段 */
    private String step;

    /** 生日 */
    private String borthday;

    /** 废弃 */
    private String borthdaytype;

    /** 废弃 */
    private String usertype;

    //等级





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLablelist() {
        return lablelist;
    }

    public void setLablelist(String lablelist) {
        this.lablelist = lablelist;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
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
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setHeadurl(String headurl)
    {
        this.headurl = headurl;
    }

    public String getHeadurl()
    {
        return headurl;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setUcount(Long ucount)
    {
        this.ucount = ucount;
    }

    public Long getUcount()
    {
        return ucount;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getIdcard()
    {
        return idcard;
    }
    public void setCompanyname(String companyname)
    {
        this.companyname = companyname;
    }

    public String getCompanyname()
    {
        return companyname;
    }
    public void setLastupdatetime(Date lastupdatetime)
    {
        this.lastupdatetime = lastupdatetime;
    }

    public Date getLastupdatetime()
    {
        return lastupdatetime;
    }
    public void setNextdatetime(Date nextdatetime)
    {
        this.nextdatetime = nextdatetime;
    }

    public Date getNextdatetime()
    {
        return nextdatetime;
    }
    public void setFirstchar(String firstchar)
    {
        this.firstchar = firstchar;
    }

    public String getFirstchar()
    {
        return firstchar;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getOpenid()
    {
        return openid;
    }
    public void setStoreid(Long storeid)
    {
        this.storeid = storeid;
    }

    public Long getStoreid()
    {
        return storeid;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setJob(String job)
    {
        this.job = job;
    }

    public String getJob()
    {
        return job;
    }
    public void setMarriage(String marriage)
    {
        this.marriage = marriage;
    }

    public String getMarriage()
    {
        return marriage;
    }
    public void setMakers(String makers)
    {
        this.makers = makers;
    }

    public String getMakers()
    {
        return makers;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setStep(String step)
    {
        this.step = step;
    }

    public String getStep()
    {
        return step;
    }
    public void setBorthday(String borthday)
    {
        this.borthday = borthday;
    }

    public String getBorthday()
    {
        return borthday;
    }
    public void setBorthdaytype(String borthdaytype)
    {
        this.borthdaytype = borthdaytype;
    }

    public String getBorthdaytype()
    {
        return borthdaytype;
    }
    public void setUsertype(String usertype)
    {
        this.usertype = usertype;
    }

    public String getUsertype()
    {
        return usertype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickname", getNickname())
            .append("headurl", getHeadurl())
            .append("createtime", getCreatetime())
            .append("userid", getUserid())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("ucount", getUcount())
            .append("name", getName())
            .append("idcard", getIdcard())
            .append("companyname", getCompanyname())
            .append("lastupdatetime", getLastupdatetime())
            .append("nextdatetime", getNextdatetime())
            .append("firstchar", getFirstchar())
            .append("source", getSource())
            .append("openid", getOpenid())
            .append("storeid", getStoreid())
            .append("address", getAddress())
            .append("job", getJob())
            .append("marriage", getMarriage())
            .append("makers", getMakers())
            .append("grade", getGrade())
            .append("step", getStep())
            .append("borthday", getBorthday())
            .append("borthdaytype", getBorthdaytype())
            .append("usertype", getUsertype())
            .toString();
    }
}
