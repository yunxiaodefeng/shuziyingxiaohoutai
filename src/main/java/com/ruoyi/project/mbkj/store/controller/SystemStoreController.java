package com.ruoyi.project.mbkj.store.controller;

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
import com.ruoyi.project.mbkj.store.domain.SystemStore;
import com.ruoyi.project.mbkj.store.service.ISystemStoreService;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 网点Controller
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/store")
public class SystemStoreController extends BaseController
{
    private String prefix = "mbkj/store";

    @Autowired
    private ISystemStoreService systemStoreService;

    @RequiresPermissions("mbkj:store:view")
    @GetMapping()
    public String store()
    {
        return prefix + "/store";
    }

    /**
     * 查询网点列表
     */
    @RequiresPermissions("mbkj:store:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemStore systemStore)
    {
        startPage();
        List<SystemStore> list = systemStoreService.selectSystemStoreList(systemStore);
        return getDataTable(list);
    }

    /**
     * 导出网点列表
     */
    @RequiresPermissions("mbkj:store:export")
    @Log(title = "网点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemStore systemStore)
    {
        List<SystemStore> list = systemStoreService.selectSystemStoreList(systemStore);
        ExcelUtil<SystemStore> util = new ExcelUtil<SystemStore>(SystemStore.class);
        return util.exportExcel(list, "store");
    }

    /**
     * 新增网点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网点
     */
    @RequiresPermissions("mbkj:store:add")
    @Log(title = "网点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemStore systemStore)
    {
        return toAjax(systemStoreService.insertSystemStore(systemStore));
    }

    /**
     * 修改网点
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemStore systemStore = systemStoreService.selectSystemStoreById(id);
        mmap.put("systemStore", systemStore);
        return prefix + "/edit";
    }

    /**
     * 修改保存网点
     */
    @RequiresPermissions("mbkj:store:edit")
    @Log(title = "网点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemStore systemStore)
    {
        return toAjax(systemStoreService.updateSystemStore(systemStore));
    }

    /**
     * 删除网点
     */
    @RequiresPermissions("mbkj:store:remove")
    @Log(title = "网点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemStoreService.deleteSystemStoreByIds(ids));
    }
    
    /**
     * 加载网点列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = systemStoreService.selectStoreTree(new SystemStore());
        return ztrees;
    }
}
