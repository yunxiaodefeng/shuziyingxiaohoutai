package com.ruoyi.project.mbkj.systemDic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.systemDic.mapper.SystemDicMapper;
import com.ruoyi.project.mbkj.systemDic.domain.SystemDic;
import com.ruoyi.project.mbkj.systemDic.service.ISystemDicService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 客户标签信息基础表Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-07
 */
@Service
public class SystemDicServiceImpl implements ISystemDicService 
{
    @Autowired
    private SystemDicMapper systemDicMapper;

    /**
     * 查询客户标签信息基础表
     * 
     * @param id 客户标签信息基础表ID
     * @return 客户标签信息基础表
     */
    @Override
    public SystemDic selectSystemDicById(Long id)
    {
        return systemDicMapper.selectSystemDicById(id);
    }

    /**
     * 查询客户标签信息基础表列表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 客户标签信息基础表
     */
    @Override
    public List<SystemDic> selectSystemDicList(SystemDic systemDic)
    {
        return systemDicMapper.selectSystemDicList(systemDic);
    }

    /**
     * 新增客户标签信息基础表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 结果
     */
    @Override
    public int insertSystemDic(SystemDic systemDic)
    {
        return systemDicMapper.insertSystemDic(systemDic);
    }

    /**
     * 修改客户标签信息基础表
     * 
     * @param systemDic 客户标签信息基础表
     * @return 结果
     */
    @Override
    public int updateSystemDic(SystemDic systemDic)
    {
        return systemDicMapper.updateSystemDic(systemDic);
    }

    /**
     * 删除客户标签信息基础表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemDicByIds(String ids)
    {
        return systemDicMapper.deleteSystemDicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户标签信息基础表信息
     * 
     * @param id 客户标签信息基础表ID
     * @return 结果
     */
    @Override
    public int deleteSystemDicById(Long id)
    {
        return systemDicMapper.deleteSystemDicById(id);
    }
}
