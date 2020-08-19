package com.ruoyi.project.mbkj.systemwechatmenu.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.SystemWechatMenu;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.TreeNode;
import com.ruoyi.project.mbkj.systemwechatmenu.mapper.SystemWechatMenuMapper;
import com.ruoyi.project.mbkj.systemwechatmenu.service.ISystemWechatMenuService;
import com.ruoyi.project.system.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序按钮权限Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-13
 */
@Service
public class SystemWechatMenuServiceImpl implements ISystemWechatMenuService 
{
    @Autowired
    private SystemWechatMenuMapper systemWechatMenuMapper;

    /**
     * 查询小程序按钮权限
     * 
     * @param id 小程序按钮权限ID
     * @return 小程序按钮权限
     */
    @Override
    public SystemWechatMenu selectSystemWechatMenuById(Long id)
    {
        return systemWechatMenuMapper.selectSystemWechatMenuById(id);
    }

    /**
     * 查询小程序按钮权限列表
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 小程序按钮权限
     */
    @Override
    public List<SystemWechatMenu> selectSystemWechatMenuList(SystemWechatMenu systemWechatMenu)
    {
        return systemWechatMenuMapper.selectSystemWechatMenuList(systemWechatMenu);
    }

    /**
     * 新增小程序按钮权限
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 结果
     */
    @Override
    public int insertSystemWechatMenu(SystemWechatMenu systemWechatMenu)
    {
        return systemWechatMenuMapper.insertSystemWechatMenu(systemWechatMenu);
    }

    /**
     * 修改小程序按钮权限
     * 
     * @param systemWechatMenu 小程序按钮权限
     * @return 结果
     */
    @Override
    public int updateSystemWechatMenu(SystemWechatMenu systemWechatMenu)
    {
        return systemWechatMenuMapper.updateSystemWechatMenu(systemWechatMenu);
    }

    /**
     * 删除小程序按钮权限对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatMenuByIds(String ids)
    {
        return systemWechatMenuMapper.deleteSystemWechatMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小程序按钮权限信息
     * 
     * @param id 小程序按钮权限ID
     * @return 结果
     */
    @Override
    public int deleteSystemWechatMenuById(Long id)
    {
        return systemWechatMenuMapper.deleteSystemWechatMenuById(id);
    }

    /**
     * 查询小程序按钮权限树列表
     * 
     * @return 所有小程序按钮权限信息
     */
    @Override
    public List<Ztree> selectSystemWechatMenuTree()
    {
        List<SystemWechatMenu> systemWechatMenuList = systemWechatMenuMapper.selectSystemWechatMenuList(new SystemWechatMenu());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SystemWechatMenu systemWechatMenu : systemWechatMenuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(systemWechatMenu.getId());
            ztree.setpId(systemWechatMenu.getParentid());
            ztree.setName(systemWechatMenu.getBtnname());
            ztree.setTitle(systemWechatMenu.getBtnname());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public List<TreeNode> selectTree(Long role) {
        Map<String,Object> map=new HashMap();
        map.put("id",0);
        map.put("role",role);
        List<TreeNode> list=systemWechatMenuMapper.selectTree(map);
        for (TreeNode treeNode : list) {
            Map<String,Object> map1=new HashMap();
            map1.put("id",treeNode.getId());
            map1.put("role",role);
            treeNode.setChildren(systemWechatMenuMapper.selectTree(map1));
        }
        return list;
    }

    @Override
    public List<Ztree> roleMenuTreeData(Role role) {

        Long roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SystemWechatMenu> menuList = selectWechatMenuAll(role.getRoleId());
        if (StringUtils.isNotNull(roleId))
        {
            List<String> roleMenuList = systemWechatMenuMapper.selectWechatMenuTree(roleId);
            ztrees = initZtree(menuList, roleMenuList, true);
        }
        else
        {
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    public List<Ztree> initZtree(List<SystemWechatMenu> menuList, List<String> roleMenuList, boolean permsFlag)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (SystemWechatMenu menu : menuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getId());
            ztree.setpId(menu.getParentid());
            ztree.setName(menu.getBtnname());
            ztree.setTitle(menu.getBtnname());
            if (isCheck)
            {
                ztree.setChecked(roleMenuList.contains(String.valueOf(menu.getId())));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list.contains("1"));
    }

    public List<SystemWechatMenu> selectWechatMenuAll(Long id)
    {
        SystemWechatMenu wechatMenu=new SystemWechatMenu();
        List<SystemWechatMenu> menuList = null;
//        if (null==id)
//        {
            menuList = systemWechatMenuMapper.selectSystemWechatMenuListZtrees(wechatMenu);
//        }
//        else
//        {
//////            menuList = menuMapper.selectMenuAllByUserId(user.getUserId());
//            menuList = systemWechatMenuMapper.selectMenuAllByUserId(id);
//        }
        return menuList;
    }

}
