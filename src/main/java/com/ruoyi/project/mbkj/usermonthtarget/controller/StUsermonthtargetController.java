package com.ruoyi.project.mbkj.usermonthtarget.controller;

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
import com.ruoyi.project.mbkj.usermonthtarget.domain.StUsermonthtarget;
import com.ruoyi.project.mbkj.usermonthtarget.service.IStUsermonthtargetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 数据统计Controller
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/usermonthtarget")
public class StUsermonthtargetController extends BaseController
{
    private String prefix = "mbkj/usermonthtarget";

    @Autowired
    private IStUsermonthtargetService stUsermonthtargetService;

    @RequiresPermissions("mbkj:usermonthtarget:view")
    @GetMapping()
    public String usermonthtarget()
    {
        return prefix + "/usermonthtarget";
    }

    /**
     * 查询数据统计列表
     */
    @RequiresPermissions("mbkj:usermonthtarget:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StUsermonthtarget stUsermonthtarget)
    {
        startPage();
        List<StUsermonthtarget> list = stUsermonthtargetService.selectStUsermonthtargetList(stUsermonthtarget);
        return getDataTable(list);
    }

    /**
     * 导出数据统计列表
     */
    @RequiresPermissions("mbkj:usermonthtarget:export")
    @Log(title = "数据统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StUsermonthtarget stUsermonthtarget)
    {
        List<StUsermonthtarget> list = stUsermonthtargetService.selectStUsermonthtargetList(stUsermonthtarget);
        ExcelUtil<StUsermonthtarget> util = new ExcelUtil<StUsermonthtarget>(StUsermonthtarget.class);
        return util.exportExcel(list, "usermonthtarget");
    }

    /**
     * 新增数据统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据统计
     */
    @RequiresPermissions("mbkj:usermonthtarget:add")
    @Log(title = "数据统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StUsermonthtarget stUsermonthtarget)
    {
        return toAjax(stUsermonthtargetService.insertStUsermonthtarget(stUsermonthtarget));
    }

    /**
     * 修改数据统计
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StUsermonthtarget stUsermonthtarget = stUsermonthtargetService.selectStUsermonthtargetById(id);
        mmap.put("stUsermonthtarget", stUsermonthtarget);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据统计
     */
    @RequiresPermissions("mbkj:usermonthtarget:edit")
    @Log(title = "数据统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StUsermonthtarget stUsermonthtarget)
    {
        return toAjax(stUsermonthtargetService.updateStUsermonthtarget(stUsermonthtarget));
    }

    /**
     * 删除数据统计
     */
    @RequiresPermissions("mbkj:usermonthtarget:remove")
    @Log(title = "数据统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stUsermonthtargetService.deleteStUsermonthtargetByIds(ids));
    }
}
