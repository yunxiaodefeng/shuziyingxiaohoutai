package com.ruoyi.project.mbkj.userparam.controller;

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
import com.ruoyi.project.mbkj.userparam.domain.SystemUserparam;
import com.ruoyi.project.mbkj.userparam.service.ISystemUserparamService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户指标系数Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
@Controller
@RequestMapping("/mbkj/userparam")
public class SystemUserparamController extends BaseController
{
    private String prefix = "mbkj/userparam";

    @Autowired
    private ISystemUserparamService systemUserparamService;

    @RequiresPermissions("mbkj:userparam:view")
    @GetMapping()
    public String userparam()
    {
        return prefix + "/userparam";
    }

    /**
     * 查询用户指标系数列表
     */
    @RequiresPermissions("mbkj:userparam:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemUserparam systemUserparam)
    {
        startPage();
        List<SystemUserparam> list = systemUserparamService.selectSystemUserparamList(systemUserparam);
        return getDataTable(list);
    }

    /**
     * 导出用户指标系数列表
     */
    @RequiresPermissions("mbkj:userparam:export")
    @Log(title = "用户指标系数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemUserparam systemUserparam)
    {
        List<SystemUserparam> list = systemUserparamService.selectSystemUserparamList(systemUserparam);
        ExcelUtil<SystemUserparam> util = new ExcelUtil<SystemUserparam>(SystemUserparam.class);
        return util.exportExcel(list, "userparam");
    }

    /**
     * 新增用户指标系数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户指标系数
     */
    @RequiresPermissions("mbkj:userparam:add")
    @Log(title = "用户指标系数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemUserparam systemUserparam)
    {
        return toAjax(systemUserparamService.insertSystemUserparam(systemUserparam));
    }

    /**
     * 修改用户指标系数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemUserparam systemUserparam = systemUserparamService.selectSystemUserparamById(id);
        mmap.put("systemUserparam", systemUserparam);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户指标系数
     */
    @RequiresPermissions("mbkj:userparam:edit")
    @Log(title = "用户指标系数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemUserparam systemUserparam)
    {
        return toAjax(systemUserparamService.updateSystemUserparam(systemUserparam));
    }

    /**
     * 删除用户指标系数
     */
    @RequiresPermissions("mbkj:userparam:remove")
    @Log(title = "用户指标系数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemUserparamService.deleteSystemUserparamByIds(ids));
    }
}
