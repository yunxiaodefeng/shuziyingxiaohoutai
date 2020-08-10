package com.ruoyi.project.mbkj.storelib.mapper;

import java.util.List;
import com.ruoyi.project.mbkj.storelib.domain.SystemStorelib;

/**
 * 网点指标详情Mapper接口
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
public interface SystemStorelibMapper 
{
    /**
     * 查询网点指标详情
     * 
     * @param id 网点指标详情ID
     * @return 网点指标详情
     */
    public SystemStorelib selectSystemStorelibById(Long id);

    /**
     * 查询网点指标详情列表
     * 
     * @param systemStorelib 网点指标详情
     * @return 网点指标详情集合
     */
    public List<SystemStorelib> selectSystemStorelibList(SystemStorelib systemStorelib);

    /**
     * 新增网点指标详情
     * 
     * @param systemStorelib 网点指标详情
     * @return 结果
     */
    public int insertSystemStorelib(SystemStorelib systemStorelib);

    /**
     * 修改网点指标详情
     * 
     * @param systemStorelib 网点指标详情
     * @return 结果
     */
    public int updateSystemStorelib(SystemStorelib systemStorelib);

    /**
     * 删除网点指标详情
     * 
     * @param id 网点指标详情ID
     * @return 结果
     */
    public int deleteSystemStorelibById(Long id);

    /**
     * 批量删除网点指标详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemStorelibByIds(String[] ids);
}
