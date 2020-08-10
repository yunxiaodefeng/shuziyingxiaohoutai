package com.ruoyi.project.mbkj.systemDic.controller;

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
import com.ruoyi.project.mbkj.systemDic.domain.SystemDic;
import com.ruoyi.project.mbkj.systemDic.service.ISystemDicService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户标签信息基础表Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Controller
@RequestMapping("/mbkj/systemDic")
public class SystemDicController extends BaseController
{
    private String prefix = "mbkj/systemDic";

    @Autowired
    private ISystemDicService systemDicService;

    @RequiresPermissions("mbkj:systemDic:view")
    @GetMapping()
    public String systemDic()
    {
        return prefix + "/systemDic";
    }

    /**
     * 查询客户标签信息基础表列表
     */
    @RequiresPermissions("mbkj:systemDic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemDic systemDic)
    {
        startPage();
        List<SystemDic> list = systemDicService.selectSystemDicList(systemDic);
        return getDataTable(list);
    }

    /**
     * 导出客户标签信息基础表列表
     */
    @RequiresPermissions("mbkj:systemDic:export")
    @Log(title = "客户标签信息基础表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemDic systemDic)
    {
        List<SystemDic> list = systemDicService.selectSystemDicList(systemDic);
        ExcelUtil<SystemDic> util = new ExcelUtil<SystemDic>(SystemDic.class);
        return util.exportExcel(list, "systemDic");
    }

    /**
     * 新增客户标签信息基础表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户标签信息基础表
     */
    @RequiresPermissions("mbkj:systemDic:add")
    @Log(title = "客户标签信息基础表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemDic systemDic)
    {
        return toAjax(systemDicService.insertSystemDic(systemDic));
    }

    /**
     * 修改客户标签信息基础表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemDic systemDic = systemDicService.selectSystemDicById(id);
        mmap.put("systemDic", systemDic);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户标签信息基础表
     */
    @RequiresPermissions("mbkj:systemDic:edit")
    @Log(title = "客户标签信息基础表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemDic systemDic)
    {
        return toAjax(systemDicService.updateSystemDic(systemDic));
    }

    /**
     * 删除客户标签信息基础表
     */
    @RequiresPermissions("mbkj:systemDic:remove")
    @Log(title = "客户标签信息基础表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemDicService.deleteSystemDicByIds(ids));
    }
}
