package com.ruoyi.project.mbkj.systemtransactionlog.mapper;

import com.ruoyi.project.mbkj.systemtransactionlog.domain.SystemTransactionLog;

import java.util.List;
import java.util.Map;

/**
 * 交易记录Mapper接口
 * 
 * @author 云晓得峰
 * @date 2020-08-06
 */
public interface SystemTransactionLogMapper 
{
    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    public SystemTransactionLog selectSystemTransactionLogById(Long id);

    /**
     * 查询交易记录列表
     * 
     * @param systemTransactionLog 交易记录
     * @return 交易记录集合
     */
    public List<SystemTransactionLog> selectSystemTransactionLogList(SystemTransactionLog systemTransactionLog);

    /**
     * 新增交易记录
     * 
     * @param systemTransactionLog 交易记录
     * @return 结果
     */
    public int insertSystemTransactionLog(SystemTransactionLog systemTransactionLog);

    /**
     * 修改交易记录
     * 
     * @param systemTransactionLog 交易记录
     * @return 结果
     */
    public int updateSystemTransactionLog(SystemTransactionLog systemTransactionLog);

    /**
     * 删除交易记录
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    public int deleteSystemTransactionLogById(Long id);

    /**
     * 批量删除交易记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemTransactionLogByIds(String[] ids);

    List<Map> selectTransactionLogPancake(Map<String, Object> map);

    List<Map> selectTransactionLog(Map<String, Object> map);
}
