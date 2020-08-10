package com.ruoyi.project.mbkj.userdetail.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.mbkj.userdetail.domain.ClientUserdetail;
import com.ruoyi.project.mbkj.userdetail.mapper.ClientUserdetailMapper;
import com.ruoyi.project.mbkj.userdetail.service.IClientUserdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户标签信息详情中间表Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Service
public class ClientUserdetailServiceImpl implements IClientUserdetailService 
{
    @Autowired
    private ClientUserdetailMapper clientUserdetailMapper;

    /**
     * 查询客户标签信息详情中间表
     * 
     * @param id 客户标签信息详情中间表ID
     * @return 客户标签信息详情中间表
     */
    @Override
    public ClientUserdetail selectClientUserdetailById(Long id)
    {
        return clientUserdetailMapper.selectClientUserdetailById(id);
    }

    /**
     * 查询客户标签信息详情中间表列表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 客户标签信息详情中间表
     */
    @Override
    public List<ClientUserdetail> selectClientUserdetailList(ClientUserdetail clientUserdetail)
    {
        return clientUserdetailMapper.selectClientUserdetailList(clientUserdetail);
    }

    /**
     * 新增客户标签信息详情中间表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 结果
     */
    @Override
    public int insertClientUserdetail(ClientUserdetail clientUserdetail)
    {
        return clientUserdetailMapper.insertClientUserdetail(clientUserdetail);
    }

    /**
     * 修改客户标签信息详情中间表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 结果
     */
    @Override
    public int updateClientUserdetail(ClientUserdetail clientUserdetail)
    {
        return clientUserdetailMapper.updateClientUserdetail(clientUserdetail);
    }

    /**
     * 删除客户标签信息详情中间表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClientUserdetailByIds(String ids)
    {
        return clientUserdetailMapper.deleteClientUserdetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户标签信息详情中间表信息
     * 
     * @param id 客户标签信息详情中间表ID
     * @return 结果
     */
    @Override
    public int deleteClientUserdetailById(Long id)
    {
        return clientUserdetailMapper.deleteClientUserdetailById(id);
    }

    @Override
    public List<Map> selectmypage(Long id) {
        Map<String,Object> map=new HashMap();
        map.put("id",id);
        return clientUserdetailMapper.selectmypage(map);
    }

    @Override
    public List<Map> selectUserDatailsList(Long id, Object libid) {
        Map<String,Object> map=new HashMap();
        map.put("clientid",id);
        map.put("libid",libid);
        return clientUserdetailMapper.selectUserDatailsList(map);
    }
}
