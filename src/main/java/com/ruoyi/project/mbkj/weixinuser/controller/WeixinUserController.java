package com.ruoyi.project.mbkj.weixinuser.controller;

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
import com.ruoyi.project.mbkj.weixinuser.domain.WeixinUser;
import com.ruoyi.project.mbkj.weixinuser.service.IWeixinUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 微信用户Controller
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/weixinuser")
public class WeixinUserController extends BaseController
{
    private String prefix = "mbkj/weixinuser";

    @Autowired
    private IWeixinUserService weixinUserService;

    @RequiresPermissions("mbkj:weixinuser:view")
    @GetMapping()
    public String weixinuser()
    {
        return prefix + "/weixinuser";
    }

    /**
     * 查询微信用户列表
     */
    @RequiresPermissions("mbkj:weixinuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WeixinUser weixinUser)
    {
        startPage();
        List<WeixinUser> list = weixinUserService.selectWeixinUserList(weixinUser);
        return getDataTable(list);
    }

    /**
     * 导出微信用户列表
     */
    @RequiresPermissions("mbkj:weixinuser:export")
    @Log(title = "微信用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WeixinUser weixinUser)
    {
        List<WeixinUser> list = weixinUserService.selectWeixinUserList(weixinUser);
        ExcelUtil<WeixinUser> util = new ExcelUtil<WeixinUser>(WeixinUser.class);
        return util.exportExcel(list, "weixinuser");
    }

    /**
     * 新增微信用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信用户
     */
    @RequiresPermissions("mbkj:weixinuser:add")
    @Log(title = "微信用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WeixinUser weixinUser)
    {
        return toAjax(weixinUserService.insertWeixinUser(weixinUser));
    }

    /**
     * 修改微信用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WeixinUser weixinUser = weixinUserService.selectWeixinUserById(id);
        mmap.put("weixinUser", weixinUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信用户
     */
    @RequiresPermissions("mbkj:weixinuser:edit")
    @Log(title = "微信用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WeixinUser weixinUser)
    {
        return toAjax(weixinUserService.updateWeixinUser(weixinUser));
    }

    /**
     * 删除微信用户
     */
    @RequiresPermissions("mbkj:weixinuser:remove")
    @Log(title = "微信用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(weixinUserService.deleteWeixinUserByIds(ids));
    }
}
