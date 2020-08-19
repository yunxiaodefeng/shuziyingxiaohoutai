package com.ruoyi.project.mbkj.systemwechatrolemenu.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.mbkj.systemwechatrolemenu.domain.SystemWechatRoleMenu;
import com.ruoyi.project.mbkj.systemwechatrolemenu.service.ISystemWechatRoleMenuService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 小程序角色权限中间Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
@Controller
@RequestMapping("/mbkj/systemwechatrolemenu")
public class SystemWechatRoleMenuController extends BaseController
{
    private String prefix = "mbkj/systemwechatrolemenu";

    @Autowired
    private ISystemWechatRoleMenuService systemWechatRoleMenuService;

    @RequiresPermissions("mbkj:systemwechatrolemenu:view")
    @GetMapping()
    public String systemwechatrolemenu()
    {
        return prefix + "/systemwechatrolemenu";
    }

    /**
     * 查询小程序角色权限中间列表
     */
    @RequiresPermissions("mbkj:systemwechatrolemenu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        startPage();
        List<SystemWechatRoleMenu> list = systemWechatRoleMenuService.selectSystemWechatRoleMenuList(systemWechatRoleMenu);
        return getDataTable(list);
    }

    /**
     * 导出小程序角色权限中间列表
     */
    @RequiresPermissions("mbkj:systemwechatrolemenu:export")
    @Log(title = "小程序角色权限中间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        List<SystemWechatRoleMenu> list = systemWechatRoleMenuService.selectSystemWechatRoleMenuList(systemWechatRoleMenu);
        ExcelUtil<SystemWechatRoleMenu> util = new ExcelUtil<SystemWechatRoleMenu>(SystemWechatRoleMenu.class);
        return util.exportExcel(list, "systemwechatrolemenu");
    }

    /**
     * 新增小程序角色权限中间
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小程序角色权限中间
     */
    @RequiresPermissions("mbkj:systemwechatrolemenu:add")
    @Log(title = "小程序角色权限中间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        return toAjax(systemWechatRoleMenuService.insertSystemWechatRoleMenu(systemWechatRoleMenu));
    }

    /**
     * 修改小程序角色权限中间
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemWechatRoleMenu systemWechatRoleMenu = systemWechatRoleMenuService.selectSystemWechatRoleMenuById(id);
        mmap.put("systemWechatRoleMenu", systemWechatRoleMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存小程序角色权限中间
     */
    @RequiresPermissions("mbkj:systemwechatrolemenu:edit")
    @Log(title = "小程序角色权限中间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemWechatRoleMenu systemWechatRoleMenu)
    {
        return toAjax(systemWechatRoleMenuService.updateSystemWechatRoleMenu(systemWechatRoleMenu));
    }

    /**
     * 删除小程序角色权限中间
     */
    @RequiresPermissions("mbkj:systemwechatrolemenu:remove")
    @Log(title = "小程序角色权限中间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemWechatRoleMenuService.deleteSystemWechatRoleMenuByIds(ids));
    }
}
