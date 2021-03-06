package com.ruoyi.project.mbkj.stusertask.service;

import com.github.pagehelper.Page;
import com.ruoyi.project.mbkj.stusertask.domain.StUserTask;

import java.util.List;
import java.util.Map;

/**
 * 存储设置的用户绩效Service接口
 * 
 * @author 云晓得峰
 * @date 2020-08-10
 */
public interface IStUserTaskService 
{
    /**
     * 查询存储设置的用户绩效
     * 
     * @param id 存储设置的用户绩效ID
     * @return 存储设置的用户绩效
     */
    public StUserTask selectStUserTaskById(Long id);

    /**
     * 查询存储设置的用户绩效列表
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 存储设置的用户绩效集合
     */
    public List<StUserTask> selectStUserTaskList(StUserTask stUserTask);

    /**
     * 新增存储设置的用户绩效
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 结果
     */
    public int insertStUserTask(StUserTask stUserTask);

    /**
     * 修改存储设置的用户绩效
     * 
     * @param stUserTask 存储设置的用户绩效
     * @return 结果
     */
    public int updateStUserTask(StUserTask stUserTask);

    /**
     * 批量删除存储设置的用户绩效
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStUserTaskByIds(String ids);

    /**
     * 删除存储设置的用户绩效信息
     * 
     * @param id 存储设置的用户绩效ID
     * @return 结果
     */
    public int deleteStUserTaskById(Long id);

    Page<Map> selectList(Long id, String time, int i);

}
