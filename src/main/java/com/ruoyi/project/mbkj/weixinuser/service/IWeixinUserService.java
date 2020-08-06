package com.ruoyi.project.mbkj.weixinuser.service;

import java.util.List;
import com.ruoyi.project.mbkj.weixinuser.domain.WeixinUser;

/**
 * 微信用户Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public interface IWeixinUserService 
{
    /**
     * 查询微信用户
     * 
     * @param id 微信用户ID
     * @return 微信用户
     */
    public WeixinUser selectWeixinUserById(Long id);

    /**
     * 查询微信用户列表
     * 
     * @param weixinUser 微信用户
     * @return 微信用户集合
     */
    public List<WeixinUser> selectWeixinUserList(WeixinUser weixinUser);

    /**
     * 新增微信用户
     * 
     * @param weixinUser 微信用户
     * @return 结果
     */
    public int insertWeixinUser(WeixinUser weixinUser);

    /**
     * 修改微信用户
     * 
     * @param weixinUser 微信用户
     * @return 结果
     */
    public int updateWeixinUser(WeixinUser weixinUser);

    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeixinUserByIds(String ids);

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户ID
     * @return 结果
     */
    public int deleteWeixinUserById(Long id);
}
