package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserRemind;

/**
 * 提醒信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-13
 */
public interface SysUserRemindMapper 
{
    /**
     * 查询提醒信息
     * 
     * @param remindId 提醒信息ID
     * @return 提醒信息
     */
    public SysUserRemind selectSysUserRemindById(Long remindId);

    /**
     * 查询提醒信息列表
     * 
     * @param sysUserRemind 提醒信息
     * @return 提醒信息集合
     */
    public List<SysUserRemind> selectSysUserRemindList(SysUserRemind sysUserRemind);

    /**
     * 新增提醒信息
     * 
     * @param sysUserRemind 提醒信息
     * @return 结果
     */
    public int insertSysUserRemind(SysUserRemind sysUserRemind);

    /**
     * 修改提醒信息
     * 
     * @param sysUserRemind 提醒信息
     * @return 结果
     */
    public int updateSysUserRemind(SysUserRemind sysUserRemind);

    /**
     * 删除提醒信息
     * 
     * @param remindId 提醒信息ID
     * @return 结果
     */
    public int deleteSysUserRemindById(Long remindId);

    /**
     * 批量删除提醒信息
     * 
     * @param remindIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserRemindByIds(Long[] remindIds);
}
