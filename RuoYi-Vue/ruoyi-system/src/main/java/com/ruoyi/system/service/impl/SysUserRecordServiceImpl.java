package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.system.domain.SysUserInfo;
import com.ruoyi.system.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserRecordMapper;
import com.ruoyi.system.domain.SysUserRecord;
import com.ruoyi.system.service.ISysUserRecordService;

/**
 * 记录信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@Service
public class SysUserRecordServiceImpl implements ISysUserRecordService 
{
    @Autowired
    private SysUserRecordMapper sysUserRecordMapper;

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    /**
     * 查询记录信息
     * 
     * @param recordId 记录信息ID
     * @return 记录信息
     */
    @Override
    public SysUserRecord selectSysUserRecordById(Long recordId)
    {
        return sysUserRecordMapper.selectSysUserRecordById(recordId);
    }

    /**
     * 查询记录信息列表
     * 
     * @param sysUserRecord 记录信息
     * @return 记录信息
     */
    @Override
    public List<SysUserRecord> selectSysUserRecordList(SysUserRecord sysUserRecord)
    {
        return sysUserRecordMapper.selectSysUserRecordList(sysUserRecord);
    }

    /**
     * 新增记录信息
     * 
     * @param sysUserRecord 记录信息
     * @return 结果
     */
    @Override
    public int insertSysUserRecord(SysUserRecord sysUserRecord)
    {
        if(sysUserRecord.getUserId()!=null&&sysUserRecord.getVisionLeft()!=null&&sysUserRecord.getVisionRight()!=null){
            SysUserInfo sysUserInfo = new SysUserInfo();
            sysUserInfo.setUserId(sysUserRecord.getUserId());
            sysUserInfo.setVisionLeft(sysUserRecord.getVisionLeft());
            sysUserInfo.setVisionRight(sysUserRecord.getVisionRight());
            sysUserInfoMapper.updateSysUserInfo(sysUserInfo);
        }
        return sysUserRecordMapper.insertSysUserRecord(sysUserRecord);
    }

    /**
     * 修改记录信息
     * 
     * @param sysUserRecord 记录信息
     * @return 结果
     */
    @Override
    public int updateSysUserRecord(SysUserRecord sysUserRecord)
    {
        return sysUserRecordMapper.updateSysUserRecord(sysUserRecord);
    }

    /**
     * 批量删除记录信息
     * 
     * @param recordIds 需要删除的记录信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRecordByIds(Long[] recordIds)
    {
        return sysUserRecordMapper.deleteSysUserRecordByIds(recordIds);
    }

    /**
     * 删除记录信息信息
     * 
     * @param recordId 记录信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRecordById(Long recordId)
    {
        return sysUserRecordMapper.deleteSysUserRecordById(recordId);
    }
}
