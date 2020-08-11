package com.ruoyi.project.mbkj.usermonthtarget.service;

import java.util.List;

import com.ruoyi.project.mbkj.standard.domain.StStandard;
import com.ruoyi.project.mbkj.usermonthtarget.domain.StUsermonthtarget;
import com.ruoyi.project.ro.SelectTargetParam;
import com.ruoyi.project.vo.OtherTargetResult;
import com.ruoyi.project.vo.TargetResult;

/**
 * 数据统计Service接口
 * 
 * @author LJP
 * @date 2020-08-06
 */
public interface IStUsermonthtargetService 
{
    /**
     * 查询数据统计
     * 
     * @param id 数据统计ID
     * @return 数据统计
     */
    public StUsermonthtarget selectStUsermonthtargetById(Long id);

    /**
     * 查询数据统计列表
     * 
     * @param stUsermonthtarget 数据统计
     * @return 数据统计集合
     */
    public List<StUsermonthtarget> selectStUsermonthtargetList(StUsermonthtarget stUsermonthtarget);

    /**
     * 新增数据统计
     * 
     * @param stUsermonthtarget 数据统计
     * @return 结果
     */
    public int insertStUsermonthtarget(StUsermonthtarget stUsermonthtarget);

    /**
     * 修改数据统计
     * 
     * @param stUsermonthtarget 数据统计
     * @return 结果
     */
    public int updateStUsermonthtarget(StUsermonthtarget stUsermonthtarget);

    /**
     * 批量删除数据统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStUsermonthtargetByIds(String ids);

    /**
     * 删除数据统计信息
     * 
     * @param id 数据统计ID
     * @return 结果
     */
    public int deleteStUsermonthtargetById(Long id);
    
    

	public TargetResult select5target(SelectTargetParam selectTargetParam );

	public List<OtherTargetResult> selectOthertarget(SelectTargetParam selectTargetParam);

	public TargetResult selectUser5target(SelectTargetParam selectTargetParam);

	public List<OtherTargetResult> selectUserOthertarget(SelectTargetParam selectTargetParam);

	public List<StStandard> selectStanderList();
}
