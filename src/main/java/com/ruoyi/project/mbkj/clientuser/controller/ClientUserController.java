package com.ruoyi.project.mbkj.clientuser.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.PageDomain;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.page.TableSupport;
import com.ruoyi.project.mbkj.clientuser.domain.ClientUser;
import com.ruoyi.project.mbkj.clientuser.domain.UserDetail;
import com.ruoyi.project.mbkj.clientuser.service.IClientUserService;
import com.ruoyi.project.mbkj.store.domain.SystemStore;
import com.ruoyi.project.mbkj.store.service.ISystemStoreService;
import com.ruoyi.project.mbkj.storelib.service.ISystemStorelibService;
import com.ruoyi.project.mbkj.systemDic.domain.SystemDic;
import com.ruoyi.project.mbkj.systemDic.service.ISystemDicService;
import com.ruoyi.project.mbkj.systemLib.domain.SystemLib;
import com.ruoyi.project.mbkj.systemLib.service.ISystemLibService;
import com.ruoyi.project.mbkj.systemlibdetail.domain.SystemLibdetail;
import com.ruoyi.project.mbkj.systemlibdetail.service.ISystemLibdetailService;
import com.ruoyi.project.mbkj.userdetail.service.IClientUserdetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 用户信息Controller
 *
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Controller
@RequestMapping("/mbkj/clientuser")
public class ClientUserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(ClientUserController.class);
    private String prefix = "mbkj/clientuser";
    @Autowired
    private ISystemStoreService systemStoreService;
    @Autowired
    private IClientUserService clientUserService;

    @Autowired
    private IClientUserdetailService clientUserdetailService;
    @Autowired
    private ISystemLibdetailService systemLibdetailService;
    @Autowired
    private ISystemDicService systemDicService;
    @Autowired
    private ISystemStorelibService systemStorelibService;
    @Autowired
    private ISystemLibService systemLibService;



    @GetMapping("/form/{id}")
    public String showUserDetails(@PathVariable("id") Long id,ModelMap map) {
        List<UserDetail> userDetail=clientUserService.selectUserDetail(id);
        map.put("userDetail",userDetail.get(0));

        SystemLib systemLib = new SystemLib();
        systemLib.setStatus("1");
        List<Map> slib = systemLibService.selectSystemLibListMap(systemLib);
        for (Map m : slib) {
            String selectid = "";

            m.put("index", "");
            String status = m.get("type") + "";
            if (!"0".equals(status)) {
                SystemLibdetail libdetail=new SystemLibdetail();
                libdetail.setLibid(Long.valueOf(String.valueOf(m.get("id"))));
                List<SystemLibdetail> slibdetil = systemLibdetailService.selectSystemLibdetailList(libdetail);
                List<Map> userdetail =clientUserdetailService.selectUserDatailsList(id,m.get("id"));
                if(userdetail.size()>0){
                    selectid = "," + userdetail.get(0).get("content") + ",";
                }
                for (int i = 0; i < slibdetil.size(); i++) {
                    SystemLibdetail temp = slibdetil.get(i);
                    if (selectid.indexOf("," + temp.getId() + ",") > -1) {
                        if ("1".equals(status)) {//如果是1
                            m.put("index", i);
                        }
                        if ("3".equals(status)) {//如果是1
                            temp.setChecked(true);
                        }
                    }
                }
                m.put("detail", slibdetil);
            }
        }
        map.put("questionlist", slib);
        return prefix + "/form";
    }



    @RequiresPermissions("mbkj:clientuser:view")
    @GetMapping()
    public String clientuser(ModelMap modelMap) {


        SystemLib systemLib = new SystemLib();
        systemLib.setStatus("1");
        startPage();
        List<Map> slib = systemLibService.selectSystemLibListMap(systemLib);
        for (Map m : slib) {
            String selectid = "";

            m.put("index", "");
            String status = m.get("type") + "";
            if (!"0".equals(status)) {
                SystemLibdetail libdetail=new SystemLibdetail();
                libdetail.setLibid(Long.valueOf(String.valueOf(m.get("id"))));
                List<SystemLibdetail> slibdetil = systemLibdetailService.selectSystemLibdetailList(libdetail);
                for (int i = 0; i < slibdetil.size(); i++) {
                    SystemLibdetail temp = slibdetil.get(i);
                    temp.setIdentification("libid-"+String.valueOf(temp.getLibid()));
                    if (selectid.indexOf("," + temp.getId() + ",") > -1) {
                        if ("1".equals(status)) {//如果是1
                            m.put("index", i);
                        }
                        if ("3".equals(status)) {//如果是1
                            temp.setChecked(true);
                        }
                    }
                }
                m.put("detail", slibdetil);
            }
        }
        Map gardemap = new HashMap();
        gardemap.put("libid", "0");
        gardemap.put("name", "等级");
        gardemap.put("type", "2");
        SystemDic systemDic=new SystemDic();
        systemDic.setType("clienttype");
        List<SystemDic> gradewarperlist = systemDicService.selectSystemDicList(systemDic);
        Map detailgrade;
        List deatillis = new ArrayList();
        for (SystemDic sd : gradewarperlist) {
            detailgrade = new HashMap();
            String idm = sd.getKey();
            String title = sd.getValue();
            detailgrade.put("type",1);
            detailgrade.put("identification", "libid-");
            detailgrade.put("id", idm);
            detailgrade.put("title", title);
            deatillis.add(detailgrade);
        }
        gardemap.put("detail", deatillis);
        slib.add(gardemap);

        modelMap.put("questionlist", slib);
        return prefix + "/clientuser";
    }
    /**
     * 查询用户信息列表
     */
    @PostMapping("/all")
    @ResponseBody
    public TableDataInfo exportOne(ClientUser clientUser, HttpServletRequest request) {

        List<Map> mapList=systemStoreService.selectIsAllStore(clientUser);
        if(mapList.size()==0){
            clientUser.setStoreid(null);
        }
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer num = pageDomain.getPageNum();
        Integer size = pageDomain.getPageSize();
        String bycolumn = pageDomain.getOrderByColumn();
        String byAsc = pageDomain.getIsAsc();
        String sear="";
        String searMoreCheck="";
        Enumeration em = request.getParameterNames();
        StringBuffer userLevel=new StringBuffer();
        StringBuffer sb=new StringBuffer();
        StringBuffer sbMoreCheck=new StringBuffer();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            if ("libid-".equals(name)) {
                userLevel.append(value);
            }else  if(name.indexOf("libid-")>-1){
//                if(name.indexOf(",1")>-1){
                    sb.append(value+",");
//                }
//                if(name.indexOf(",3")>-1){
//                     sbMoreCheck.append(value+",");
//                }
            }
        }
        if(sb.toString().lastIndexOf(",")>-1){
            sear=sb.toString().substring(0,sb.toString().lastIndexOf(","));
        }else {
             sear=sb.toString();
        }
