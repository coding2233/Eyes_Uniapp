package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysUserRecord;

/**
 * 记录信息Service接口
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public interface ISysUserRecordService 
{
    /**
     * 查询记录信息
     * 
     * @param recordId 记录信息ID
     * @return 记录信息
     */
    public SysUserRecord selectSysUserRecordById(Long recordId);

    /**
     * 查询记录信息列表
     * 
     * @param sysUserRecord 记录信息
     * @return 记录信息集合
     */
    public List<SysUserRecord> selectSysUserRecordList(SysUserRecord sysUserRecord);

    /**
     * 新增记录信息
     * 
     * @param sysUserRecord 记录信息
     * @return 结果
     */
    public int insertSysUserRecord(SysUserRecord sysUserRecord);

    /**
     * 修改记录信息
     * 
     * @param sysUserRecord 记录信息
     * @return 结果
     */
    public int updateSysUserRecord(SysUserRecord sysUserRecord);

    /**
     * 批量删除记录信息
     * 
     * @param recordIds 需要删除的记录信息ID
     * @return 结果
     */
    public int deleteSysUserRecordByIds(Long[] recordIds);

    /**
     * 删除记录信息信息
     * 
     * @param recordId 记录信息ID
     * @return 结果
     */
    public int deleteSysUserRecordById(Long recordId);
}
