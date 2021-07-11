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
import com.ruoyi.system.domain.SysUserInfo;
import com.ruoyi.system.service.ISysUserInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人信息Controller
 * 
 * @author ruoyi
 * @date 2021-06-11
 */
@RestController
@RequestMapping("/system/info")
public class SysUserInfoController extends BaseController
{
    @Autowired
    private ISysUserInfoService sysUserInfoService;

    /**
     * 查询个人信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUserInfo sysUserInfo)
    {
        startPage();
        List<SysUserInfo> list = sysUserInfoService.selectSysUserInfoList(sysUserInfo);
        return getDataTable(list);
    }

    /**
     * 导出个人信息列表
     */
    @Log(title = "个人信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUserInfo sysUserInfo)
    {
        List<SysUserInfo> list = sysUserInfoService.selectSysUserInfoList(sysUserInfo);
        ExcelUtil<SysUserInfo> util = new ExcelUtil<SysUserInfo>(SysUserInfo.class);
        return util.exportExcel(list, "个人信息数据");
    }

    /**
     * 获取个人信息详细信息
     */
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(sysUserInfoService.selectSysUserInfoById(userId));
    }

    /**
     * 新增个人信息
     */
    @Log(title = "个人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserInfo sysUserInfo)
    {
        return toAjax(sysUserInfoService.insertSysUserInfo(sysUserInfo));
    }

    /**
     * 修改个人信息
     */

    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserInfo sysUserInfo)
    {
        return toAjax(sysUserInfoService.updateSysUserInfo(sysUserInfo));
    }

    /**
     * 删除个人信息
     */
    @Log(title = "个人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(sysUserInfoService.deleteSysUserInfoByIds(userIds));
    }
}
