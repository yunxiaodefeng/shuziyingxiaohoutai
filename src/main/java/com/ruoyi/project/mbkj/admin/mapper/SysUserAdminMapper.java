package com.ruoyi.project.mbkj.admin.mapper;

import com.ruoyi.project.mbkj.admin.domain.SysUserAdmin;
import com.ruoyi.project.mbkj.admin.domain.SysUserAdminBonus;

import java.util.List;
import java.util.Map;

/**
 * 员工管理Mapper接口
 * 
 * @author LJP
 * @date 2020-08-06
 */
public interface SysUserAdminMapper 
{
    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    public SysUserAdmin selectSysUserAdminById(Long id);

    /**
     * 查询员工管理列表
     * 
     * @param sysUserAdmin 员工管理
     * @return 员工管理集合
     */
    public List<SysUserAdmin> selectSysUserAdminList(SysUserAdmin sysUserAdmin);

    /**
     * 新增员工管理
     * 
     * @param sysUserAdmin 员工管理
     * @return 结果
     */
    public int insertSysUserAdmin(SysUserAdmin sysUserAdmin);

    /**
     * 修改员工管理
     * 
     * @param sysUserAdmin 员工管理
     * @return 结果
     */
    public int updateSysUserAdmin(SysUserAdmin sysUserAdmin);

    /**
     * 删除员工管理
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    public int deleteSysUserAdminById(Long id);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserAdminByIds(String[] ids);

    List<SysUserAdminBonus> selectUserList(Map<String, Object> userAdmin);
}
