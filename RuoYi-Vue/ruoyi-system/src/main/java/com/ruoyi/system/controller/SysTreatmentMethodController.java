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
import com.ruoyi.system.domain.SysTreatmentMethod;
import com.ruoyi.system.service.ISysTreatmentMethodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 就诊记录Controller
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
@RestController
@RequestMapping("/system/method")
public class SysTreatmentMethodController extends BaseController
{
    @Autowired
    private ISysTreatmentMethodService sysTreatmentMethodService;

    /**
     * 查询就诊记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysTreatmentMethod sysTreatmentMethod)
    {
        startPage();
        List<SysTreatmentMethod> list = sysTreatmentMethodService.selectSysTreatmentMethodList(sysTreatmentMethod);
        return getDataTable(list);
    }

    /**
     * 导出就诊记录列表
     */
    @Log(title = "就诊记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysTreatmentMethod sysTreatmentMethod)
    {
        List<SysTreatmentMethod> list = sysTreatmentMethodService.selectSysTreatmentMethodList(sysTreatmentMethod);
        ExcelUtil<SysTreatmentMethod> util = new ExcelUtil<SysTreatmentMethod>(SysTreatmentMethod.class);
        return util.exportExcel(list, "就诊记录数据");
    }

    /**
     * 获取就诊记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:method:query')")
    @GetMapping(value = "/{methodId}")
    public AjaxResult getInfo(@PathVariable("methodId") Long methodId)
    {
        return AjaxResult.success(sysTreatmentMethodService.selectSysTreatmentMethodById(methodId));
    }

    /**
     * 新增就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTreatmentMethod sysTreatmentMethod)
    {
        return toAjax(sysTreatmentMethodService.insertSysTreatmentMethod(sysTreatmentMethod));
    }

    /**
     * 修改就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTreatmentMethod sysTreatmentMethod)
    {
        return toAjax(sysTreatmentMethodService.updateSysTreatmentMethod(sysTreatmentMethod));
    }

    /**
     * 删除就诊记录
     */
    @Log(title = "就诊记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{methodIds}")
    public AjaxResult remove(@PathVariable Long[] methodIds)
    {
        return toAjax(sysTreatmentMethodService.deleteSysTreatmentMethodByIds(methodIds));
    }
}
