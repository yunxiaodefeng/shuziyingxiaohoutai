package com.ruoyi.project.mbkj.weixinuser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.weixinuser.mapper.WeixinUserMapper;
import com.ruoyi.project.mbkj.weixinuser.domain.WeixinUser;
import com.ruoyi.project.mbkj.weixinuser.service.IWeixinUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 微信用户Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Service
public class WeixinUserServiceImpl implements IWeixinUserService 
{
    @Autowired
    private WeixinUserMapper weixinUserMapper;

    /**
     * 查询微信用户
     * 
     * @param id 微信用户ID
     * @return 微信用户
     */
    @Override
    public WeixinUser selectWeixinUserById(Long id)
    {
        return weixinUserMapper.selectWeixinUserById(id);
    }

    /**
     * 查询微信用户列表
     * 
     * @param weixinUser 微信用户
     * @return 微信用户
     */
    @Override
    public List<WeixinUser> selectWeixinUserList(WeixinUser weixinUser)
    {
        return weixinUserMapper.selectWeixinUserList(weixinUser);
    }

    /**
     * 新增微信用户
     * 
     * @param weixinUser 微信用户
     * @return 结果
     */
    @Override
    public int insertWeixinUser(WeixinUser weixinUser)
    {
        return weixinUserMapper.insertWeixinUser(weixinUser);
    }

    /**
     * 修改微信用户
     * 
     * @param weixinUser 微信用户
     * @return 结果
     */
    @Override
    public int updateWeixinUser(WeixinUser weixinUser)
    {
        return weixinUserMapper.updateWeixinUser(weixinUser);
    }

    /**
     * 删除微信用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWeixinUserByIds(String ids)
    {
        return weixinUserMapper.deleteWeixinUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户ID
     * @return 结果
     */
    @Override
    public int deleteWeixinUserById(Long id)
    {
        return weixinUserMapper.deleteWeixinUserById(id);
    }
}
