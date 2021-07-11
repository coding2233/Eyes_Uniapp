package com.ruoyi.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysMedicalRecord;
import com.ruoyi.system.service.ISysMedicalRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 就诊记录Controller
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@RestController
@RequestMapping("/system/medicalRecord")
public class SysMedicalRecordController extends BaseController
{
    @Autowired
    private ISysMedicalRecordService sysMedicalRecordService;

    /**
     * 查询就诊记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysMedicalRecord sysMedicalRecord)
    {
        startPage();
        List<SysMedicalRecord> list = sysMedicalRecordService.selectSysMedicalRecordList(sysMedicalRecord);
        return getDataTable(list);
    }

    /**
     * 导出就诊记录列表
     */
    @Log(title = "就诊记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysMedicalRecord sysMedicalRecord)
    {
        List<SysMedicalRecord> list = sysMedicalRecordService.selectSysMedicalRecordList(sysMedicalRecord);
        ExcelUtil<SysMedicalRecord> util = new ExcelUtil<SysMedicalRecord>(SysMedicalRecord.class);
        return util.exportExcel(list, "就诊记录数据");
    }

    /**
     * 获取就诊记录详细信息
     */
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(sysMedicalRecordService.selectSysMedicalRecordById(recordId));
    }

    /**
     * 新增就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMedicalRecord sysMedicalRecord)
    {
        return toAjax(sysMedicalRecordService.insertSysMedicalRecord(sysMedicalRecord));
    }

    /**
     * 修改就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMedicalRecord sysMedicalRecord)
    {
        return toAjax(sysMedicalRecordService.updateSysMedicalRecord(sysMedicalRecord));
    }

    /**
     * 删除就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(sysMedicalRecordService.deleteSysMedicalRecordByIds(recordIds));
    }
}
