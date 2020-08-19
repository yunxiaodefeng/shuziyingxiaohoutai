package com.ruoyi.project.mbkj.systemwechatrolemenu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.systemwechatrolemenu.mapper.SystemWechatRoleMenuMapper;
import com.ruoyi.project.mbkj.systemwechatrolemenu.domain.SystemWechatRoleMenu;
import com.ruoyi.project.mbkj.systemwechatrolemenu.service.ISystemWechatRoleMenuService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 小程序角色权限中间Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
@Service
public class SystemWechatRoleMenuServiceImpl implements ISystemWechatRoleMenuService 
{
    @Autowired
    private SystemWechatRoleMenuMapper systemWechatRoleMenuMapper;

    /**
     * 查询小程序角色权限中间
     * 
     * @param id 小程序角色权限中间ID
     * @return 小程序角色权限中间
     */
    @Override
    public SystemWechatRoleMenu selectSystemWechatRoleMenuById(Long id)
    {
        return systemWechatRoleMenuMapper.selectSystemWechatRoleMenuById(id);
    }

    /**
     * 查询小程序角色权限中间列表
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 小程序角色权限中间
     */
    @Override
    public List<SystemWechatRoleMenu> selectSystemWechatRoleMenuList(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        return systemWechatRoleMenuMapper.selectSystemWechatRoleMenuList(systemWechatRoleMenu);
    }

    /**
     * 新增小程序角色权限中间
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 结果
     */
    @Override
    public int insertSystemWechatRoleMenu(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        return systemWechatRoleMenuMapper.insertSystemWechatRoleMenu(systemWechatRoleMenu);
    }

    /**
     * 修改小程序角色权限中间
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 结果
     */
    @Override
    public int updateSystemWechatRoleMenu(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        return systemWechatRoleMenuMapper.updateSystemWechatRoleMenu(systemWechatRoleMenu);
    }

    /**
     * 删除小程序角色权限中间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatRoleMenuByIds(String ids)
    {
        return systemWechatRoleMenuMapper.deleteSystemWechatRoleMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小程序角色权限中间信息
     * 
     * @param id 小程序角色权限中间ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatRoleMenuById(Long id)
    {
        return systemWechatRoleMenuMapper.deleteSystemWechatRoleMenuById(id);
    }
}
