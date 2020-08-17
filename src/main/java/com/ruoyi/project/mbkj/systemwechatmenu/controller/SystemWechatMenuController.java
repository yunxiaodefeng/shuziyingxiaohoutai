package com.ruoyi.project.mbkj.systemwechatmenu.controller;

import com.ruoyi.common.utils.JsonUtils;
import com.ruoyi.common.utils.RedisUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.SystemWechatMenu;
import com.ruoyi.project.mbkj.systemwechatmenu.domain.TreeNode;
import com.ruoyi.project.mbkj.systemwechatmenu.service.ISystemWechatMenuService;
import com.ruoyi.project.system.role.domain.Role;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 小程序按钮权限Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-13
 */
@Controller
@RequestMapping("/mbkj/systemwechatmenu")
public class SystemWechatMenuController extends BaseController
{
    private String prefix = "mbkj/systemwechatmenu";
    @Autowired
    private RedisUtils redisService;
    @Autowired
    private ISystemWechatMenuService systemWechatMenuService;

    @RequiresPermissions("mbkj:systemwechatmenu:view")
    @GetMapping()
    public String systemwechatmenu()
    {
        return prefix + "/systemwechatmenu";
    }

    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(Role role)
    {
        List<Ztree> ztrees = systemWechatMenuService.roleMenuTreeData(role);
        return ztrees;
    }

    /**
     * 查询小程序按钮权限树列表
     */
    @RequiresPermissions("mbkj:systemwechatmenu:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SystemWechatMenu> list(SystemWechatMenu systemWechatMenu)
    {
        List<SystemWechatMenu> list = systemWechatMenuService.selectSystemWechatMenuList(systemWechatMenu);
        return list;
    }

    /**
     * 导出小程序按钮权限列表
     */
    @RequiresPermissions("mbkj:systemwechatmenu:export")
    @Log(title = "小程序按钮权限", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemWechatMenu systemWechatMenu)
    {
        List<SystemWechatMenu> list = systemWechatMenuService.selectSystemWechatMenuList(systemWechatMenu);
        ExcelUtil<SystemWechatMenu> util = new ExcelUtil<SystemWechatMenu>(SystemWechatMenu.class);
        return util.exportExcel(list, "systemwechatmenu");
    }

    /**
     * 新增小程序按钮权限
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("systemWechatMenu", systemWechatMenuService.selectSystemWechatMenuById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存小程序按钮权限
     */
    @RequiresPermissions("mbkj:systemwechatmenu:add")
    @Log(title = "小程序按钮权限", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemWechatMenu systemWechatMenu)
    {
        int i = systemWechatMenuService.insertSystemWechatMenu(systemWechatMenu);
        updateRedisTree(i);
        return toAjax(i);
    }

    /**
     * 修改小程序按钮权限
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemWechatMenu systemWechatMenu = systemWechatMenuService.selectSystemWechatMenuById(id);
        mmap.put("systemWechatMenu", systemWechatMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存小程序按钮权限
     */
    @RequiresPermissions("mbkj:systemwechatmenu:edit")
    @Log(title = "小程序按钮权限", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemWechatMenu systemWechatMenu)
    {
        int i = systemWechatMenuService.updateSystemWechatMenu(systemWechatMenu);
        updateRedisTree(i);
        return toAjax(i);
    }

    private void updateRedisTree(int i) {
        if (i >= 1) {
            if (redisService.hasKey("treeNode")) {
                redisService.del("treeNode");
            }
            List<TreeNode> list = systemWechatMenuService.selectTree();
            try {
                redisService.set("treeNode", JsonUtils.object2Json(list));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除
     */
    @RequiresPermissions("mbkj:systemwechatmenu:remove")
    @Log(title = "小程序按钮权限", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        int i = systemWechatMenuService.deleteSystemWechatMenuById(id);
        updateRedisTree(i);
        return toAjax(i);
    }

    /**
     * 选择小程序按钮权限树
     */
    @GetMapping(value = { "/selectSystemwechatmenuTree/{id}", "/selectSystemwechatmenuTree/" })
    public String selectSystemwechatmenuTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("systemWechatMenu", systemWechatMenuService.selectSystemWechatMenuById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载小程序按钮权限树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = systemWechatMenuService.selectSystemWechatMenuTree();
        return ztrees;
    }
}
