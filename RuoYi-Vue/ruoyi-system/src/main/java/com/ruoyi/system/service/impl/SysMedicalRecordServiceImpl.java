package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMedicalRecordMapper;
import com.ruoyi.system.domain.SysMedicalRecord;
import com.ruoyi.system.service.ISysMedicalRecordService;

/**
 * 就诊记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@Service
public class SysMedicalRecordServiceImpl implements ISysMedicalRecordService 
{
    @Autowired
    private SysMedicalRecordMapper sysMedicalRecordMapper;

    /**
     * 查询就诊记录
     * 
     * @param recordId 就诊记录ID
     * @return 就诊记录
     */
    @Override
    public SysMedicalRecord selectSysMedicalRecordById(Long recordId)
    {
        return sysMedicalRecordMapper.selectSysMedicalRecordById(recordId);
    }

    /**
     * 查询就诊记录列表
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 就诊记录
     */
    @Override
    public List<SysMedicalRecord> selectSysMedicalRecordList(SysMedicalRecord sysMedicalRecord)
    {
        return sysMedicalRecordMapper.selectSysMedicalRecordList(sysMedicalRecord);
    }

    /**
     * 新增就诊记录
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 结果
     */
    @Override
    public int insertSysMedicalRecord(SysMedicalRecord sysMedicalRecord)
    {
        return sysMedicalRecordMapper.insertSysMedicalRecord(sysMedicalRecord);
    }

    /**
     * 修改就诊记录
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 结果
     */
    @Override
    public int updateSysMedicalRecord(SysMedicalRecord sysMedicalRecord)
    {
        return sysMedicalRecordMapper.updateSysMedicalRecord(sysMedicalRecord);
    }

    /**
     * 批量删除就诊记录
     * 
     * @param recordIds 需要删除的就诊记录ID
     * @return 结果
     */
    @Override
    public int deleteSysMedicalRecordByIds(Long[] recordIds)
    {
        return sysMedicalRecordMapper.deleteSysMedicalRecordByIds(recordIds);
    }

    /**
     * 删除就诊记录信息
     * 
     * @param recordId 就诊记录ID
     * @return 结果
     */
    @Override
    public int deleteSysMedicalRecordById(Long recordId)
    {
        return sysMedicalRecordMapper.deleteSysMedicalRecordById(recordId);
    }
}
