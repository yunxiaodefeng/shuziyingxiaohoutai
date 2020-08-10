package com.ruoyi.project.mbkj.stusertask.controller;

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
import com.ruoyi.project.mbkj.stusertask.domain.StUserTask;
import com.ruoyi.project.mbkj.stusertask.service.IStUserTaskService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 存储设置的用户绩效Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
@Controller
@RequestMapping("/mbkj/stusertask")
public class StUserTaskController extends BaseController
{
    private String prefix = "mbkj/stusertask";

    @Autowired
    private IStUserTaskService stUserTaskService;

    @RequiresPermissions("mbkj:stusertask:view")
    @GetMapping()
    public String stusertask()
    {
        return prefix + "/stusertask";
    }

    /**
     * 查询存储设置的用户绩效列表
     */
    @RequiresPermissions("mbkj:stusertask:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StUserTask stUserTask)
    {
        startPage();
        List<StUserTask> list = stUserTaskService.selectStUserTaskList(stUserTask);
        return getDataTable(list);
    }

    /**
     * 导出存储设置的用户绩效列表
     */
    @RequiresPermissions("mbkj:stusertask:export")
    @Log(title = "存储设置的用户绩效", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StUserTask stUserTask)
    {
        List<StUserTask> list = stUserTaskService.selectStUserTaskList(stUserTask);
        ExcelUtil<StUserTask> util = new ExcelUtil<StUserTask>(StUserTask.class);
        return util.exportExcel(list, "stusertask");
    }

    /**
     * 新增存储设置的用户绩效
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存存储设置的用户绩效
     */
    @RequiresPermissions("mbkj:stusertask:add")
    @Log(title = "存储设置的用户绩效", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StUserTask stUserTask)
    {
        return toAjax(stUserTaskService.insertStUserTask(stUserTask));
    }

    /**
     * 修改存储设置的用户绩效
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StUserTask stUserTask = stUserTaskService.selectStUserTaskById(id);
        mmap.put("stUserTask", stUserTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存存储设置的用户绩效
     */
    @RequiresPermissions("mbkj:stusertask:edit")
    @Log(title = "存储设置的用户绩效", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StUserTask stUserTask)
    {
        return toAjax(stUserTaskService.updateStUserTask(stUserTask));
    }

    /**
     * 删除存储设置的用户绩效
     */
    @RequiresPermissions("mbkj:stusertask:remove")
    @Log(title = "存储设置的用户绩效", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stUserTaskService.deleteStUserTaskByIds(ids));
    }
}
