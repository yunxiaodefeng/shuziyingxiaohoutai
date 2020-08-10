package com.ruoyi.project.mbkj.systemlibdetail.service;

import java.util.List;
import com.ruoyi.project.mbkj.systemlibdetail.domain.SystemLibdetail;

/**
 * 客户标签信息详情Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public interface ISystemLibdetailService 
{
    /**
     * 查询客户标签信息详情
     * 
     * @param id 客户标签信息详情ID
     * @return 客户标签信息详情
     */
    public SystemLibdetail selectSystemLibdetailById(Long id);

    /**
     * 查询客户标签信息详情列表
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 客户标签信息详情集合
     */
    public List<SystemLibdetail> selectSystemLibdetailList(SystemLibdetail systemLibdetail);

    /**
     * 新增客户标签信息详情
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 结果
     */
    public int insertSystemLibdetail(SystemLibdetail systemLibdetail);

    /**
     * 修改客户标签信息详情
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 结果
     */
    public int updateSystemLibdetail(SystemLibdetail systemLibdetail);

    /**
     * 批量删除客户标签信息详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemLibdetailByIds(String ids);

    /**
     * 删除客户标签信息详情信息
     * 
     * @param id 客户标签信息详情ID
     * @return 结果
     */
    public int deleteSystemLibdetailById(Long id);
}
