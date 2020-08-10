package com.ruoyi.project.mbkj.usermonthtarget.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mbkj.admin.domain.SysUserAdmin;
import com.ruoyi.project.mbkj.admin.service.ISysUserAdminService;
import com.ruoyi.project.mbkj.store.domain.SystemStore;
import com.ruoyi.project.mbkj.store.service.ISystemStoreService;
import com.ruoyi.project.mbkj.usermonthtarget.domain.StUsermonthtarget;
import com.ruoyi.project.mbkj.usermonthtarget.service.IStUsermonthtargetService;
import com.ruoyi.project.ro.SelectTargetParam;
import com.ruoyi.project.vo.OtherTargetResult;
import com.ruoyi.project.vo.TargetResult;

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
    @Autowired
    private ISystemStoreService systemStoreService;
    @Autowired
    private ISysUserAdminService sysUserAdminService;

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
    
    /**
     * 删除数据统计
     */
  

    @PostMapping( "/selectStoretarget")
    @ResponseBody
    public AjaxResult selectStoretarget(HttpServletRequest request){
    	
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	
    	
    	SelectTargetParam selectTargetParam = new SelectTargetParam();
    	
    	if(startTime == null || endTime == null ){
        	selectTargetParam.setStartTime(new Date());
        	selectTargetParam.setEndTime(new Date());
    	}else{
    		selectTargetParam.setStartTime(DateUtils.dateTime("yyyy-MM-dd", startTime));
        	selectTargetParam.setEndTime(DateUtils.dateTime("yyyy-MM-dd", endTime));
    	}
    	
    	String result = "";
    	
    	SystemStore systemStore1 = new SystemStore();
    	systemStore1.setStatus("1");
    	
    	
    	List<SystemStore> list = systemStoreService.selectSystemStoreList(systemStore1);
    	
    	for (SystemStore systemStore : list) {
    		selectTargetParam.setStoreid(systemStore.getId()+"");
    		
    		TargetResult targetResult = stUsermonthtargetService.select5target(selectTargetParam);
    		
    		result = result +"<tr>";
        	
        	result = result +"<td >"+targetResult.getStoreName()+ "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getGongxian()).stripTrailingZeros().toPlainString() + "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getLuruxinxi()).stripTrailingZeros().toPlainString()+ "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getWanshanxinxi()).stripTrailingZeros().toPlainString()+"</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getWeihuxixni()).stripTrailingZeros().toPlainString() + "</td>";
        	result = result +"<td style='text-align:center' >"+new BigDecimal(targetResult.getGenjinkehu()).stripTrailingZeros().toPlainString()+ "</td>";
        	
        	List<OtherTargetResult>  otherTargetResultList = stUsermonthtargetService.selectOthertarget(selectTargetParam);
        	
        	for (OtherTargetResult otherTargetResult : otherTargetResultList) {
    			
        		result = result +"<td style='text-align:center'>"+new BigDecimal( otherTargetResult.getAlltotal()).stripTrailingZeros().toPlainString()+ "</td>";
    		}
        	result = result +"</tr>";
        	
		}
    	
    	System.out.println(result);
    	
        return AjaxResult.success("查询结果",result);
    }
    
    @PostMapping( "/selectUsertarget")
    @ResponseBody
    public AjaxResult selectUsertarget(HttpServletRequest request){
    	
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	
    	String storeId = request.getParameter("storeId");
    	
    	SelectTargetParam selectTargetParam = new SelectTargetParam();
    	
    	if(startTime == null || endTime == null ){
        	selectTargetParam.setStartTime(new Date());
        	selectTargetParam.setEndTime(new Date());
    	}else{
    		selectTargetParam.setStartTime(DateUtils.dateTime("yyyy-MM-dd", startTime));
        	selectTargetParam.setEndTime(DateUtils.dateTime("yyyy-MM-dd", endTime));
    	}
    	
    	selectTargetParam.setStoreid(storeId);
    	String result = "";
    	
    	SysUserAdmin sysUserAdmin1 = new SysUserAdmin();
    	sysUserAdmin1.setStatus("1");
    	sysUserAdmin1.setStoreid(storeId);
    	List<SysUserAdmin> list = sysUserAdminService.selectSysUserAdminList(sysUserAdmin1);
    	
    	for (SysUserAdmin sysUserAdmin : list) {
    		selectTargetParam.setStoreid(sysUserAdmin.getId()+"");
    		
    		TargetResult targetResult = stUsermonthtargetService.selectUser5target(selectTargetParam);
    		
    		result = result +"<tr>";
        	
        	result = result +"<td >"+targetResult.getStoreName()+ "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getGongxian()).stripTrailingZeros().toPlainString() + "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getLuruxinxi()).stripTrailingZeros().toPlainString()+ "</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getWanshanxinxi()).stripTrailingZeros().toPlainString()+"</td>";
        	result = result +"<td style='text-align:center'>"+new BigDecimal(targetResult.getWeihuxixni()).stripTrailingZeros().toPlainString() + "</td>";
        	result = result +"<td style='text-align:center' >"+new BigDecimal(targetResult.getGenjinkehu()).stripTrailingZeros().toPlainString()+ "</td>";
        	
        	List<OtherTargetResult>  otherTargetResultList = stUsermonthtargetService.selectUserOthertarget(selectTargetParam);
        	
        	for (OtherTargetResult otherTargetResult : otherTargetResultList) {
    			
        		result = result +"<td style='text-align:center'>"+new BigDecimal( otherTargetResult.getAlltotal()).stripTrailingZeros().toPlainString()+ "</td>";
    		}
        	result = result +"</tr>";
        	
		}
    	
    	System.out.println(result);
    	
        return AjaxResult.success("查询结果",result);
    }
    
 
    
    
    
    
}
