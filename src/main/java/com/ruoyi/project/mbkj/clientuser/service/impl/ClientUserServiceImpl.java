package com.ruoyi.project.mbkj.clientuser.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.mbkj.clientuser.domain.ClientUser;
import com.ruoyi.project.mbkj.clientuser.domain.UserDetail;
import com.ruoyi.project.mbkj.clientuser.mapper.ClientUserMapper;
import com.ruoyi.project.mbkj.clientuser.service.IClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Service
public class ClientUserServiceImpl implements IClientUserService 
{
    @Autowired
    private ClientUserMapper clientUserMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    @Override
    public ClientUser selectClientUserById(Long id)
    {
        return clientUserMapper.selectClientUserById(id);
    }

    /**
     * 查询用户信息列表
     * @param clientUser 用户信息
     * @param pageNum
     * @param pageSize
     * @param bycolumn
     * @param byAsc
     * @param userLevel
     * @param sear @return 用户信息
     * @param searMoreCheck      */
    @Override
    public List<ClientUser> getclientUserList(ClientUser clientUser, Integer pageNum, Integer pageSize, String bycolumn, String byAsc, StringBuffer userLevel, String sear, String searMoreCheck)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("makers",clientUser.getMakers());
        map.put("phone",clientUser.getPhone());
        map.put("name",clientUser.getName());
        map.put("nickname",clientUser.getNickname());
        map.put("storeid",clientUser.getStoreid());
        map.put("num",(pageNum-1)*pageSize);
        map.put("size",pageSize);
        if(StringUtils.isEmpty(bycolumn)){
            map.put("orderByParames","cu.id");
        }else {
            if(bycolumn.equals("gradename")){
                map.put("orderByParames","cu.grade");
            }else {
                map.put("orderByParames","cu.id");
            }
        }
        if(byAsc.equals("asc") || byAsc.equals("desc")){
            map.put("byAsc",byAsc);
        }else {
            map.put("byAsc","asc");
        }
        String[] strings = Convert.toStrArray(sear);
        if(StringUtils.isNotEmpty(sear)){
            map.put("list",Convert.toStrArray(sear));
        }
//        String[] stringsMoreCheck = Convert.toStrArray(searMoreCheck);
//        if(StringUtils.isNotEmpty(searMoreCheck)){
//            map.put("listMoreCheck",Convert.toStrArray(searMoreCheck));
//        }
//        if(StringUtils.isNotEmpty(sear) && StringUtils.isNotEmpty(searMoreCheck)){
//            map.put("showand",1);
//        }
        map.put("userLevel",userLevel.toString());
        return clientUserMapper.getclientUserList(map);
    }

    @Override
    public Integer selectClientUserListcountNum(ClientUser clientUser, Integer num, Integer size, String bycolumn, String byAsc, StringBuffer userLevel, String sear, String searMoreCheck) {
        Map<String,Object> map=new HashMap<>();
        map.put("makers",clientUser.getMakers());
        map.put("phone",clientUser.getPhone());
        map.put("name",clientUser.getName());
        map.put("nickname",clientUser.getNickname());
        map.put("storeid",clientUser.getStoreid());
        if(StringUtils.isEmpty(bycolumn)){
            map.put("orderByParames","cu.id");
        }else {
            if(bycolumn.equals("gradename")){
                map.put("orderByParames","cu.grade");
            }else {
                map.put("orderByParames","cu.id");
            }
        }
        if(byAsc.equals("asc") || byAsc.equals("desc")){
            map.put("byAsc",byAsc);
        }else {
            map.put("byAsc","asc");
        }
        String[] strings = Convert.toStrArray(sear);
        if(StringUtils.isNotEmpty(sear)){
            map.put("list",Convert.toStrArray(sear));
        }
//        String[] stringsMoreCheck = Convert.toStrArray(searMoreCheck);
//        if(StringUtils.isNotEmpty(searMoreCheck)){
//            map.put("listMoreCheck",Convert.toStrArray(searMoreCheck));
//        }
//        if(StringUtils.isNotEmpty(sear) && StringUtils.isNotEmpty(searMoreCheck)){
//            map.put("showand",1);
//        }
        map.put("userLevel",userLevel.toString());
        return clientUserMapper.selectClientUserListcountNum(map);
    }

    @Override
    public List<ClientUser> getAll(String nickname, Integer num, Integer size) {
        Map<String,Object> map=new HashMap<>();
        map.put("num",(num-1)*size);
        map.put("size",size);
        return clientUserMapper.getAll(map);
    }

    /**
     * 新增用户信息
     * 
     * @param clientUser 用户信息
     * @return 结果
     */
    @Override
    public int insertClientUser(ClientUser clientUser)
    {
        return clientUserMapper.insertClientUser(clientUser);
    }

    /**
     * 修改用户信息
     * 
     * @param clientUser 用户信息
     * @return 结果
     */
    @Override
    public int updateClientUser(ClientUser clientUser)
    {
        return clientUserMapper.updateClientUser(clientUser);
    }

    /**
     * 删除用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClientUserByIds(String ids)
    {
        return clientUserMapper.deleteClientUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteClientUserById(Long id)
    {
        return clientUserMapper.deleteClientUserById(id);
    }

    @Override
    public List<UserDetail> selectUserDetail(Long id) {
        Map<String,Object> map=new HashMap();
        map.put("id",id);
        return clientUserMapper.selectUserDetail(map);
    }


}
