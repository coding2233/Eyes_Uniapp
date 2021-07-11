package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserRemindMapper;
import com.ruoyi.system.domain.SysUserRemind;
import com.ruoyi.system.service.ISysUserRemindService;

/**
 * 提醒信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-13
 */
@Service
public class SysUserRemindServiceImpl implements ISysUserRemindService 
{
    @Autowired
    private SysUserRemindMapper sysUserRemindMapper;

    /**
     * 查询提醒信息
     * 
     * @param remindId 提醒信息ID
     * @return 提醒信息
     */
    @Override
    public SysUserRemind selectSysUserRemindById(Long remindId)
    {
        return sysUserRemindMapper.selectSysUserRemindById(remindId);
    }

    /**
     * 查询提醒信息列表
     * 
     * @param sysUserRemind 提醒信息
     * @return 提醒信息
     */
    @Override
    public List<SysUserRemind> selectSysUserRemindList(SysUserRemind sysUserRemind)
    {
        return sysUserRemindMapper.selectSysUserRemindList(sysUserRemind);
    }

    /**
     * 新增提醒信息
     * 
     * @param sysUserRemind 提醒信息
     * @return 结果
     */
    @Override
    public int insertSysUserRemind(SysUserRemind sysUserRemind)
    {
        return sysUserRemindMapper.insertSysUserRemind(sysUserRemind);
    }

    /**
     * 修改提醒信息
     * 
     * @param sysUserRemind 提醒信息
     * @return 结果
     */
    @Override
    public int updateSysUserRemind(SysUserRemind sysUserRemind)
    {
        return sysUserRemindMapper.updateSysUserRemind(sysUserRemind);
    }

    /**
     * 批量删除提醒信息
     * 
     * @param remindIds 需要删除的提醒信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRemindByIds(Long[] remindIds)
    {
        return sysUserRemindMapper.deleteSysUserRemindByIds(remindIds);
    }

    /**
     * 删除提醒信息信息
     * 
     * @param remindId 提醒信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRemindById(Long remindId)
    {
        return sysUserRemindMapper.deleteSysUserRemindById(remindId);
    }
}
