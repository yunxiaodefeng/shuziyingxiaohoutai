package com.ruoyi.project.mbkj.systemtransactionlog.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.mbkj.systemtransactionlog.domain.SystemTransactionLog;
import com.ruoyi.project.mbkj.systemtransactionlog.mapper.SystemTransactionLogMapper;
import com.ruoyi.project.mbkj.systemtransactionlog.service.ISystemTransactionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易记录Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
@Service
public class SystemTransactionLogServiceImpl implements ISystemTransactionLogService 
{
    @Autowired
    private SystemTransactionLogMapper systemTransactionLogMapper;

    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    @Override
    public SystemTransactionLog selectSystemTransactionLogById(Long id)
    {
        return systemTransactionLogMapper.selectSystemTransactionLogById(id);
    }

    /**
     * 查询交易记录列表
     * 
     * @param systemTransactionLog 交易记录
     * @return 交易记录
     */
    @Override
    public List<SystemTransactionLog> selectSystemTransactionLogList(SystemTransactionLog systemTransactionLog)
    {
        return systemTransactionLogMapper.selectSystemTransactionLogList(systemTransactionLog);
    }

    /**
     * 新增交易记录
     * 
     * @param systemTransactionLog 交易记录
     * @return 结果
     */
    @Override
    public int insertSystemTransactionLog(SystemTransactionLog systemTransactionLog)
    {
        return systemTransactionLogMapper.insertSystemTransactionLog(systemTransactionLog);
    }

    /**
     * 修改交易记录
     * 
     * @param systemTransactionLog 交易记录
     * @return 结果
     */
    @Override
    public int updateSystemTransactionLog(SystemTransactionLog systemTransactionLog)
    {
        return systemTransactionLogMapper.updateSystemTransactionLog(systemTransactionLog);
    }

    /**
     * 删除交易记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemTransactionLogByIds(String ids)
    {
        return systemTransactionLogMapper.deleteSystemTransactionLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除交易记录信息
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    @Override
    public int deleteSystemTransactionLogById(Long id)
    {
        return systemTransactionLogMapper.deleteSystemTransactionLogById(id);
    }

    @Override
    public List<Map> selectTransactionLogPancake(Integer clientid) {
        Map<String,Object> map=new HashMap();
        map.put("clientid",clientid);
        return systemTransactionLogMapper.selectTransactionLogPancake(map);
    }

    @Override
    public List<Map> selectTransactionLog(Long standardid, Long clientid) {
        Map<String,Object> map=new HashMap();
        map.put("standardid",standardid);
        map.put("clientid",clientid);
        return systemTransactionLogMapper.selectTransactionLog(map);
    }
}
