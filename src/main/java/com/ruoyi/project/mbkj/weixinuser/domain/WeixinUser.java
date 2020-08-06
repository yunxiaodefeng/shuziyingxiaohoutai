package com.ruoyi.project.mbkj.weixinuser.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 微信用户对象 weixin_user
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public class WeixinUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 是否关注 */
    @Excel(name = "是否关注")
    private String subscribe;

    /** openid */
    @Excel(name = "openid")
    private String openid;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 语言 */
    @Excel(name = "语言")
    private String language;

    /** 用户关注时间 */
    @Excel(name = "用户关注时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subscribeTime;

    /** unionid */
    @Excel(name = "unionid")
    private String unionid;

    /** 分组 */
    @Excel(name = "分组")
    private String groupid;

    /** 用户id */
    @Excel(name = "用户id")
    private String userid;

    /** 头像 */
    @Excel(name = "头像")
    private String headimgurl;

    /** 绑定手机号 */
    @Excel(name = "绑定手机号")
    private String phone;

    /** 状态 */
    @Excel(name = "状态")
    private String type;

    /** 备注  0系统人  1客户 */
    @Excel(name = "备注  0系统人  1客户")
    private String usertype;

    /** null */
    @Excel(name = "null")
    private String token;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSubscribe(String subscribe)
    {
        this.subscribe = subscribe;
    }

    public String getSubscribe()
    {
        return subscribe;
    }
    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getOpenid()
    {
        return openid;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getLanguage()
    {
        return language;
    }
    public void setSubscribeTime(Date subscribeTime)
    {
        this.subscribeTime = subscribeTime;
    }

    public Date getSubscribeTime()
    {
        return subscribeTime;
    }
    public void setUnionid(String unionid)
    {
        this.unionid = unionid;
    }

    public String getUnionid()
    {
        return unionid;
    }
    public void setGroupid(String groupid)
    {
        this.groupid = groupid;
    }

    public String getGroupid()
    {
        return groupid;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUserid()
    {
        return userid;
    }
    public void setHeadimgurl(String headimgurl)
    {
        this.headimgurl = headimgurl;
    }

    public String getHeadimgurl()
    {
        return headimgurl;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setUsertype(String usertype)
    {
        this.usertype = usertype;
    }

    public String getUsertype()
    {
        return usertype;
    }
    public void setToken(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("subscribe", getSubscribe())
            .append("openid", getOpenid())
            .append("nickname", getNickname())
            .append("sex", getSex())
            .append("city", getCity())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("language", getLanguage())
            .append("subscribeTime", getSubscribeTime())
            .append("unionid", getUnionid())
            .append("remark", getRemark())
            .append("groupid", getGroupid())
            .append("userid", getUserid())
            .append("headimgurl", getHeadimgurl())
            .append("phone", getPhone())
            .append("type", getType())
            .append("usertype", getUsertype())
            .append("token", getToken())
            .toString();
    }
}
