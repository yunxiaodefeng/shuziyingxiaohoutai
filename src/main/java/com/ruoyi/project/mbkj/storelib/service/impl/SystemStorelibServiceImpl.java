package com.ruoyi.project.mbkj.storelib.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.storelib.mapper.SystemStorelibMapper;
import com.ruoyi.project.mbkj.storelib.domain.SystemStorelib;
import com.ruoyi.project.mbkj.storelib.service.ISystemStorelibService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 网点指标详情Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Service
public class SystemStorelibServiceImpl implements ISystemStorelibService 
{
    @Autowired
    private SystemStorelibMapper systemStorelibMapper;

    /**
     * 查询网点指标详情
     * 
     * @param id 网点指标详情ID
     * @return 网点指标详情
     */
    @Override
    public SystemStorelib selectSystemStorelibById(Long id)
    {
        return systemStorelibMapper.selectSystemStorelibById(id);
    }

    /**
     * 查询网点指标详情列表
     * 
     * @param systemStorelib 网点指标详情
     * @return 网点指标详情
     */
    @Override
    public List<SystemStorelib> selectSystemStorelibList(SystemStorelib systemStorelib)
    {
        return systemStorelibMapper.selectSystemStorelibList(systemStorelib);
    }

    /**
     * 新增网点指标详情
     * 
     * @param systemStorelib 网点指标详情
     * @return 结果
     */
    @Override
    public int insertSystemStorelib(SystemStorelib systemStorelib)
    {
        return systemStorelibMapper.insertSystemStorelib(systemStorelib);
    }

    /**
     * 修改网点指标详情
     * 
     * @param systemStorelib 网点指标详情
     * @return 结果
     */
    @Override
    public int updateSystemStorelib(SystemStorelib systemStorelib)
    {
        return systemStorelibMapper.updateSystemStorelib(systemStorelib);
    }

    /**
     * 删除网点指标详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemStorelibByIds(String ids)
    {
        return systemStorelibMapper.deleteSystemStorelibByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网点指标详情信息
     * 
     * @param id 网点指标详情ID
     * @return 结果
     */
    @Override
    public int deleteSystemStorelibById(Long id)
    {
        return systemStorelibMapper.deleteSystemStorelibById(id);
    }
}
