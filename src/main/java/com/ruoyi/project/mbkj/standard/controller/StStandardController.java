package com.ruoyi.project.mbkj.standard.controller;

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
import com.ruoyi.project.mbkj.standard.domain.StStandard;
import com.ruoyi.project.mbkj.standard.service.IStStandardService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 录入业绩类型信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-07
 */
@Controller
@RequestMapping("/mbkj/standard")
public class StStandardController extends BaseController
{
    private String prefix = "mbkj/standard";

    @Autowired
    private IStStandardService stStandardService;

    @RequiresPermissions("mbkj:standard:view")
    @GetMapping()
    public String standard()
    {
        return prefix + "/standard";
    }

    /**
     * 查询录入业绩类型信息列表
     */
    @RequiresPermissions("mbkj:standard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StStandard stStandard)
    {
        startPage();
        List<StStandard> list = stStandardService.selectStStandardList(stStandard);
        return getDataTable(list);
    }

    /**
     * 导出录入业绩类型信息列表
     */
    @RequiresPermissions("mbkj:standard:export")
    @Log(title = "录入业绩类型信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StStandard stStandard)
    {
        List<StStandard> list = stStandardService.selectStStandardList(stStandard);
        ExcelUtil<StStandard> util = new ExcelUtil<StStandard>(StStandard.class);
        return util.exportExcel(list, "standard");
    }

    /**
     * 新增录入业绩类型信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存录入业绩类型信息
     */
    @RequiresPermissions("mbkj:standard:add")
    @Log(title = "录入业绩类型信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StStandard stStandard)
    {
        return toAjax(stStandardService.insertStStandard(stStandard));
    }

    /**
     * 修改录入业绩类型信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StStandard stStandard = stStandardService.selectStStandardById(id);
        mmap.put("stStandard", stStandard);
        return prefix + "/edit";
    }

    /**
     * 修改保存录入业绩类型信息
     */
    @RequiresPermissions("mbkj:standard:edit")
    @Log(title = "录入业绩类型信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StStandard stStandard)
    {
        return toAjax(stStandardService.updateStStandard(stStandard));
    }

    /**
     * 删除录入业绩类型信息
     */
    @RequiresPermissions("mbkj:standard:remove")
    @Log(title = "录入业绩类型信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stStandardService.deleteStStandardByIds(ids));
    }
}
