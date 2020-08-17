package com.ruoyi.project.mbkj.systemwechatrole.controller;

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
import com.ruoyi.project.mbkj.systemwechatrole.domain.SystemWechatRole;
import com.ruoyi.project.mbkj.systemwechatrole.service.ISystemWechatRoleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 小程序角色Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
@Controller
@RequestMapping("/mbkj/systemwechatrole")
public class SystemWechatRoleController extends BaseController
{
    private String prefix = "mbkj/systemwechatrole";

    @Autowired
    private ISystemWechatRoleService systemWechatRoleService;

    @RequiresPermissions("mbkj:systemwechatrole:view")
    @GetMapping()
    public String systemwechatrole()
    {
        return prefix + "/systemwechatrole";
    }

    /**
     * 查询小程序角色树列表
     */
    @RequiresPermissions("mbkj:systemwechatrole:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SystemWechatRole> list(SystemWechatRole systemWechatRole)
    {
        List<SystemWechatRole> list = systemWechatRoleService.selectSystemWechatRoleList(systemWechatRole);
        return list;
    }

    /**
     * 导出小程序角色列表
     */
    @RequiresPermissions("mbkj:systemwechatrole:export")
    @Log(title = "小程序角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemWechatRole systemWechatRole)
    {
        List<SystemWechatRole> list = systemWechatRoleService.selectSystemWechatRoleList(systemWechatRole);
        ExcelUtil<SystemWechatRole> util = new ExcelUtil<SystemWechatRole>(SystemWechatRole.class);
        return util.exportExcel(list, "systemwechatrole");
    }

    /**
     * 新增小程序角色
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("systemWechatRole", systemWechatRoleService.selectSystemWechatRoleById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存小程序角色
     */
    @RequiresPermissions("mbkj:systemwechatrole:add")
    @Log(title = "小程序角色", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemWechatRole systemWechatRole)
    {
        return toAjax(systemWechatRoleService.insertSystemWechatRole(systemWechatRole));
    }

    /**
     * 修改小程序角色
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemWechatRole systemWechatRole = systemWechatRoleService.selectSystemWechatRoleById(id);
        mmap.put("systemWechatRole", systemWechatRole);
        return prefix + "/edit";
    }

    /**
     * 修改保存小程序角色
     */
    @RequiresPermissions("mbkj:systemwechatrole:edit")
    @Log(title = "小程序角色", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemWechatRole systemWechatRole)
    {
        return toAjax(systemWechatRoleService.updateSystemWechatRole(systemWechatRole));
    }

    /**
     * 删除
     */
    @RequiresPermissions("mbkj:systemwechatrole:remove")
    @Log(title = "小程序角色", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(systemWechatRoleService.deleteSystemWechatRoleById(id));
    }

    /**
     * 选择小程序角色树
     */
    @GetMapping(value = { "/selectSystemwechatroleTree/{id}", "/selectSystemwechatroleTree/" })
    public String selectSystemwechatroleTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("systemWechatRole", systemWechatRoleService.selectSystemWechatRoleById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载小程序角色树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = systemWechatRoleService.selectSystemWechatRoleTree();
        return ztrees;
    }
}
