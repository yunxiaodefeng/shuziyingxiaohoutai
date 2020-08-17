package com.ruoyi.project.mbkj.systemwechatrolemenu.service;

import java.util.List;
import com.ruoyi.project.mbkj.systemwechatrolemenu.domain.SystemWechatRoleMenu;

/**
 * 小程序角色权限中间Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
public interface ISystemWechatRoleMenuService 
{
    /**
     * 查询小程序角色权限中间
     * 
     * @param id 小程序角色权限中间ID
     * @return 小程序角色权限中间
     */
    public SystemWechatRoleMenu selectSystemWechatRoleMenuById(Long id);

    /**
     * 查询小程序角色权限中间列表
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 小程序角色权限中间集合
     */
    public List<SystemWechatRoleMenu> selectSystemWechatRoleMenuList(SystemWechatRoleMenu systemWechatRoleMenu);

    /**
     * 新增小程序角色权限中间
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 结果
     */
    public int insertSystemWechatRoleMenu(SystemWechatRoleMenu systemWechatRoleMenu);

    /**
     * 修改小程序角色权限中间
     * 
     * @param systemWechatRoleMenu 小程序角色权限中间
     * @return 结果
     */
    public int updateSystemWechatRoleMenu(SystemWechatRoleMenu systemWechatRoleMenu);

    /**
     * 批量删除小程序角色权限中间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemWechatRoleMenuByIds(String ids);

    /**
     * 删除小程序角色权限中间信息
     * 
     * @param id 小程序角色权限中间ID
     * @return 结果
     */
    public int deleteSystemWechatRoleMenuById(Long id);
}
