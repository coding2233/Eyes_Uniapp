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
import com.ruoyi.system.domain.SysUserRecord;
import com.ruoyi.system.service.ISysUserRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 记录信息Controller
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@RestController
@RequestMapping("/system/record")
public class SysUserRecordController extends BaseController
{
    @Autowired
    private ISysUserRecordService sysUserRecordService;

    /**
     * 查询记录信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUserRecord sysUserRecord)
    {
        startPage();
        List<SysUserRecord> list = sysUserRecordService.selectSysUserRecordList(sysUserRecord);
        return getDataTable(list);
    }

    /**
     * 导出记录信息列表
     */
    @Log(title = "记录信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUserRecord sysUserRecord)
    {
        List<SysUserRecord> list = sysUserRecordService.selectSysUserRecordList(sysUserRecord);
        ExcelUtil<SysUserRecord> util = new ExcelUtil<SysUserRecord>(SysUserRecord.class);
        return util.exportExcel(list, "记录信息数据");
    }

    /**
     * 获取记录信息详细信息
     */
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(sysUserRecordService.selectSysUserRecordById(recordId));
    }
    /**
     * 获取记录信息详细信息
     */
    @GetMapping(value = "/getInfoById/{userId}")
    public AjaxResult getInfoById(@PathVariable("userId") Long userId)
    {
        SysUserRecord sysUserRecord = new SysUserRecord();
        sysUserRecord.setUserId(userId);
        List<SysUserRecord> list = sysUserRecordService.selectSysUserRecordList(sysUserRecord);
        return AjaxResult.success(list);
    }

    /**
     * 新增记录信息
     */
    @Log(title = "记录信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserRecord sysUserRecord)
    {
        return toAjax(sysUserRecordService.insertSysUserRecord(sysUserRecord));
    }

    /**
     * 修改记录信息
     */
    @Log(title = "记录信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserRecord sysUserRecord)
    {
        return toAjax(sysUserRecordService.updateSysUserRecord(sysUserRecord));
    }

    /**
     * 删除记录信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "记录信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(sysUserRecordService.deleteSysUserRecordByIds(recordIds));
    }
}
