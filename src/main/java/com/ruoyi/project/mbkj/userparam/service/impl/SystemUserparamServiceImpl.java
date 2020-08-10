package com.ruoyi.project.mbkj.userparam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.userparam.mapper.SystemUserparamMapper;
import com.ruoyi.project.mbkj.userparam.domain.SystemUserparam;
import com.ruoyi.project.mbkj.userparam.service.ISystemUserparamService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 用户指标系数Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
@Service
public class SystemUserparamServiceImpl implements ISystemUserparamService 
{
    @Autowired
    private SystemUserparamMapper systemUserparamMapper;

    /**
     * 查询用户指标系数
     * 
     * @param id 用户指标系数ID
     * @return 用户指标系数
     */
    @Override
    public SystemUserparam selectSystemUserparamById(Long id)
    {
        return systemUserparamMapper.selectSystemUserparamById(id);
    }

    /**
     * 查询用户指标系数列表
     * 
     * @param systemUserparam 用户指标系数
     * @return 用户指标系数
     */
    @Override
    public List<SystemUserparam> selectSystemUserparamList(SystemUserparam systemUserparam)
    {
        return systemUserparamMapper.selectSystemUserparamList(systemUserparam);
    }

    /**
     * 新增用户指标系数
     * 
     * @param systemUserparam 用户指标系数
     * @return 结果
     */
    @Override
    public int insertSystemUserparam(SystemUserparam systemUserparam)
    {
        return systemUserparamMapper.insertSystemUserparam(systemUserparam);
    }

    /**
     * 修改用户指标系数
     * 
     * @param systemUserparam 用户指标系数
     * @return 结果
     */
    @Override
    public int updateSystemUserparam(SystemUserparam systemUserparam)
    {
        return systemUserparamMapper.updateSystemUserparam(systemUserparam);
    }

    /**
     * 删除用户指标系数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemUserparamByIds(String ids)
    {
        return systemUserparamMapper.deleteSystemUserparamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户指标系数信息
     * 
     * @param id 用户指标系数ID
     * @return 结果
     */
    @Override
    public int deleteSystemUserparamById(Long id)
    {
        return systemUserparamMapper.deleteSystemUserparamById(id);
    }
}
