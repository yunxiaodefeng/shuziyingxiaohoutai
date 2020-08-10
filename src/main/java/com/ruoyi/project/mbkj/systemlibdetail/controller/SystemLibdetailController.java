package com.ruoyi.project.mbkj.systemlibdetail.controller;

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
import com.ruoyi.project.mbkj.systemlibdetail.domain.SystemLibdetail;
import com.ruoyi.project.mbkj.systemlibdetail.service.ISystemLibdetailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户标签信息详情Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/systemlibdetail")
public class SystemLibdetailController extends BaseController
{
    private String prefix = "mbkj/systemlibdetail";

    @Autowired
    private ISystemLibdetailService systemLibdetailService;

    @RequiresPermissions("mbkj:systemlibdetail:view")
    @GetMapping()
    public String systemlibdetail()
    {
        return prefix + "/systemlibdetail";
    }

    /**
     * 查询客户标签信息详情列表
     */
    @RequiresPermissions("mbkj:systemlibdetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemLibdetail systemLibdetail)
    {
        startPage();
        List<SystemLibdetail> list = systemLibdetailService.selectSystemLibdetailList(systemLibdetail);
        return getDataTable(list);
    }

    /**
     * 导出客户标签信息详情列表
     */
    @RequiresPermissions("mbkj:systemlibdetail:export")
    @Log(title = "客户标签信息详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemLibdetail systemLibdetail)
    {
        List<SystemLibdetail> list = systemLibdetailService.selectSystemLibdetailList(systemLibdetail);
        ExcelUtil<SystemLibdetail> util = new ExcelUtil<SystemLibdetail>(SystemLibdetail.class);
        return util.exportExcel(list, "systemlibdetail");
    }

    /**
     * 新增客户标签信息详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户标签信息详情
     */
    @RequiresPermissions("mbkj:systemlibdetail:add")
    @Log(title = "客户标签信息详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemLibdetail systemLibdetail)
    {
        return toAjax(systemLibdetailService.insertSystemLibdetail(systemLibdetail));
    }

    /**
     * 修改客户标签信息详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemLibdetail systemLibdetail = systemLibdetailService.selectSystemLibdetailById(id);
        mmap.put("systemLibdetail", systemLibdetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户标签信息详情
     */
    @RequiresPermissions("mbkj:systemlibdetail:edit")
    @Log(title = "客户标签信息详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemLibdetail systemLibdetail)
    {
        return toAjax(systemLibdetailService.updateSystemLibdetail(systemLibdetail));
    }

    /**
     * 删除客户标签信息详情
     */
    @RequiresPermissions("mbkj:systemlibdetail:remove")
    @Log(title = "客户标签信息详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemLibdetailService.deleteSystemLibdetailByIds(ids));
    }
}
