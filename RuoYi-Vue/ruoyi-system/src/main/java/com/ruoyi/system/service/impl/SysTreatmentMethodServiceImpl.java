package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTreatmentMethodMapper;
import com.ruoyi.system.domain.SysTreatmentMethod;
import com.ruoyi.system.service.ISysTreatmentMethodService;

/**
 * 就诊记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@Service
public class SysTreatmentMethodServiceImpl implements ISysTreatmentMethodService 
{
    @Autowired
    private SysTreatmentMethodMapper sysTreatmentMethodMapper;

    /**
     * 查询就诊记录
     * 
     * @param methodId 就诊记录ID
     * @return 就诊记录
     */
    @Override
    public SysTreatmentMethod selectSysTreatmentMethodById(Long methodId)
    {
        return sysTreatmentMethodMapper.selectSysTreatmentMethodById(methodId);
    }

    /**
     * 查询就诊记录列表
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 就诊记录
     */
    @Override
    public List<SysTreatmentMethod> selectSysTreatmentMethodList(SysTreatmentMethod sysTreatmentMethod)
    {
        return sysTreatmentMethodMapper.selectSysTreatmentMethodList(sysTreatmentMethod);
    }

    /**
     * 新增就诊记录
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 结果
     */
    @Override
    public int insertSysTreatmentMethod(SysTreatmentMethod sysTreatmentMethod)
    {
        return sysTreatmentMethodMapper.insertSysTreatmentMethod(sysTreatmentMethod);
    }

    /**
     * 修改就诊记录
     * 
     * @param sysTreatmentMethod 就诊记录
     * @return 结果
     */
    @Override
    public int updateSysTreatmentMethod(SysTreatmentMethod sysTreatmentMethod)
    {
        return sysTreatmentMethodMapper.updateSysTreatmentMethod(sysTreatmentMethod);
    }

    /**
     * 批量删除就诊记录
     * 
     * @param methodIds 需要删除的就诊记录ID
     * @return 结果
     */
    @Override
    public int deleteSysTreatmentMethodByIds(Long[] methodIds)
    {
        return sysTreatmentMethodMapper.deleteSysTreatmentMethodByIds(methodIds);
    }

    /**
     * 删除就诊记录信息
     * 
     * @param methodId 就诊记录ID
     * @return 结果
     */
    @Override
    public int deleteSysTreatmentMethodById(Long methodId)
    {
        return sysTreatmentMethodMapper.deleteSysTreatmentMethodById(methodId);
    }
}
