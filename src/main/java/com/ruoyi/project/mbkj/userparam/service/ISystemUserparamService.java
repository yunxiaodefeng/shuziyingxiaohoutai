package com.ruoyi.project.mbkj.userparam.service;

import java.util.List;
import com.ruoyi.project.mbkj.userparam.domain.SystemUserparam;

/**
 * 用户指标系数Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
public interface ISystemUserparamService 
{
    /**
     * 查询用户指标系数
     * 
     * @param id 用户指标系数ID
     * @return 用户指标系数
     */
    public SystemUserparam selectSystemUserparamById(Long id);

    /**
     * 查询用户指标系数列表
     * 
     * @param systemUserparam 用户指标系数
     * @return 用户指标系数集合
     */
    public List<SystemUserparam> selectSystemUserparamList(SystemUserparam systemUserparam);

    /**
     * 新增用户指标系数
     * 
     * @param systemUserparam 用户指标系数
     * @return 结果
     */
    public int insertSystemUserparam(SystemUserparam systemUserparam);

    /**
     * 修改用户指标系数
     * 
     * @param systemUserparam 用户指标系数
     * @return 结果
     */
    public int updateSystemUserparam(SystemUserparam systemUserparam);

    /**
     * 批量删除用户指标系数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemUserparamByIds(String ids);

    /**
     * 删除用户指标系数信息
     * 
     * @param id 用户指标系数ID
     * @return 结果
     */
    public int deleteSystemUserparamById(Long id);
}
