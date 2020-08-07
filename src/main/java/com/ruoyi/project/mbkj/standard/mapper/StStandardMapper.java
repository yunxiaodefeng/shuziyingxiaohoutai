package com.ruoyi.project.mbkj.standard.mapper;

import java.util.List;
import com.ruoyi.project.mbkj.standard.domain.StStandard;

/**
 * 录入业绩类型信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-07
 */
public interface StStandardMapper 
{
    /**
     * 查询录入业绩类型信息
     * 
     * @param id 录入业绩类型信息ID
     * @return 录入业绩类型信息
     */
    public StStandard selectStStandardById(Long id);

    /**
     * 查询录入业绩类型信息列表
     * 
     * @param stStandard 录入业绩类型信息
     * @return 录入业绩类型信息集合
     */
    public List<StStandard> selectStStandardList(StStandard stStandard);

    /**
     * 新增录入业绩类型信息
     * 
     * @param stStandard 录入业绩类型信息
     * @return 结果
     */
    public int insertStStandard(StStandard stStandard);

    /**
     * 修改录入业绩类型信息
     * 
     * @param stStandard 录入业绩类型信息
     * @return 结果
     */
    public int updateStStandard(StStandard stStandard);

    /**
     * 删除录入业绩类型信息
     * 
     * @param id 录入业绩类型信息ID
     * @return 结果
     */
    public int deleteStStandardById(Long id);

    /**
     * 批量删除录入业绩类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStStandardByIds(String[] ids);
}
