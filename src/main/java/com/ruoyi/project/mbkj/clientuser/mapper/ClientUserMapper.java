package com.ruoyi.project.mbkj.clientuser.mapper;

import com.ruoyi.project.mbkj.clientuser.domain.ClientUser;
import com.ruoyi.project.mbkj.clientuser.domain.UserDetail;

import java.util.List;
import java.util.Map;

/**
 * 用户信息Mapper接口
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public interface ClientUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    public ClientUser selectClientUserById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param clientUser 用户信息
     * @return 用户信息集合
     */
    public List<ClientUser> getclientUserList(Map<String,Object> map);

    /**
     * 新增用户信息
     * 
     * @param clientUser 用户信息
     * @return 结果
     */
    public int insertClientUser(ClientUser clientUser);

    /**
     * 修改用户信息
     * 
     * @param clientUser 用户信息
     * @return 结果
     */
    public int updateClientUser(ClientUser clientUser);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    public int deleteClientUserById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClientUserByIds(String[] ids);

    List<Map> selectUserDeail(Map<String, Object> map);

    List<UserDetail> selectUserDetail(Map<String, Object> map);

    Integer selectClientUserListcountNum(Map<String, Object> map);

    List<ClientUser> getAll(Map<String, Object> map);
}
