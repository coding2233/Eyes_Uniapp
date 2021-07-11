package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTreatmentMethod;

/**
 * 就诊记录Service接口
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public interface ISysTreatmentMethodService 
{
    /**
     * 查询就诊记录
     * 
     * @param methodId 就诊记录ID
     * @return 就诊记录
     */
    public SysTreatmentMethod selectSysTreatmentMethodById(Long methodId);

    /**
     * 查询就诊记录列表
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 就诊记录集合
     */
    public List<SysTreatmentMethod> selectSysTreatmentMethodList(SysTreatmentMethod sysTreatmentMethod);

    /**
     * 新增就诊记录
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 结果
     */
    public int insertSysTreatmentMethod(SysTreatmentMethod sysTreatmentMethod);

    /**
     * 修改就诊记录
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 结果
     */
    public int updateSysTreatmentMethod(SysTreatmentMethod sysTreatmentMethod);

    /**
     * 批量删除就诊记录
     * 
     * @param methodIds 需要删除的就诊记录ID
     * @return 结果
     */
    public int deleteSysTreatmentMethodByIds(Long[] methodIds);

    /**
     * 删除就诊记录信息
     * 
     * @param methodId 就诊记录ID
     * @return 结果
     */
    public int deleteSysTreatmentMethodById(Long methodId);
}
