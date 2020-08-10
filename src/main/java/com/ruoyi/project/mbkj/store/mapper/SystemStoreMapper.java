package com.ruoyi.project.mbkj.store.mapper;

import com.ruoyi.project.mbkj.store.domain.SystemStore;

import java.util.List;
import java.util.Map;

/**
 * 网点Mapper接口
 * 
 * @author LJP
 * @date 2020-08-06
 */
public interface SystemStoreMapper 
{
    /**
     * 查询网点
     * 
     * @param id 网点ID
     * @return 网点
     */
    public SystemStore selectSystemStoreById(Long id);

    /**
     * 查询网点列表
     * 
     * @param systemStore 网点
     * @return 网点集合
     */
    public List<SystemStore> selectSystemStoreList(SystemStore systemStore);

    /**
     * 新增网点
     * 
     * @param systemStore 网点
     * @return 结果
     */
    public int insertSystemStore(SystemStore systemStore);

    /**
     * 修改网点
     * 
     * @param systemStore 网点
     * @return 结果
     */
    public int updateSystemStore(SystemStore systemStore);

    /**
     * 删除网点
     * 
     * @param id 网点ID
     * @return 结果
     */
    public int deleteSystemStoreById(Long id);

    /**
     * 批量删除网点
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemStoreByIds(String[] ids);

    List<Map> selectIsAllStore(Map<String, Object> map);
}
