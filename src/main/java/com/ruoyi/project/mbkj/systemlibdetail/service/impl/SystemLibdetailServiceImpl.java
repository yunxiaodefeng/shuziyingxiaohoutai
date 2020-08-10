package com.ruoyi.project.mbkj.systemlibdetail.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.systemlibdetail.mapper.SystemLibdetailMapper;
import com.ruoyi.project.mbkj.systemlibdetail.domain.SystemLibdetail;
import com.ruoyi.project.mbkj.systemlibdetail.service.ISystemLibdetailService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 客户标签信息详情Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Service
public class SystemLibdetailServiceImpl implements ISystemLibdetailService 
{
    @Autowired
    private SystemLibdetailMapper systemLibdetailMapper;

    /**
     * 查询客户标签信息详情
     * 
     * @param id 客户标签信息详情ID
     * @return 客户标签信息详情
     */
    @Override
    public SystemLibdetail selectSystemLibdetailById(Long id)
    {
        return systemLibdetailMapper.selectSystemLibdetailById(id);
    }

    /**
     * 查询客户标签信息详情列表
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 客户标签信息详情
     */
    @Override
    public List<SystemLibdetail> selectSystemLibdetailList(SystemLibdetail systemLibdetail)
    {
        return systemLibdetailMapper.selectSystemLibdetailList(systemLibdetail);
    }

    /**
     * 新增客户标签信息详情
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 结果
     */
    @Override
    public int insertSystemLibdetail(SystemLibdetail systemLibdetail)
    {
        return systemLibdetailMapper.insertSystemLibdetail(systemLibdetail);
    }

    /**
     * 修改客户标签信息详情
     * 
     * @param systemLibdetail 客户标签信息详情
     * @return 结果
     */
    @Override
    public int updateSystemLibdetail(SystemLibdetail systemLibdetail)
    {
        return systemLibdetailMapper.updateSystemLibdetail(systemLibdetail);
    }

    /**
     * 删除客户标签信息详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemLibdetailByIds(String ids)
    {
        return systemLibdetailMapper.deleteSystemLibdetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户标签信息详情信息
     * 
     * @param id 客户标签信息详情ID
     * @return 结果
     */
    @Override
    public int deleteSystemLibdetailById(Long id)
    {
        return systemLibdetailMapper.deleteSystemLibdetailById(id);
    }
}
