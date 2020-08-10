package com.ruoyi.project.mbkj.systemLib.controller;

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
import com.ruoyi.project.mbkj.systemLib.domain.SystemLib;
import com.ruoyi.project.mbkj.systemLib.service.ISystemLibService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户标签信息基础Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Controller
@RequestMapping("/mbkj/systemLib")
public class SystemLibController extends BaseController
{
    private String prefix = "mbkj/systemLib";

    @Autowired
    private ISystemLibService systemLibService;

    @RequiresPermissions("mbkj:systemLib:view")
    @GetMapping()
    public String systemLib()
    {
        return prefix + "/systemLib";
    }

    /**
     * 查询客户标签信息基础列表
     */
    @RequiresPermissions("mbkj:systemLib:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemLib systemLib)
    {
        startPage();
        List<SystemLib> list = systemLibService.selectSystemLibList(systemLib);
        return getDataTable(list);
    }

    /**
     * 导出客户标签信息基础列表
     */
    @RequiresPermissions("mbkj:systemLib:export")
    @Log(title = "客户标签信息基础", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemLib systemLib)
    {
        List<SystemLib> list = systemLibService.selectSystemLibList(systemLib);
        ExcelUtil<SystemLib> util = new ExcelUtil<SystemLib>(SystemLib.class);
        return util.exportExcel(list, "systemLib");
    }

    /**
     * 新增客户标签信息基础
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户标签信息基础
     */
    @RequiresPermissions("mbkj:systemLib:add")
    @Log(title = "客户标签信息基础", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemLib systemLib)
    {
        return toAjax(systemLibService.insertSystemLib(systemLib));
    }

    /**
     * 修改客户标签信息基础
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemLib systemLib = systemLibService.selectSystemLibById(id);
        mmap.put("systemLib", systemLib);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户标签信息基础
     */
    @RequiresPermissions("mbkj:systemLib:edit")
    @Log(title = "客户标签信息基础", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemLib systemLib)
    {
        return toAjax(systemLibService.updateSystemLib(systemLib));
    }

    /**
     * 删除客户标签信息基础
     */
    @RequiresPermissions("mbkj:systemLib:remove")
    @Log(title = "客户标签信息基础", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemLibService.deleteSystemLibByIds(ids));
    }
}
