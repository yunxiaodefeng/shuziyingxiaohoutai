package com.ruoyi.project.mbkj.systemDic.service;

import java.util.List;
import com.ruoyi.project.mbkj.systemDic.domain.SystemDic;

/**
 * 客户标签信息基础表Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public interface ISystemDicService 
{
    /**
     * 查询客户标签信息基础表
     * 
     * @param id 客户标签信息基础表ID
     * @return 客户标签信息基础表
     */
    public SystemDic selectSystemDicById(Long id);

    /**
     * 查询客户标签信息基础表列表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 客户标签信息基础表集合
     */
    public List<SystemDic> selectSystemDicList(SystemDic systemDic);

    /**
     * 新增客户标签信息基础表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 结果
     */
    public int insertSystemDic(SystemDic systemDic);

    /**
     * 修改客户标签信息基础表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 结果
     */
    public int updateSystemDic(SystemDic systemDic);

    /**
     * 批量删除客户标签信息基础表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemDicByIds(String ids);

    /**
     * 删除客户标签信息基础表信息
     * 
     * @param id 客户标签信息基础表ID
     * @return 结果
     */
    public int deleteSystemDicById(Long id);
}
