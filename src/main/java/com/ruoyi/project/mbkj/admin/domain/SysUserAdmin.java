package com.ruoyi.project.mbkj.admin.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 员工管理对象 sys_user_admin
 * 
 * @author LJP
 * @date 2020-08-06
 */
public class SysUserAdmin extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    
    private String userId;
    private String parentId;
    
	

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** id */
    private Long id;
    
    /** 员工工号 */
    @Excel(name = "员工工号")
    private String code;

    /** 用户名称 */
    @Excel(name = "员工名称")
    private String username;
    
 /*   @Excel(name = "性别",readConverterExp = "0=未知,1=男,2=女")*/
    private String sex;
    
    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;
    
    @Excel(name = "所属网点")
    private String name;
    
    /** 岗位 */
    @Excel(name = "岗位",readConverterExp = "1=员工,3=网点负责人,4=区县负责人")
    private String jobid;
    
    /** 状态 */
    @Excel(name = "状态", readConverterExp = "0=待审核,1=正常,3=离职")
    private String status;
  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** 用户密码 */
   /* @Excel(name = "用户密码")*/
    private String password;

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
    /** 用户邮箱 */
/*    @Excel(name = "用户邮箱")*/
    private String email;

    /** 用户组 */
   /* @Excel(name = "用户组")*/
    private Long roleid;

    /** null */
 /*   @Excel(name = "null")*/
    private String exchangerate;

    /** 所属网点 */
    /*@Excel(name = "所属网点")*/
    private String storeid;

    /** 创建时间 */
    /*@Excel(name = "创建时间")*/
    private Date createtime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setRoleid(Long roleid)
    {
        this.roleid = roleid;
    }

    public Long getRoleid()
    {
        return roleid;
    }
    public void setExchangerate(String exchangerate)
    {
        this.exchangerate = exchangerate;
    }

    public String getExchangerate()
    {
        return exchangerate;
    }
    public void setStoreid(String storeid)
    {
        this.storeid = storeid;
    }

    public String getStoreid()
    {
        return storeid;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setJobid(String jobid)
    {
        this.jobid = jobid;
    }

    public String getJobid()
    {
        return jobid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("createtime", getCreatetime())
            .append("roleid", getRoleid())
            .append("exchangerate", getExchangerate())
            .append("storeid", getStoreid())
            .append("code", getCode())
            .append("status", getStatus())
            .append("jobid", getJobid())
            .append("sex", getSex())
            .append("name", getName())
            .toString();
    }

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
