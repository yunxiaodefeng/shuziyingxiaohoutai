package com.ruoyi.project.mbkj.stusertask.controller;

import com.github.pagehelper.Page;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MathMoney;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mbkj.admin.domain.SysUserAdminBonus;
import com.ruoyi.project.mbkj.admin.service.ISysUserAdminService;
import com.ruoyi.project.mbkj.stusertask.domain.StUserTask;
import com.ruoyi.project.mbkj.stusertask.service.IStUserTaskService;
import com.ruoyi.project.mbkj.usermonthtarget.domain.StUsermonthtarget;
import com.ruoyi.project.mbkj.usermonthtarget.service.IStUsermonthtargetService;
import com.ruoyi.project.mbkj.userparam.domain.SystemUserparam;
import com.ruoyi.project.mbkj.userparam.service.ISystemUserparamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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
    private ISystemUserparamService systemUserparamService;
    @Autowired
    private IStUserTaskService stUserTaskService;
    @Autowired
    private ISysUserAdminService sysUserAdminService;
    @Autowired
    private IStUsermonthtargetService stUsermonthtargetService;
    @RequiresPermissions("mbkj:stusertask:view")
    @GetMapping()
    public String stusertask()
    {
        return prefix + "/stusertask";
    }
    @GetMapping("/check/{id}/{month}")
    public String check(@PathVariable("id") Long id,@PathVariable("month") String month,ModelMap map)
    {
        map.put("id",id);
        map.put("month",month);
        return prefix + "/check";
    }
    /**
     * 查询存储设置的用户绩效列表
     */
    @RequiresPermissions("mbkj:stusertask:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserAdminBonus userAdmin)
    {

        String month="";
        if(com.ruoyi.common.utils.StringUtils.isNotEmpty(userAdmin.getTime())){
            month=userAdmin.getTime();
        }else{
            month= DateUtils.getDateMonth();
        }
        Map lastmap = new HashMap();
//        startPage();

        List<SysUserAdminBonus> list = sysUserAdminService.selectUserList(userAdmin);
        List<Map<String,Object>> resloutlist = new ArrayList<>();
        Map allmap;
        BigDecimal all = new BigDecimal("0");
        for (int i = 0; i < list.size(); i++) {
            allmap= new HashMap();
            SysUserAdminBonus adminBonus = list.get(i);
            SystemUserparam userparam=new SystemUserparam();
            userparam.setMonth(month);
            userparam.setUserid(adminBonus.getId());
            List<SystemUserparam> userparamList = systemUserparamService.selectSystemUserparamList(userparam);
            String paramvalue="1";
            if(userparamList.size()==0){
                allmap.put("paramvalue","1");
            }else {
                paramvalue=userparamList.get(0).getParamvalue();
                allmap.put("paramvalue",paramvalue);
            }
            BigDecimal big = new BigDecimal(paramvalue);//系数
            BigDecimal allcore=   BigDecimal.ZERO;
            Page<Map > p =stUserTaskService.selectList(adminBonus.getId(),userAdmin.getTime(),0);
            allmap.put("id",adminBonus.getId());
            if(p.size()==0){
                allmap.put("type",0);
                allmap.put("total",0);
                allmap.put("totalscore",0);
                allmap.put("username",adminBonus.getUsername());
                resloutlist.add(allmap);
                continue;
            }
            for(Map map:p){//获取录入的指标
                String storestid = map.get("stid")+"";//指标id
                if(!StringUtils.isEmpty(storestid)){
                    StUserTask stUserTask=new StUserTask();
                    stUserTask.setUserid(adminBonus.getId());
                    stUserTask.setStid(Long.valueOf(storestid));
                    stUserTask.setMonth(month);
                    stUserTask.setType("1");
                    List<StUserTask> taskList = stUserTaskService.selectStUserTaskList(stUserTask);
                    if(taskList.size()>0){
                        map.put("targetscore",taskList.get(0).getScore());//目标
                    }
                    StUsermonthtarget su = new StUsermonthtarget();
                    su.setStorestid(Long.valueOf(storestid));
                    su.setUserid(adminBonus.getId());
                    su.setTime(month+"-01"+" 00:00:00");
                    List<StUsermonthtarget> usermonth = stUsermonthtargetService.selectStUsermonthtargetList(su);
                    if(usermonth.size()>0){
                        map.put("mytarget",usermonth.get(0).getMytarget());
                        Object target = map.get("targetscore");//目标数
                        if(null!=target){//如果不是空
                            BigDecimal rate = new BigDecimal(usermonth.get(0).getMytarget()).divide(new BigDecimal(target+""),4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2);
                            BigDecimal scores = rate.multiply(new BigDecimal(map.get("score")+"")).divide(new BigDecimal("100"));
                            map.put("mytargetrate",rate+"%");
                            map.put("myscore",scores);
                            allcore=allcore.add(scores);
                            all=all.add(scores.multiply(big));
                        }
                    }else{
                        map.put("mytarget","0");
                        map.put("mytargetrate","0%");
                    }

                }
            }


            allmap.put("type",1);
            allmap.put("total",allcore.multiply(big));
            allmap.put("totalscore",allcore);
            allmap.put("username",adminBonus.getUsername());

            resloutlist.add(allmap);

        }
        String mathMoney="1000";
        if(Double.valueOf(String.valueOf(all))>0){
            Double div = MathMoney.div(mathMoney, String.valueOf(all));
            for (int i = 0; i < resloutlist.size(); i++) {
                if(String.valueOf(resloutlist.get(i).get("type")).equals("1")){
                    resloutlist.get(i).put("price",div);
                    String mul = MathMoney.mul(String.valueOf(resloutlist.get(i).get("price")), String.valueOf(resloutlist.get(i).get("totalscore")));
                    String allprice = MathMoney.mul(mul, String.valueOf(resloutlist.get(i).get("paramvalue")));
                    resloutlist.get(i).put("totalmoney",Math.round(Double.valueOf(allprice)));
                }else {
                    resloutlist.get(i).put("price",0);
                    resloutlist.get(i).put("totalmoney",0);
                }
            }
        }

        Collections.sort(resloutlist, new Comparator<Map<String, Object>>(){
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 =(String.valueOf(o1.get("totalscore")));//name1是从你list里面拿出来的一个
                String name2= (String.valueOf(o2.get("totalscore"))); //name1是从你list里面拿出来的第二个name
                return name2.compareTo(name1);
            }
        });
        return getDataTableTask(resloutlist, (String.valueOf(all)));
    }


    //获取绩效详情
    @PostMapping("/getBonusDetails/{id}/{month}")
    @ResponseBody
    public TableDataInfo getBonusDetails(SysUserAdminBonus userAdmin,@PathVariable("id") Long id,@PathVariable("month") String month){
        BigDecimal allcore=   BigDecimal.ZERO;
        startPage();
        Page<Map> listMap = stUserTaskService.selectList(id, month, 0);
        if(listMap.size()>0){
            for(Map map:listMap){
                String storestid = map.get("stid")+"";//指标id
                if(!StringUtils.isEmpty(storestid)){
                    StUserTask score=new StUserTask();
                    score.setUserid(id);
                    score.setMonth(month);
                    score.setStid(Long.valueOf(storestid));
                    score.setType("1");
                    List<StUserTask> list = stUserTaskService.selectStUserTaskList(score);
                    if(list.size()>0){
                        map.put("targetscore",list.get(0).getScore());//目标
                    }
                    StUsermonthtarget su = new StUsermonthtarget();
                    su.setStorestid( Long.valueOf(storestid));
                    su.setUserid(id);
                    su.setTimeT(month);
                    List<StUsermonthtarget> usermonth = stUsermonthtargetService.selectStUsermonthtargetList(su);
                    if(usermonth.size()>0){
                        map.put("mytarget",usermonth.get(0).getMytarget());
                        Object target = map.get("targetscore");//目标数
                        if(null!=target){//如果不是空
                            BigDecimal rate = new BigDecimal(usermonth.get(0).getMytarget()).divide(new BigDecimal(target+""),4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2);
                            BigDecimal scores = rate.multiply(new BigDecimal(map.get("score")+"")).divide(new BigDecimal("100"));
                            map.put("mytargetrate",rate+"%");
                            map.put("myscore",scores);
                            allcore=allcore.add(scores);
                        }
                    }else{
                        map.put("mytarget","0");
                        map.put("mytargetrate","0%");
                    }
                }
            }
        }


        return getDataTableTask(listMap, (String.valueOf(allcore)));
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
