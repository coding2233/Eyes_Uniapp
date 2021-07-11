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
import com.ruoyi.system.domain.SysUserRemind;
import com.ruoyi.system.service.ISysUserRemindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提醒信息Controller
 * 
 * @author ruoyi
 * @date 2021-06-13
 */
@RestController
@RequestMapping("/system/remind")
public class SysUserRemindController extends BaseController
{
    @Autowired
    private ISysUserRemindService sysUserRemindService;

    /**
     * 查询提醒信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUserRemind sysUserRemind)
    {
        startPage();
        List<SysUserRemind> list = sysUserRemindService.selectSysUserRemindList(sysUserRemind);
        return getDataTable(list);
    }

    /**
     * 导出提醒信息列表
     */
    @Log(title = "提醒信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUserRemind sysUserRemind)
    {
        List<SysUserRemind> list = sysUserRemindService.selectSysUserRemindList(sysUserRemind);
        ExcelUtil<SysUserRemind> util = new ExcelUtil<SysUserRemind>(SysUserRemind.class);
        return util.exportExcel(list, "提醒信息数据");
    }

    /**
     * 获取提醒信息详细信息
     */
    @GetMapping(value = "/{remindId}")
    public AjaxResult getInfo(@PathVariable("remindId") Long remindId)
    {
        return AjaxResult.success(sysUserRemindService.selectSysUserRemindById(remindId));
    }

    /**
     * 获取提醒信息详细信息
     */
    @GetMapping(value = "/getInfoByUserId/{userId}")
    public AjaxResult getInfoByUserId(@PathVariable("userId") Long userId)
    {
        SysUserRemind sysUserRemind = new SysUserRemind();
        sysUserRemind.setUserId(userId);
        List<SysUserRemind> list = sysUserRemindService.selectSysUserRemindList(sysUserRemind);
        return AjaxResult.success(list);
    }
    /**
     * 新增提醒信息
     */
    @Log(title = "提醒信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserRemind sysUserRemind)
    {
        return toAjax(sysUserRemindService.insertSysUserRemind(sysUserRemind));
    }

    /**
     * 修改提醒信息
     */
    @Log(title = "提醒信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserRemind sysUserRemind)
    {
        return toAjax(sysUserRemindService.updateSysUserRemind(sysUserRemind));
    }

    /**
     * 删除提醒信息
     */
    @Log(title = "提醒信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{remindIds}")
    public AjaxResult remove(@PathVariable Long[] remindIds)
    {
        return toAjax(sysUserRemindService.deleteSysUserRemindByIds(remindIds));
    }
}
