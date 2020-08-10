package com.ruoyi.project.mbkj.systemLib.mapper;

import com.ruoyi.project.mbkj.systemLib.domain.SystemLib;

import java.util.List;
import java.util.Map;

/**
 * 客户标签信息基础Mapper接口
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public interface SystemLibMapper 
{
    /**
     * 查询客户标签信息基础
     * 
     * @param id 客户标签信息基础ID
     * @return 客户标签信息基础
     */
    public SystemLib selectSystemLibById(Long id);

    /**
     * 查询客户标签信息基础列表
     * 
     * @param systemLib 客户标签信息基础
     * @return 客户标签信息基础集合
     */
    public List<SystemLib> selectSystemLibList(SystemLib systemLib);

    /**
     * 新增客户标签信息基础
     * 
     * @param systemLib 客户标签信息基础
     * @return 结果
     */
    public int insertSystemLib(SystemLib systemLib);

    /**
     * 修改客户标签信息基础
     * 
     * @param systemLib 客户标签信息基础
     * @return 结果
     */
    public int updateSystemLib(SystemLib systemLib);

    /**
     * 删除客户标签信息基础
     * 
     * @param id 客户标签信息基础ID
     * @return 结果
     */
    public int deleteSystemLibById(Long id);

    /**
     * 批量删除客户标签信息基础
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemLibByIds(String[] ids);

    List<Map> selectSystemLibListMap(SystemLib systemLib);
}
