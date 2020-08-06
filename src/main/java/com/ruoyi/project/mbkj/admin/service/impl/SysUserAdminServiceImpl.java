package com.ruoyi.project.mbkj.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.admin.mapper.SysUserAdminMapper;
import com.ruoyi.project.mbkj.admin.domain.SysUserAdmin;
import com.ruoyi.project.mbkj.admin.service.ISysUserAdminService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 员工管理Service业务层处理
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Service
public class SysUserAdminServiceImpl implements ISysUserAdminService 
{
    @Autowired
    private SysUserAdminMapper sysUserAdminMapper;

    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    @Override
    public SysUserAdmin selectSysUserAdminById(Long id)
    {
        return sysUserAdminMapper.selectSysUserAdminById(id);
    }

    /**
     * 查询员工管理列表
     * 
     * @param sysUserAdmin 员工管理
     * @return 员工管理
     */
    @Override
    public List<SysUserAdmin> selectSysUserAdminList(SysUserAdmin sysUserAdmin)
    {
        return sysUserAdminMapper.selectSysUserAdminList(sysUserAdmin);
    }

    /**
     * 新增员工管理
     * 
     * @param sysUserAdmin 员工管理
     * @return 结果
     */
    @Override
    public int insertSysUserAdmin(SysUserAdmin sysUserAdmin)
    {
        return sysUserAdminMapper.insertSysUserAdmin(sysUserAdmin);
    }

    /**
     * 修改员工管理
     * 
     * @param sysUserAdmin 员工管理
     * @return 结果
     */
    @Override
    public int updateSysUserAdmin(SysUserAdmin sysUserAdmin)
    {
        return sysUserAdminMapper.updateSysUserAdmin(sysUserAdmin);
    }

    /**
     * 删除员工管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserAdminByIds(String ids)
    {
        return sysUserAdminMapper.deleteSysUserAdminByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    @Override
    public int deleteSysUserAdminById(Long id)
    {
        return sysUserAdminMapper.deleteSysUserAdminById(id);
    }
}
