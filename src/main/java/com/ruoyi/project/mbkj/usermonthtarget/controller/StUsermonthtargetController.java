package com.ruoyi.project.mbkj.usermonthtarget.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mbkj.admin.domain.SysUserAdmin;
import com.ruoyi.project.mbkj.admin.service.ISysUserAdminService;
import com.ruoyi.project.mbkj.standard.domain.StStandard;
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
    @GetMapping("/export1/{startTime1}/{endTime1}")
    public void  export(@PathVariable("startTime1") String startTime1,@PathVariable("endTime1") String endTime1, HttpServletRequest request,HttpServletResponse response)
    {
    	
    	 
    	
    	List<StStandard> stStandardList =  stUsermonthtargetService.selectStanderList();
    	
    	String headerArray = "名称,贡献,新建信息,完善信息,计划维护,跟进客户,";
    	
    	for (StStandard stStandard : stStandardList) {
    		headerArray = headerArray + stStandard.getName()+",";
		}
    	
    	// 拼接 excle 表头信息
    	String[] headerItem =  headerArray.split(",");
    	
    	// 拼接 excle 数据信息
    	
    	List<String> bodyItems = new ArrayList<String>();
    	SelectTargetParam selectTargetParam = new SelectTargetParam();
    	
    	if(startTime1 == null || endTime1 == null ){
        	selectTargetParam.setStartTime(new Date());
        	selectTargetParam.setEndTime(new Date());
    	}else{
    		selectTargetParam.setStartTime(DateUtils.dateTime("yyyy-MM-dd", startTime1));
        	selectTargetParam.setEndTime(DateUtils.dateTime("yyyy-MM-dd", endTime1));
    	}
    	
    	SystemStore systemStore1 = new SystemStore();
    	systemStore1.setStatus("1");
    	
    	 List<SystemStore> list = systemStoreService.selectSystemStoreList(systemStore1);
    	
    	for (SystemStore systemStore : list) {
    		
    		selectTargetParam.setStoreid(systemStore.getId()+"");
    		
    		TargetResult targetResult = stUsermonthtargetService.select5target(selectTargetParam);
    		
    		String result = "";
    		
        	result = result +targetResult.getStoreName()+ ",";
        	result = result +new BigDecimal(targetResult.getGongxian()).stripTrailingZeros().toPlainString() + ",";
        	result = result +new BigDecimal(targetResult.getLuruxinxi()).stripTrailingZeros().toPlainString()+ ",";
        	result = result +new BigDecimal(targetResult.getWanshanxinxi()).stripTrailingZeros().toPlainString()+",";
        	result = result +new BigDecimal(targetResult.getWeihuxixni()).stripTrailingZeros().toPlainString() + ",";
        	result = result +new BigDecimal(targetResult.getGenjinkehu()).stripTrailingZeros().toPlainString()+ ",";
        	
        	List<OtherTargetResult>  otherTargetResultList = stUsermonthtargetService.selectOthertarget(selectTargetParam);
        	
        	for (OtherTargetResult otherTargetResult : otherTargetResultList) {
    			
        		result = result +new BigDecimal( otherTargetResult.getAlltotal()).stripTrailingZeros().toPlainString()+ ",";
    		}
        	
        	bodyItems.add(result);
		}
    	
    	  //声明一个工作簿
	        XSSFWorkbook workbook = new XSSFWorkbook();
	
	        XSSFSheet sheet = workbook.createSheet("业绩统计");
	
	        //设置表格列宽度为10个字节
	        sheet.setDefaultColumnWidth(10);
	
	        //创建第一行表头
	        XSSFRow headrow = sheet.createRow(0);
	        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
	        for (int i = 0; i < headerItem.length; i++) {
	            //创建一个单元格
	            XSSFCell cell = headrow.createCell(i);

	            //将内容对象的文字内容写入到单元格中
	            cell.setCellValue(headerItem[i]);
	        }
	         
//	         //模拟遍历结果集，把内容加入表格
//	         //模拟遍历第一个学生
//	       
	        for(int j = 0; j<bodyItems.size();j++){
	        	String temp = bodyItems.get(j);
	       
	        	String[] bodyItem = temp.split(",");
	        	XSSFRow row = sheet.createRow(j+1);
		         for (int i = 0; i < bodyItem.length; i++) {
		        	 XSSFCell cell = row.createCell(i);
		             cell.setCellValue(bodyItem[i]);
		         }
				
			}
	        
	        OutputStream out = null;
	        try {
	        	out =  response.getOutputStream();
	        	
	        	 String fileName = URLEncoder.encode("\"网点业绩管理\"", "UTF-8")+"-" + String.valueOf(System.currentTimeMillis()).substring(4, 13)+".xls"  ;
	   	        String headStr = "attachment; filename=\"" + fileName + "\"";
	   	        
	   	        
   	        	response.setContentType("application/vnd.ms-excel");
	        	response.addHeader("Content-Disposition", "attachment;filename="+fileName);
	        	
	   	      
	        	 out = new FileOutputStream(fileName);
	             workbook.write((response.getOutputStream()));
	             out.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
	                    workbook.close();
	                } catch (Exception e) {
	                  
	                }
			}
	        
	       
    }
    
    /**
     * 导出数据统计列表
     */
    @RequiresPermissions("mbkj:usermonthtarget:export")
    @Log(title = "数据统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export2/{startTime1}/{endTime1}/{storeid}")
    public void  export2(@PathVariable("startTime1") String startTime1,@PathVariable("endTime1") String endTime1,@PathVariable("storeid") String storeId, HttpServletRequest request,HttpServletResponse response)
    {
    	
    	 
    	
    	List<StStandard> stStandardList =  stUsermonthtargetService.selectStanderList();
    	
    	String headerArray = "名称,贡献,新建信息,完善信息,计划维护,跟进客户,";
    	
    	for (StStandard stStandard : stStandardList) {
    		headerArray = headerArray + stStandard.getName()+",";
		}
    	
    	// 拼接 excle 表头信息
    	String[] headerItem =  headerArray.split(",");
    	
    	// 拼接 excle 数据信息
    	
    	List<String> bodyItems = new ArrayList<String>();
    	SelectTargetParam selectTargetParam = new SelectTargetParam();
    	
    	if(startTime1 == null || endTime1 == null ){
        	selectTargetParam.setStartTime(new Date());
        	selectTargetParam.setEndTime(new Date());
    	}else{
    		selectTargetParam.setStartTime(DateUtils.dateTime("yyyy-MM-dd", startTime1));
        	selectTargetParam.setEndTime(DateUtils.dateTime("yyyy-MM-dd", endTime1));
    	}
    	
    	selectTargetParam.setStoreid(storeId);
    	
    	SysUserAdmin sysUserAdmin1 = new SysUserAdmin();
    	sysUserAdmin1.setStatus("1");
    	sysUserAdmin1.setStoreid(storeId);
    	List<SysUserAdmin> list = sysUserAdminService.selectSysUserAdminList(sysUserAdmin1);
    	
    	for (SysUserAdmin sysUserAdmin : list) {
    		
    		selectTargetParam.setStoreid(sysUserAdmin.getId()+"");
    		
    		TargetResult targetResult = stUsermonthtargetService.selectUser5target(selectTargetParam);
    		
    		String result = "";
    		
        	result = result +targetResult.getStoreName()+ ",";
        	result = result +new BigDecimal(targetResult.getGongxian()).stripTrailingZeros().toPlainString() + ",";
        	result = result +new BigDecimal(targetResult.getLuruxinxi()).stripTrailingZeros().toPlainString()+ ",";
        	result = result +new BigDecimal(targetResult.getWanshanxinxi()).stripTrailingZeros().toPlainString()+",";
        	result = result +new BigDecimal(targetResult.getWeihuxixni()).stripTrailingZeros().toPlainString() + ",";
        	result = result +new BigDecimal(targetResult.getGenjinkehu()).stripTrailingZeros().toPlainString()+ ",";
        	
        	List<OtherTargetResult>  otherTargetResultList = stUsermonthtargetService.selectUserOthertarget(selectTargetParam);
        	
        	for (OtherTargetResult otherTargetResult : otherTargetResultList) {
    			
        		result = result +new BigDecimal( otherTargetResult.getAlltotal()).stripTrailingZeros().toPlainString()+ ",";
    		}
        	
        	bodyItems.add(result);
		}
    	
    	  //声明一个工作簿
	        XSSFWorkbook workbook = new XSSFWorkbook();
	
	        XSSFSheet sheet = workbook.createSheet("业绩统计");
	
	        //设置表格列宽度为10个字节
	        sheet.setDefaultColumnWidth(10);
	
	        //创建第一行表头
	        XSSFRow headrow = sheet.createRow(0);
	        //遍历添加表头(下面模拟遍历学生，也是同样的操作过程)
	        for (int i = 0; i < headerItem.length; i++) {
	            //创建一个单元格
	            XSSFCell cell = headrow.createCell(i);

	            //将内容对象的文字内容写入到单元格中
	            cell.setCellValue(headerItem[i]);
	        }
	         
//	         //模拟遍历结果集，把内容加入表格
//	         //模拟遍历第一个学生
//	       
	        for(int j = 0; j<bodyItems.size();j++){
	        	String temp = bodyItems.get(j);
	       
	        	String[] bodyItem = temp.split(",");
	        	XSSFRow row = sheet.createRow(j+1);
		         for (int i = 0; i < bodyItem.length; i++) {
		        	 XSSFCell cell = row.createCell(i);
		             cell.setCellValue(bodyItem[i]);
		         }
				
			}
	        
	        OutputStream out = null;
	        try {
	        	out =  response.getOutputStream();
	        	
	        	 String fileName = URLEncoder.encode("\"网点员工业绩管理\"", "UTF-8")+"-" + String.valueOf(System.currentTimeMillis()).substring(4, 13)+".xls"  ;
	   	        String headStr = "attachment; filename=\"" + fileName + "\"";
	   	        
	   	        
   	        	response.setContentType("application/vnd.ms-excel");
	        	response.addHeader("Content-Disposition", "attachment;filename="+fileName);
	        	
	   	      
	        	 out = new FileOutputStream(fileName);
	             workbook.write((response.getOutputStream()));
	             out.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
	                    workbook.close();
	                } catch (Exception e) {
	                  
	                }
			}
	        
	       
    }
    
    /**
     * 编码文件名
     */
    public String encodingFilename(String filename)
    {
        filename =   filename +  "_"+DateUtils.dateTimeNow()+".xlsx";
        return filename;
    }
    
    /**
     * 获取下载路径
     * 
     * @param filename 文件名称
     */
    public String getAbsoluteFile(String filename)
    {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
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
