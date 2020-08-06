package com.ruoyi.project.mbkj.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.store.mapper.SystemStoreMapper;
import com.ruoyi.project.mbkj.store.domain.SystemStore;
import com.ruoyi.project.mbkj.store.service.ISystemStoreService;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 网点Service业务层处理
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Service
public class SystemStoreServiceImpl implements ISystemStoreService 
{
    @Autowired
    private SystemStoreMapper systemStoreMapper;

    /**
     * 查询网点
     * 
     * @param id 网点ID
     * @return 网点
     */
    @Override
    public SystemStore selectSystemStoreById(Long id)
    {
        return systemStoreMapper.selectSystemStoreById(id);
    }

    /**
     * 查询网点列表
     * 
     * @param systemStore 网点
     * @return 网点
     */
    @Override
    public List<SystemStore> selectSystemStoreList(SystemStore systemStore)
    {
        return systemStoreMapper.selectSystemStoreList(systemStore);
    }

    /**
     * 新增网点
     * 
     * @param systemStore 网点
     * @return 结果
     */
    @Override
    public int insertSystemStore(SystemStore systemStore)
    {
        return systemStoreMapper.insertSystemStore(systemStore);
    }

    /**
     * 修改网点
     * 
     * @param systemStore 网点
     * @return 结果
     */
    @Override
    public int updateSystemStore(SystemStore systemStore)
    {
        return systemStoreMapper.updateSystemStore(systemStore);
    }

    /**
     * 删除网点对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemStoreByIds(String ids)
    {
        return systemStoreMapper.deleteSystemStoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网点信息
     * 
     * @param id 网点ID
     * @return 结果
     */
    @Override
    public int deleteSystemStoreById(Long id)
    {
        return systemStoreMapper.deleteSystemStoreById(id);
    }
    /**
     * 查询网点管理树
     * 
     * @param store 网点信息
     * @return 所有网点信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectStoreTree(SystemStore systemStore)
    {
        List<SystemStore> storeList = systemStoreMapper.selectSystemStoreList(systemStore);
        List<Ztree> ztrees = initZtree(storeList);
        return ztrees;
    }
    
    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SystemStore> storeList)
    {
        return initZtree(storeList, null);
    }
    
    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SystemStore> storeList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (SystemStore systemStore : storeList)
        {
            if (systemStore.getStatus().equals("1"))
            {
                Ztree ztree = new Ztree();
                ztree.setId(systemStore.getId());
                ztree.setpId(systemStore.getPrentid());
                ztree.setName(systemStore.getName());
              
                if (isCheck)
                {
                   /* ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));*/
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

}
