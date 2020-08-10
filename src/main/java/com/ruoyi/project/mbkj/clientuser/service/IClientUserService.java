package com.ruoyi.project.mbkj.clientuser.service;

import com.ruoyi.project.mbkj.clientuser.domain.ClientUser;
import com.ruoyi.project.mbkj.clientuser.domain.UserDetail;

import java.util.List;

/**
 * 用户信息Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public interface IClientUserService 
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
     * @param clientUser 用户信息
     * @param pageNum
     * @param pageSize
     * @param bycolumn
     * @param byAsc
     * @param userLevel
     * @param sear @return 用户信息集合
     * @param searMoreCheck      */
    public List<ClientUser> getclientUserList(ClientUser clientUser, Integer pageNum, Integer pageSize, String bycolumn, String byAsc, StringBuffer userLevel, String sear, String searMoreCheck);

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
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClientUserByIds(String ids);

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    public int deleteClientUserById(Long id);

    List<UserDetail> selectUserDetail(Long id);

    Integer selectClientUserListcountNum(ClientUser clientUser, Integer num, Integer size, String bycolumn, String byAsc, StringBuffer userLevel, String sear, String searMoreCheck);

    List<ClientUser> getAll(String nickname, Integer num, Integer size);
}
