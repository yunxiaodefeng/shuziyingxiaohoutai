package com.ruoyi.project.mbkj.systemwechatrole.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.mbkj.systemwechatrole.domain.SystemWechatRole;
import com.ruoyi.project.mbkj.systemwechatrole.mapper.SystemWechatRoleMapper;
import com.ruoyi.project.mbkj.systemwechatrole.service.ISystemWechatRoleService;
import com.ruoyi.project.mbkj.systemwechatrolemenu.domain.SystemWechatRoleMenu;
import com.ruoyi.project.mbkj.systemwechatrolemenu.mapper.SystemWechatRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 小程序角色Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
@Service
public class SystemWechatRoleServiceImpl implements ISystemWechatRoleService 
{
    @Autowired
    private SystemWechatRoleMapper systemWechatRoleMapper;
    @Autowired
    private SystemWechatRoleMenuMapper systemWechatRoleMenuMapper;
    /**
     * 查询小程序角色
     * 
     * @param id 小程序角色ID
     * @return 小程序角色
     */
    @Override
    public SystemWechatRole selectSystemWechatRoleById(Long id)
    {
        return systemWechatRoleMapper.selectSystemWechatRoleById(id);
    }

    /**
     * 查询小程序角色列表
     * 
     * @param systemWechatRole 小程序角色
     * @return 小程序角色
     */
    @Override
    public List<SystemWechatRole> selectSystemWechatRoleList(SystemWechatRole systemWechatRole)
    {
        return systemWechatRoleMapper.selectSystemWechatRoleList(systemWechatRole);
    }

    /**
     * 新增小程序角色
     * 
     * @param systemWechatRole 小程序角色
     * @return 结果
     */
    @Override
    public int insertSystemWechatRole(SystemWechatRole systemWechatRole)
    {
        int i = systemWechatRoleMapper.insertSystemWechatRole(systemWechatRole);

        addRoleMenu(systemWechatRole, i);
        return i;
    }

    /**
     * 修改小程序角色
     * 
     * @param systemWechatRole 小程序角色
     * @return 结果
     */
    @Override
    public int updateSystemWechatRole(SystemWechatRole systemWechatRole)
    {
        int i = systemWechatRoleMapper.updateSystemWechatRole(systemWechatRole);
        systemWechatRoleMenuMapper.deleteSystemWechatRoleMenuByRoleId(systemWechatRole.getId());
        addRoleMenu(systemWechatRole, i);
        return i;
    }

    private void addRoleMenu(SystemWechatRole systemWechatRole, int i) {
        if(i>0){
            String[] split = systemWechatRole.getZtrees().split(",");
            // 新增权限与角色管理
            List<SystemWechatRoleMenu> list = new ArrayList<SystemWechatRoleMenu>();
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                SystemWechatRoleMenu roleMenu=new SystemWechatRoleMenu();
                roleMenu.setMenuid(Long.valueOf(s));
                roleMenu.setRoleid(systemWechatRole.getId());
                list.add(roleMenu);
            }
            if(list.size()>0){
                systemWechatRoleMenuMapper.batchWechatRoleMenu(list);
            }

        }
    }

    /**
     * 删除小程序角色对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatRoleByIds(String ids)
    {
        return systemWechatRoleMapper.deleteSystemWechatRoleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小程序角色信息
     * 
     * @param id 小程序角色ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatRoleById(Long id)
    {
        return systemWechatRoleMapper.deleteSystemWechatRoleById(id);
    }

    /**
     * 查询小程序角色树列表
     * 
     * @return 所有小程序角色信息
     */
    @Override
    public List<Ztree> selectSystemWechatRoleTree()
    {
        List<SystemWechatRole> systemWechatRoleList = systemWechatRoleMapper.selectSystemWechatRoleList(new SystemWechatRole());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SystemWechatRole systemWechatRole : systemWechatRoleList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(systemWechatRole.getId());
            ztree.setpId(systemWechatRole.getParentid());
            ztree.setName(systemWechatRole.getName());
            ztree.setTitle(systemWechatRole.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
