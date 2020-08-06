package com.ruoyi.project.mbkj.usermonthtarget.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mbkj.usermonthtarget.mapper.StUsermonthtargetMapper;
import com.ruoyi.project.mbkj.usermonthtarget.domain.StUsermonthtarget;
import com.ruoyi.project.mbkj.usermonthtarget.service.IStUsermonthtargetService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 数据统计Service业务层处理
 * 
 * @author LJP
 * @date 2020-08-06
 */
@Service
public class StUsermonthtargetServiceImpl implements IStUsermonthtargetService 
{
    @Autowired
    private StUsermonthtargetMapper stUsermonthtargetMapper;

    /**
     * 查询数据统计
     * 
     * @param id 数据统计ID
     * @return 数据统计
     */
    @Override
    public StUsermonthtarget selectStUsermonthtargetById(Long id)
    {
        return stUsermonthtargetMapper.selectStUsermonthtargetById(id);
    }

    /**
     * 查询数据统计列表
     * 
     * @param stUsermonthtarget 数据统计
     * @return 数据统计
     */
    @Override
    public List<StUsermonthtarget> selectStUsermonthtargetList(StUsermonthtarget stUsermonthtarget)
    {
        return stUsermonthtargetMapper.selectStUsermonthtargetList(stUsermonthtarget);
    }

    /**
     * 新增数据统计
     * 
     * @param stUsermonthtarget 数据统计
     * @return 结果
     */
    @Override
    public int insertStUsermonthtarget(StUsermonthtarget stUsermonthtarget)
    {
        return stUsermonthtargetMapper.insertStUsermonthtarget(stUsermonthtarget);
    }

    /**
     * 修改数据统计
     * 
     * @param stUsermonthtarget 数据统计
     * @return 结果
     */
    @Override
    public int updateStUsermonthtarget(StUsermonthtarget stUsermonthtarget)
    {
        return stUsermonthtargetMapper.updateStUsermonthtarget(stUsermonthtarget);
    }

    /**
     * 删除数据统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStUsermonthtargetByIds(String ids)
    {
        return stUsermonthtargetMapper.deleteStUsermonthtargetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据统计信息
     * 
     * @param id 数据统计ID
     * @return 结果
     */
    @Override
    public int deleteStUsermonthtargetById(Long id)
    {
        return stUsermonthtargetMapper.deleteStUsermonthtargetById(id);
    }
}
