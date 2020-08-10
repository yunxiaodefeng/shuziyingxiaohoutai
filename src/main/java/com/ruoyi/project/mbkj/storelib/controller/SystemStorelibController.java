package com.ruoyi.project.mbkj.storelib.controller;

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
import com.ruoyi.project.mbkj.storelib.domain.SystemStorelib;
import com.ruoyi.project.mbkj.storelib.service.ISystemStorelibService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 网点指标详情Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Controller
@RequestMapping("/mbkj/storelib")
public class SystemStorelibController extends BaseController
{
    private String prefix = "mbkj/storelib";

    @Autowired
    private ISystemStorelibService systemStorelibService;

    @RequiresPermissions("mbkj:storelib:view")
    @GetMapping()
    public String storelib()
    {
        return prefix + "/storelib";
    }

    /**
     * 查询网点指标详情列表
     */
    @RequiresPermissions("mbkj:storelib:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemStorelib systemStorelib)
    {
        startPage();
        List<SystemStorelib> list = systemStorelibService.selectSystemStorelibList(systemStorelib);
        return getDataTable(list);
    }

    /**
     * 导出网点指标详情列表
     */
    @RequiresPermissions("mbkj:storelib:export")
    @Log(title = "网点指标详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemStorelib systemStorelib)
    {
        List<SystemStorelib> list = systemStorelibService.selectSystemStorelibList(systemStorelib);
        ExcelUtil<SystemStorelib> util = new ExcelUtil<SystemStorelib>(SystemStorelib.class);
        return util.exportExcel(list, "storelib");
    }

    /**
     * 新增网点指标详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网点指标详情
     */
    @RequiresPermissions("mbkj:storelib:add")
    @Log(title = "网点指标详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemStorelib systemStorelib)
    {
        return toAjax(systemStorelibService.insertSystemStorelib(systemStorelib));
    }

    /**
     * 修改网点指标详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemStorelib systemStorelib = systemStorelibService.selectSystemStorelibById(id);
        mmap.put("systemStorelib", systemStorelib);
        return prefix + "/edit";
    }

    /**
     * 修改保存网点指标详情
     */
    @RequiresPermissions("mbkj:storelib:edit")
    @Log(title = "网点指标详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemStorelib systemStorelib)
    {
        return toAjax(systemStorelibService.updateSystemStorelib(systemStorelib));
    }

    /**
     * 删除网点指标详情
     */
    @RequiresPermissions("mbkj:storelib:remove")
    @Log(title = "网点指标详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemStorelibService.deleteSystemStorelibByIds(ids));
    }
}
