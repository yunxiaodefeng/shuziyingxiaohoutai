package com.ruoyi.project.mbkj.systemwechatmenu.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.SystemWechatMenu;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.TreeNode;
import com.ruoyi.project.system.role.domain.Role;

import java.util.List;

/**
 * 小程序按钮权限Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-13
 */
public interface ISystemWechatMenuService 
{
    /**
     * 查询小程序按钮权限
     * 
     * @param id 小程序按钮权限ID
     * @return 小程序按钮权限
     */
    public SystemWechatMenu selectSystemWechatMenuById(Long id);

    /**
     * 查询小程序按钮权限列表
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 小程序按钮权限集合
     */
    public List<SystemWechatMenu> selectSystemWechatMenuList(SystemWechatMenu systemWechatMenu);

    /**
     * 新增小程序按钮权限
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 结果
     */
    public int insertSystemWechatMenu(SystemWechatMenu systemWechatMenu);

    /**
     * 修改小程序按钮权限
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 结果
     */
    public int updateSystemWechatMenu(SystemWechatMenu systemWechatMenu);

    /**
     * 批量删除小程序按钮权限
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemWechatMenuByIds(String ids);

    /**
     * 删除小程序按钮权限信息
     * 
     * @param id 小程序按钮权限ID
     * @return 结果
     */
    public int deleteSystemWechatMenuById(Long id);

    /**
     * 查询小程序按钮权限树列表
     * 
     * @return 所有小程序按钮权限信息
     */
    public List<Ztree> selectSystemWechatMenuTree();

    List<TreeNode> selectTree();

    List<Ztree> roleMenuTreeData(Role role);
}
