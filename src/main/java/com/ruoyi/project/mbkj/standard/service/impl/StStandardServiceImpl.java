package com.ruoyi.project.mbkj.standard.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.standard.mapper.StStandardMapper;
import com.ruoyi.project.mbkj.standard.domain.StStandard;
import com.ruoyi.project.mbkj.standard.service.IStStandardService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 录入业绩类型信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-07
 */
@Service
public class StStandardServiceImpl implements IStStandardService 
{
    @Autowired
    private StStandardMapper stStandardMapper;

    /**
     * 查询录入业绩类型信息
     * 
     * @param id 录入业绩类型信息ID
     * @return 录入业绩类型信息
     */
    @Override
    public StStandard selectStStandardById(Long id)
    {
        return stStandardMapper.selectStStandardById(id);
    }

    /**
     * 查询录入业绩类型信息列表
     * 
     * @param stStandard 录入业绩类型信息
     * @return 录入业绩类型信息
     */
    @Override
    public List<StStandard> selectStStandardList(StStandard stStandard)
    {
        return stStandardMapper.selectStStandardList(stStandard);
    }

    /**
     * 新增录入业绩类型信息
     * 
     * @param stStandard 录入业绩类型信息
     * @return 结果
     */
    @Override
    public int insertStStandard(StStandard stStandard)
    {
        return stStandardMapper.insertStStandard(stStandard);
    }

    /**
     * 修改录入业绩类型信息
     * 
     * @param stStandard 录入业绩类型信息
     * @return 结果
     */
    @Override
    public int updateStStandard(StStandard stStandard)
    {
        return stStandardMapper.updateStStandard(stStandard);
    }

    /**
     * 删除录入业绩类型信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStStandardByIds(String ids)
    {
        return stStandardMapper.deleteStStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除录入业绩类型信息信息
     * 
     * @param id 录入业绩类型信息ID
     * @return 结果
     */
    @Override
    public int deleteStStandardById(Long id)
    {
        return stStandardMapper.deleteStStandardById(id);
    }
}
