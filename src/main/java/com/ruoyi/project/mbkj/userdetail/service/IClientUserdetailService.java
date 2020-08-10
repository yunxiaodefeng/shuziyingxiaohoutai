package com.ruoyi.project.mbkj.userdetail.service;

import com.ruoyi.project.mbkj.userdetail.domain.ClientUserdetail;

import java.util.List;
import java.util.Map;

/**
 * 客户标签信息详情中间表Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public interface IClientUserdetailService 
{
    /**
     * 查询客户标签信息详情中间表
     * 
     * @param id 客户标签信息详情中间表ID
     * @return 客户标签信息详情中间表
     */
    public ClientUserdetail selectClientUserdetailById(Long id);

    /**
     * 查询客户标签信息详情中间表列表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 客户标签信息详情中间表集合
     */
    public List<ClientUserdetail> selectClientUserdetailList(ClientUserdetail clientUserdetail);

    /**
     * 新增客户标签信息详情中间表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 结果
     */
    public int insertClientUserdetail(ClientUserdetail clientUserdetail);

    /**
     * 修改客户标签信息详情中间表
     * 
     * @param clientUserdetail 客户标签信息详情中间表
     * @return 结果
     */
    public int updateClientUserdetail(ClientUserdetail clientUserdetail);

    /**
     * 批量删除客户标签信息详情中间表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClientUserdetailByIds(String ids);

    /**
     * 删除客户标签信息详情中间表信息
     * 
     * @param id 客户标签信息详情中间表ID
     * @return 结果
     */
    public int deleteClientUserdetailById(Long id);

    List<Map> selectmypage(Long id);

    List<Map> selectUserDatailsList(Long id, Object id1);
}
