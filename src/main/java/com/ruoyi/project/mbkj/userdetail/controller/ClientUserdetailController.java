package com.ruoyi.project.mbkj.userdetail.controller;

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
import com.ruoyi.project.mbkj.userdetail.domain.ClientUserdetail;
import com.ruoyi.project.mbkj.userdetail.service.IClientUserdetailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户标签信息详情中间表Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Controller
@RequestMapping("/mbkj/userdetail")
public class ClientUserdetailController extends BaseController
{
    private String prefix = "mbkj/userdetail";

    @Autowired
    private IClientUserdetailService clientUserdetailService;

    @RequiresPermissions("mbkj:userdetail:view")
    @GetMapping()
    public String userdetail()
    {
        return prefix + "/userdetail";
    }

    /**
     * 查询客户标签信息详情中间表列表
     */
    @RequiresPermissions("mbkj:userdetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClientUserdetail clientUserdetail)
    {
        startPage();
        List<ClientUserdetail> list = clientUserdetailService.selectClientUserdetailList(clientUserdetail);
        return getDataTable(list);
    }

    /**
     * 导出客户标签信息详情中间表列表
     */
    @RequiresPermissions("mbkj:userdetail:export")
    @Log(title = "客户标签信息详情中间表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClientUserdetail clientUserdetail)
    {
        List<ClientUserdetail> list = clientUserdetailService.selectClientUserdetailList(clientUserdetail);
        ExcelUtil<ClientUserdetail> util = new ExcelUtil<ClientUserdetail>(ClientUserdetail.class);
        return util.exportExcel(list, "userdetail");
    }

    /**
     * 新增客户标签信息详情中间表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户标签信息详情中间表
     */
    @RequiresPermissions("mbkj:userdetail:add")
    @Log(title = "客户标签信息详情中间表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClientUserdetail clientUserdetail)
    {
        return toAjax(clientUserdetailService.insertClientUserdetail(clientUserdetail));
    }

    /**
     * 修改客户标签信息详情中间表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ClientUserdetail clientUserdetail = clientUserdetailService.selectClientUserdetailById(id);
        mmap.put("clientUserdetail", clientUserdetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户标签信息详情中间表
     */
    @RequiresPermissions("mbkj:userdetail:edit")
    @Log(title = "客户标签信息详情中间表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClientUserdetail clientUserdetail)
    {
        return toAjax(clientUserdetailService.updateClientUserdetail(clientUserdetail));
    }

    /**
     * 删除客户标签信息详情中间表
     */
    @RequiresPermissions("mbkj:userdetail:remove")
    @Log(title = "客户标签信息详情中间表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clientUserdetailService.deleteClientUserdetailByIds(ids));
    }
}