//        if(sbMoreCheck.toString().lastIndexOf(",")>-1){
//            searMoreCheck=sbMoreCheck.toString().substring(0,sbMoreCheck.toString().lastIndexOf(","));
//        }else {
//            searMoreCheck=sbMoreCheck.toString();
//        }
        Integer countNum = clientUserService.selectClientUserListcountNum(clientUser,num,size,bycolumn,byAsc,userLevel,sear,searMoreCheck);
        List<ClientUser> list = clientUserService.getclientUserList(clientUser,num,size,bycolumn,byAsc,userLevel,sear,searMoreCheck);
        return getDataTableNew(list,countNum);
//        for (int i = 0; i < list.size(); i++) {
//            ClientUser user = list.get(i);
//            List<Map> mapList = clientUserdetailService.selectmypage(user.getId());
//            StringBuffer sb = new StringBuffer("");
//            for (int j = 0; j < mapList.size(); j++) {
//                Map map = mapList.get(j);
//                String libid = map.get("content") + "";//获取到详情
//                if ("null".equals(libid)) {
//                    continue;
//                }
//                if (StringUtils.isEmpty(libid)) {
//                    continue;
//                }
//                if (libid.indexOf(",") > -1) {
//                    String libs[] = libid.split(",");
//                    for (int k = 0; k < libs.length; k++) {
//                        String lib = libs[k];
//                        SystemLibdetail libdetail = systemLibdetailService.selectSystemLibdetailById(Long.valueOf(lib));
//                        sb.append(libdetail.getTitle() + "、");
//                    }
//                } else {
//                    SystemLibdetail libdetail = systemLibdetailService.selectSystemLibdetailById(Long.valueOf(libid));
//                    if (null == libdetail)
//                        continue;
//                    sb.append(libdetail.getTitle() + "、");
//                }
//            }
//            user.setLablelist(sb.toString());
//        }

    }


    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("mbkj:clientuser:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClientUser clientUser, HttpServletRequest request, HttpServletResponse response)   {
        List<Map> mapList=systemStoreService.selectIsAllStore(clientUser);
        if(mapList.size()==0){
            clientUser.setStoreid(null);
        }
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer num = 1;
        Integer size =100;
        String bycolumn = pageDomain.getOrderByColumn();
        String byAsc = pageDomain.getIsAsc();
        String sear="";
        String searMoreCheck="";
        Enumeration em = request.getParameterNames();
        StringBuffer userLevel=new StringBuffer();
        StringBuffer sb=new StringBuffer();
        StringBuffer sbMoreCheck=new StringBuffer();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            if ("libid-".equals(name)) {
                userLevel.append(value);
            }else  if(name.indexOf("libid-")>-1){
//                if(name.indexOf(",1")>-1){
                    sb.append(value+",");
//                }
//                if(name.indexOf(",3")>-1){
//                    sbMoreCheck.append(value+",");
//                }
            }
        }
        if(sb.toString().lastIndexOf(",")>-1){
            sear=sb.toString().substring(0,sb.toString().lastIndexOf(","));
        }else {
            sear=sb.toString();
        }
