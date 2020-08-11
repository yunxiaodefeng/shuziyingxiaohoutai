package com.ruoyi.project.mbkj.systemtransactionlog.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mbkj.systemtransactionlog.domain.SystemTransactionLog;
import com.ruoyi.project.mbkj.systemtransactionlog.service.ISystemTransactionLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 交易记录Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/systemtransactionlog")
public class SystemTransactionLogController extends BaseController
{
    private String prefix = "mbkj/systemtransactionlog";

    @Autowired
    private ISystemTransactionLogService systemTransactionLogService;

//    @RequiresPermissions("mbkj:systemtransactionlog:view")
    @GetMapping(value = "/page/{clientid}")
    public String systemtransactionlog(ModelMap model, @PathVariable("clientid") Integer clientid)
    {
        List<Map> list= systemTransactionLogService.selectTransactionLogPancake(clientid);
        model.addAttribute("clientid", clientid);
        model.addAttribute("selectList", list);
        if(list.size()>0){
            model.addAttribute("selectListDefault", list.get(0).get("id"));
        }else {
            model.addAttribute("selectListDefault", 0);
        }
        return prefix + "/systemtransactionlog";
    }

    /**
     * 查询交易记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemTransactionLog systemTransactionLog)
    {
        startPage();
        Long standardid=0L;
        if(systemTransactionLog.getStandardid()==null){
            List<Map> list= systemTransactionLogService.selectTransactionLogPancake(Integer.valueOf(String.valueOf(systemTransactionLog.getClientid())));
            if(list.size()>0){
                standardid= Long.valueOf(String.valueOf(list.get(0).get("id")));
            }
        }else {
            standardid=systemTransactionLog.getStandardid();
        }


//        List<SystemTransactionLog> list = systemTransactionLogService.selectSystemTransactionLogList(systemTransactionLog);
        List<Map> list=systemTransactionLogService.selectTransactionLog(standardid,systemTransactionLog.getClientid());

        return getDataTable(list);
    }

    /**
     * 导出交易记录列表
     */
    @RequiresPermissions("mbkj:systemtransactionlog:export")
    @Log(title = "交易记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SystemTransactionLog systemTransactionLog)
    {
        List<SystemTransactionLog> list = systemTransactionLogService.selectSystemTransactionLogList(systemTransactionLog);
        ExcelUtil<SystemTransactionLog> util = new ExcelUtil<SystemTransactionLog>(SystemTransactionLog.class);
        return util.exportExcel(list, "systemtransactionlog");
    }

    /**
     * 新增交易记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存交易记录
     */
    @RequiresPermissions("mbkj:systemtransactionlog:add")
    @Log(title = "交易记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemTransactionLog systemTransactionLog)
    {
        return toAjax(systemTransactionLogService.insertSystemTransactionLog(systemTransactionLog));
    }

    /**
     * 修改交易记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SystemTransactionLog systemTransactionLog = systemTransactionLogService.selectSystemTransactionLogById(id);
        mmap.put("systemTransactionLog", systemTransactionLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存交易记录
     */
    @RequiresPermissions("mbkj:systemtransactionlog:edit")
    @Log(title = "交易记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SystemTransactionLog systemTransactionLog)
    {
        return toAjax(systemTransactionLogService.updateSystemTransactionLog(systemTransactionLog));
    }

    /**
     * 删除交易记录
     */
    @RequiresPermissions("mbkj:systemtransactionlog:remove")
    @Log(title = "交易记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(systemTransactionLogService.deleteSystemTransactionLogByIds(ids));
    }
}
