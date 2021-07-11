package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提醒信息对象 sys_user_remind
 * 
 * @author ruoyi
 * @date 2021-06-13
 */
public class SysUserRemind extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提醒编号 */
    private Long remindId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 提醒类型(0-就诊提醒，1-用药提醒) */
    @Excel(name = "提醒类型(0-就诊提醒，1-用药提醒)")
    private Long remindType;

    /** 提醒事件 */
    @Excel(name = "提醒事件")
    private String remind;

    /** 提醒时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提醒时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date remindTime;

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

    /** 药物使用方式 */
    @Excel(name = "药物使用方式")
    private String drugsMode;

    public void setRemindId(Long remindId) 
    {
        this.remindId = remindId;
    }

    public Long getRemindId() 
    {
        return remindId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRemindType(Long remindType) 
    {
        this.remindType = remindType;
    }

    public Long getRemindType() 
    {
        return remindType;
    }
    public void setRemind(String remind) 
    {
        this.remind = remind;
    }

    public String getRemind() 
    {
        return remind;
    }
    public void setRemindTime(Date remindTime) 
    {
        this.remindTime = remindTime;
    }

    public Date getRemindTime() 
    {
        return remindTime;
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
    public void setDrugsMode(String drugsMode) 
    {
        this.drugsMode = drugsMode;
    }

    public String getDrugsMode() 
    {
        return drugsMode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("remindId", getRemindId())
            .append("userId", getUserId())
            .append("remindType", getRemindType())
            .append("remind", getRemind())
            .append("remindTime", getRemindTime())
            .append("drugs", getDrugs())
            .append("drugsStartTime", getDrugsStartTime())
            .append("drugsEndTime", getDrugsEndTime())
            .append("drugsMode", getDrugsMode())
            .toString();
    }
}
