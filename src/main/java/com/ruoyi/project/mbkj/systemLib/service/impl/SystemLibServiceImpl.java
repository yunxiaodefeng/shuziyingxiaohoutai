package com.ruoyi.project.mbkj.systemLib.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.mbkj.systemLib.domain.SystemLib;
import com.ruoyi.project.mbkj.systemLib.mapper.SystemLibMapper;
import com.ruoyi.project.mbkj.systemLib.service.ISystemLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户标签信息基础Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Service
public class SystemLibServiceImpl implements ISystemLibService 
{
    @Autowired
    private SystemLibMapper systemLibMapper;

    /**
     * 查询客户标签信息基础
     * 
     * @param id 客户标签信息基础ID
     * @return 客户标签信息基础
     */
    @Override
    public SystemLib selectSystemLibById(Long id)
    {
        return systemLibMapper.selectSystemLibById(id);
    }

    /**
     * 查询客户标签信息基础列表
     * 
     * @param systemLib 客户标签信息基础
     * @return 客户标签信息基础
     */
    @Override
    public List<SystemLib> selectSystemLibList(SystemLib systemLib)
    {
        return systemLibMapper.selectSystemLibList(systemLib);
    }

    /**
     * 新增客户标签信息基础
     * 
     * @param systemLib 客户标签信息基础
     * @return 结果
     */
    @Override
    public int insertSystemLib(SystemLib systemLib)
    {
        return systemLibMapper.insertSystemLib(systemLib);
    }

    /**
     * 修改客户标签信息基础
     * 
     * @param systemLib 客户标签信息基础
     * @return 结果
     */
    @Override
    public int updateSystemLib(SystemLib systemLib)
    {
        return systemLibMapper.updateSystemLib(systemLib);
    }

    /**
     * 删除客户标签信息基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemLibByIds(String ids)
    {
        return systemLibMapper.deleteSystemLibByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户标签信息基础信息
     * 
     * @param id 客户标签信息基础ID
     * @return 结果
     */
    @Override
    public int deleteSystemLibById(Long id)
    {
        return systemLibMapper.deleteSystemLibById(id);
    }

    @Override
    public List<Map> selectSystemLibListMap(SystemLib systemLib) {
        return systemLibMapper.selectSystemLibListMap(systemLib);
    }
}
