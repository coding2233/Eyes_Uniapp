package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysMedicalRecord;

/**
 * 就诊记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public interface SysMedicalRecordMapper 
{
    /**
     * 查询就诊记录
     * 
     * @param recordId 就诊记录ID
     * @return 就诊记录
     */
    public SysMedicalRecord selectSysMedicalRecordById(Long recordId);

    /**
     * 查询就诊记录列表
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 就诊记录集合
     */
    public List<SysMedicalRecord> selectSysMedicalRecordList(SysMedicalRecord sysMedicalRecord);

    /**
     * 新增就诊记录
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 结果
     */
    public int insertSysMedicalRecord(SysMedicalRecord sysMedicalRecord);

    /**
     * 修改就诊记录
     * 
     * @param sysMedicalRecord 就诊记录
     * @return 结果
     */
    public int updateSysMedicalRecord(SysMedicalRecord sysMedicalRecord);

    /**
     * 删除就诊记录
     * 
     * @param recordId 就诊记录ID
     * @return 结果
     */
    public int deleteSysMedicalRecordById(Long recordId);

    /**
     * 批量删除就诊记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysMedicalRecordByIds(Long[] recordIds);
}
