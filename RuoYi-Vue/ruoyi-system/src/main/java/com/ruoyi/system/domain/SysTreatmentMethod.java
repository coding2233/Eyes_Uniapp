package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 就诊记录对象 sys_treatment_method
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public class SysTreatmentMethod extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 方式编号 */
    private Long methodId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 药品 */
    @Excel(name = "药品")
    private String drugs;

    /** 药物治疗开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "药物治疗开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date drugsStartTime;

    /** 药物治疗结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "药物治疗结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date drugsEndTime;

    /** 激光治疗 */
    @Excel(name = "激光治疗")
    private String laser;

    /** 激光治疗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "激光治疗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date laserTime;

    /** 手术治疗术式 */
    @Excel(name = "手术治疗术式")
    private String operation;

    /** 手术治疗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "手术治疗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operationTime;

    public void setMethodId(Long methodId) 
    {
        this.methodId = methodId;
    }

    public Long getMethodId() 
    {
        return methodId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDrugs(String drugs) 
    {
        this.drugs = drugs;
    }

    public String getDrugs() 
    {
        return drugs;
    }
    public void setDrugsStartTime(Date drugsStartTime) 
    {
        this.drugsStartTime = drugsStartTime;
    }

    public Date getDrugsStartTime() 
    {
        return drugsStartTime;
    }
    public void setDrugsEndTime(Date drugsEndTime) 
    {
        this.drugsEndTime = drugsEndTime;
    }

    public Date getDrugsEndTime() 
    {
        return drugsEndTime;
    }
    public void setLaser(String laser) 
    {
        this.laser = laser;
    }

    public String getLaser() 
    {
        return laser;
    }
    public void setLaserTime(Date laserTime) 
    {
        this.laserTime = laserTime;
    }

    public Date getLaserTime() 
    {
        return laserTime;
    }
    public void setOperation(String operation) 
    {
        this.operation = operation;
    }

    public String getOperation() 
    {
        return operation;
    }
    public void setOperationTime(Date operationTime) 
    {
        this.operationTime = operationTime;
    }

    public Date getOperationTime() 
    {
        return operationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("methodId", getMethodId())
            .append("userId", getUserId())
            .append("drugs", getDrugs())
            .append("drugsStartTime", getDrugsStartTime())
            .append("drugsEndTime", getDrugsEndTime())
            .append("laser", getLaser())
            .append("laserTime", getLaserTime())
            .append("operation", getOperation())
            .append("operationTime", getOperationTime())
            .append("remark", getRemark())
            .toString();
    }
}
