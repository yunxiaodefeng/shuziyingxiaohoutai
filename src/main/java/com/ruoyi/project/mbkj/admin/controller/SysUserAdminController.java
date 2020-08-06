package com.ruoyi.project.mbkj.admin.controller;

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
import com.ruoyi.project.mbkj.admin.domain.SysUserAdmin;
import com.ruoyi.project.mbkj.admin.service.ISysUserAdminService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 员工管理Controller
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/admin")
public class SysUserAdminController extends BaseController
{
    private String prefix = "mbkj/admin";

    @Autowired
    private ISysUserAdminService sysUserAdminService;

    @RequiresPermissions("mbkj:admin:view")
    @GetMapping()
    public String admin()
    {
        return prefix + "/admin";
    }

    /**
     * 查询员工管理列表
     */
    @RequiresPermissions("mbkj:admin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserAdmin sysUserAdmin)
    {
        startPage();
        List<SysUserAdmin> list = sysUserAdminService.selectSysUserAdminList(sysUserAdmin);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @RequiresPermissions("mbkj:admin:export")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUserAdmin sysUserAdmin)
    {
        List<SysUserAdmin> list = sysUserAdminService.selectSysUserAdminList(sysUserAdmin);
        ExcelUtil<SysUserAdmin> util = new ExcelUtil<SysUserAdmin>(SysUserAdmin.class);
        return util.exportExcel(list, "admin");
    }

    /**
     * 新增员工管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工管理
     */
    @RequiresPermissions("mbkj:admin:add")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUserAdmin sysUserAdmin)
    {
        return toAjax(sysUserAdminService.insertSysUserAdmin(sysUserAdmin));
    }

    /**
     * 修改员工管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysUserAdmin sysUserAdmin = sysUserAdminService.selectSysUserAdminById(id);
        mmap.put("sysUserAdmin", sysUserAdmin);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工管理
     */
    @RequiresPermissions("mbkj:admin:edit")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUserAdmin sysUserAdmin)
    {
        return toAjax(sysUserAdminService.updateSysUserAdmin(sysUserAdmin));
    }

    /**
     * 删除员工管理
     */
    @RequiresPermissions("mbkj:admin:remove")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUserAdminService.deleteSysUserAdminByIds(ids));
    }
}
