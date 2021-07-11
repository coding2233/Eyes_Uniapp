package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 就诊记录对象 sys_medical_record
 * 
 * @author ruoyi
 * @date 2021-06-12
 */
public class SysMedicalRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录编号 */
    private Long recordId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** MD值 */
    @Excel(name = "MD值")
    private BigDecimal md;

    /** PSD值 */
    @Excel(name = "PSD值")
    private BigDecimal psd;

    /** 杯盘比值 */
    @Excel(name = "杯盘比值")
    private BigDecimal bh;

    /** 角膜厚度 */
    @Excel(name = "角膜厚度")
    private BigDecimal um;

    /** RNFL值 */
    @Excel(name = "RNFL值")
    private BigDecimal rnfl;

    /** 就诊日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "就诊日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date medicalTime;

    /** 就诊医院 */
    @Excel(name = "就诊医院")
    private String hospital;

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
    public void setMd(BigDecimal md) 
    {
        this.md = md;
    }

    public BigDecimal getMd() 
    {
        return md;
    }
    public void setPsd(BigDecimal psd) 
    {
        this.psd = psd;
    }

    public BigDecimal getPsd() 
    {
        return psd;
    }
    public void setBh(BigDecimal bh) 
    {
        this.bh = bh;
    }

    public BigDecimal getBh() 
    {
        return bh;
    }
    public void setUm(BigDecimal um) 
    {
        this.um = um;
    }

    public BigDecimal getUm() 
    {
        return um;
    }
    public void setRnfl(BigDecimal rnfl) 
    {
        this.rnfl = rnfl;
    }

    public BigDecimal getRnfl() 
    {
        return rnfl;
    }
    public void setMedicalTime(Date medicalTime) 
    {
        this.medicalTime = medicalTime;
    }

    public Date getMedicalTime() 
    {
        return medicalTime;
    }
    public void setHospital(String hospital) 
    {
        this.hospital = hospital;
    }

    public String getHospital() 
    {
        return hospital;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("userId", getUserId())
            .append("md", getMd())
            .append("psd", getPsd())
            .append("bh", getBh())
            .append("um", getUm())
            .append("rnfl", getRnfl())
            .append("medicalTime", getMedicalTime())
            .append("hospital", getHospital())
            .append("remark", getRemark())
            .toString();
    }
}
