package com.ruoyi.project.mbkj.systemwechatrole.mapper;

import java.util.List;
import com.ruoyi.project.mbkj.systemwechatrole.domain.SystemWechatRole;

/**
 * 小程序角色Mapper接口
 * 
 * @author 云晓得峰
 * @date 2020-08-17
 */
public interface SystemWechatRoleMapper 
{
    /**
     * 查询小程序角色
     * 
     * @param id 小程序角色ID
     * @return 小程序角色
     */
    public SystemWechatRole selectSystemWechatRoleById(Long id);

    /**
     * 查询小程序角色列表
     * 
     * @param systemWechatRole 小程序角色
     * @return 小程序角色集合
     */
    public List<SystemWechatRole> selectSystemWechatRoleList(SystemWechatRole systemWechatRole);

    /**
     * 新增小程序角色
     * 
     * @param systemWechatRole 小程序角色
     * @return 结果
     */
    public int insertSystemWechatRole(SystemWechatRole systemWechatRole);

    /**
     * 修改小程序角色
     * 
     * @param systemWechatRole 小程序角色
     * @return 结果
     */
    public int updateSystemWechatRole(SystemWechatRole systemWechatRole);

    /**
     * 删除小程序角色
     * 
     * @param id 小程序角色ID
     * @return 结果
     */
    public int deleteSystemWechatRoleById(Long id);

    /**
     * 批量删除小程序角色
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemWechatRoleByIds(String[] ids);
}