//        if(sbMoreCheck.toString().lastIndexOf(",")>-1){
//            searMoreCheck=sbMoreCheck.toString().substring(0,sbMoreCheck.toString().lastIndexOf(","));
//        }else {
//            searMoreCheck=sbMoreCheck.toString();
//        }
        Integer count = clientUserService.selectClientUserListcountNum(clientUser,num,size,bycolumn,byAsc,userLevel,sear,searMoreCheck);
        int pageCount=count%size==0?(count/size):(count/size+1);
        List<ClientUser> listAll =new ArrayList<>();
        for (int index = 1; index <= pageCount; index++){
            List<ClientUser> list = clientUserService.getclientUserList(clientUser,index,size,bycolumn,byAsc,userLevel,sear,searMoreCheck);
            listAll.addAll(list);
        }
        String filename="";
        if(clientUser.getStoreid()!=null){
            SystemStore systemStore = systemStoreService.selectSystemStoreById(clientUser.getStoreid());
            filename=systemStore.getName()+"客户信息";
        }else {
            SystemStore systemStore=new SystemStore();
            systemStore.setPrentid(0l);
            List<SystemStore> storeList = systemStoreService.selectSystemStoreList(systemStore);
            if(storeList.size()==0){
                filename= "客户信息" ;
            }else {
                filename=storeList.get(0).getName()+"客户信息" ;
            }
        }
        ExcelUtil<ClientUser> util = new ExcelUtil<ClientUser>(ClientUser.class);
        return util.exportExcel(listAll, filename);

    }

    public static void main(String[] args) {
        int count =5;//总条数

        int pageSize=100;//每页显示10条

        int pageCount=count%pageSize==0?(count/pageSize):(count/pageSize+1);//总页数
        System.out.println(pageCount);
        System.out.println(Math.ceil(count / 100));
    }


    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("mbkj:clientuser:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClientUser clientUser) {
        return  null;
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ClientUser clientUser = clientUserService.selectClientUserById(id);
        mmap.put("clientUser", clientUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("mbkj:clientuser:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClientUser clientUser) {
        return  null;
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("mbkj:clientuser:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return  null;
    }
}
