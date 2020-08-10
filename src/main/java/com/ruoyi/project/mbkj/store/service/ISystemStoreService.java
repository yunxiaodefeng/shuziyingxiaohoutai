package com.ruoyi.project.mbkj.store.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.mbkj.clientuser.domain.ClientUser;
import com.ruoyi.project.mbkj.store.domain.SystemStore;
import com.ruoyi.project.system.dept.domain.Dept;

/**
 * 网点Service接口
 * 
 * @author LJP
 * @date 2020-08-06
 */
public interface ISystemStoreService 
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
     * 批量删除网点
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemStoreByIds(String ids);

    /**
     * 删除网点信息
     * 
     * @param id 网点ID
     * @return 结果
     */
    public int deleteSystemStoreById(Long id);
    
    /**
     * 查询部门管理树
     * 
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectStoreTree(SystemStore systemStore);

    List<Map> selectIsAllStore(ClientUser clientUser);
}
