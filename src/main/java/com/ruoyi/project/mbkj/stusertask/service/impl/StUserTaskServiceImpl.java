package com.ruoyi.project.mbkj.stusertask.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.stusertask.mapper.StUserTaskMapper;
import com.ruoyi.project.mbkj.stusertask.domain.StUserTask;
import com.ruoyi.project.mbkj.stusertask.service.IStUserTaskService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 存储设置的用户绩效Service业务层处理
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
@Service
public class StUserTaskServiceImpl implements IStUserTaskService 
{
    @Autowired
    private StUserTaskMapper stUserTaskMapper;

    /**
     * 查询存储设置的用户绩效
     * 
     * @param id 存储设置的用户绩效ID
     * @return 存储设置的用户绩效
     */
    @Override
    public StUserTask selectStUserTaskById(Long id)
    {
        return stUserTaskMapper.selectStUserTaskById(id);
    }

    /**
     * 查询存储设置的用户绩效列表
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 存储设置的用户绩效
     */
    @Override
    public List<StUserTask> selectStUserTaskList(StUserTask stUserTask)
    {
        return stUserTaskMapper.selectStUserTaskList(stUserTask);
    }

    /**
     * 新增存储设置的用户绩效
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 结果
     */
    @Override
    public int insertStUserTask(StUserTask stUserTask)
    {
        return stUserTaskMapper.insertStUserTask(stUserTask);
    }

    /**
     * 修改存储设置的用户绩效
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 结果
     */
    @Override
    public int updateStUserTask(StUserTask stUserTask)
    {
        return stUserTaskMapper.updateStUserTask(stUserTask);
    }

    /**
     * 删除存储设置的用户绩效对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStUserTaskByIds(String ids)
    {
        return stUserTaskMapper.deleteStUserTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除存储设置的用户绩效信息
     * 
     * @param id 存储设置的用户绩效ID
     * @return 结果
     */
    @Override
    public int deleteStUserTaskById(Long id)
    {
        return stUserTaskMapper.deleteStUserTaskById(id);
    }
}
