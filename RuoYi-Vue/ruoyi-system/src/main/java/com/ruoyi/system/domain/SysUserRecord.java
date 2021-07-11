package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 记录信息对象 sys_user_record
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public class SysUserRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录编号 */
    private Long recordId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 左眼视力 */
    @Excel(name = "左眼视力")
    private BigDecimal visionLeft;

    /** 右眼视力 */
    @Excel(name = "右眼视力")
    private BigDecimal visionRight;

    /** 左眼压力 */
    @Excel(name = "左眼压力")
    private BigDecimal pressureLeft;

    /** 右眼压力 */
    @Excel(name = "右眼压力")
    private BigDecimal pressureRight;

    /** 记录日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 运动记录 */
    @Excel(name = "运动记录")
    private String medication;

    /** 运动情况 */
    @Excel(name = "运动情况")
    private String emotion;

    /** 情绪状况 */
    @Excel(name = "情绪状况")
    private String motion;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setVisionLeft(BigDecimal visionLeft) 
    {
        this.visionLeft = visionLeft;
    }

    public BigDecimal getVisionLeft() 
    {
        return visionLeft;
    }
    public void setVisionRight(BigDecimal visionRight) 
    {
        this.visionRight = visionRight;
    }

    public BigDecimal getVisionRight() 
    {
        return visionRight;
    }
    public void setPressureLeft(BigDecimal pressureLeft) 
    {
        this.pressureLeft = pressureLeft;
    }

    public BigDecimal getPressureLeft() 
    {
        return pressureLeft;
    }
    public void setPressureRight(BigDecimal pressureRight) 
    {
        this.pressureRight = pressureRight;
    }

    public BigDecimal getPressureRight() 
    {
        return pressureRight;
    }
    public void setRecordTime(Date recordTime) 
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime() 
    {
        return recordTime;
    }
    public void setMedication(String medication) 
    {
        this.medication = medication;
    }

    public String getMedication() 
    {
        return medication;
    }
    public void setEmotion(String emotion) 
    {
        this.emotion = emotion;
    }

    public String getEmotion() 
    {
        return emotion;
    }
    public void setMotion(String motion) 
    {
        this.motion = motion;
    }

    public String getMotion() 
    {
        return motion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("userId", getUserId())
            .append("visionLeft", getVisionLeft())
            .append("visionRight", getVisionRight())
            .append("pressureLeft", getPressureLeft())
            .append("pressureRight", getPressureRight())
            .append("recordTime", getRecordTime())
            .append("medication", getMedication())
            .append("emotion", getEmotion())
            .append("motion", getMotion())
            .toString();
    }
}
