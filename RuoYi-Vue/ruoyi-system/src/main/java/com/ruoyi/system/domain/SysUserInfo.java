package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人信息对象 sys_user_info
 *
 * @author ruoyi
 * @date 2021-06-12
 */
public class SysUserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 确诊日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确诊日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date diagnosis;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 左眼视力 */
    @Excel(name = "左眼视力")
    private BigDecimal visionLeft;

    /** 右眼视力 */
    @Excel(name = "右眼视力")
    private BigDecimal visionRight;

    /** 家族史 */
    @Excel(name = "家族史")
    private String history;

    /** 青光眼档案 */
    @Excel(name = "青光眼档案")
    private String archives;

    /** 眼压 */
    @Excel(name = "眼压")
    private Integer pressure;

    /** 确诊照片 */
    @Excel(name = "确诊照片")
    private String photo;

    /** 感知压力量表分数 */
    @Excel(name = "感知压力量表分数")
    private BigDecimal stress;

    /** 药物依从性量表分数 */
    @Excel(name = "药物依从性量表分数")
    private Integer compliance;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setDiagnosis(Date diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public Date getDiagnosis()
    {
        return diagnosis;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Date getBirthday()
    {
        return birthday;
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
    public void setHistory(String history)
    {
        this.history = history;
    }

    public String getHistory()
    {
        return history;
    }
    public void setArchives(String archives)
    {
        this.archives = archives;
    }

    public String getArchives()
    {
        return archives;
    }
    public void setPressure(Integer pressure)
    {
        this.pressure = pressure;
    }

    public Integer getPressure()
    {
        return pressure;
    }
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public String getPhoto()
    {
        return photo;
    }
    public void setStress(BigDecimal stress)
    {
        this.stress = stress;
    }

    public BigDecimal getStress()
    {
        return stress;
    }
    public void setCompliance(Integer compliance)
    {
        this.compliance = compliance;
    }

    public Integer getCompliance()
    {
        return compliance;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("diagnosis", getDiagnosis())
                .append("birthday", getBirthday())
                .append("visionLeft", getVisionLeft())
                .append("visionRight", getVisionRight())
                .append("history", getHistory())
                .append("archives", getArchives())
                .append("pressure", getPressure())
                .append("photo", getPhoto())
                .append("stress", getStress())
                .append("compliance", getCompliance())
                .append("nickName", getNickName())
                .append("avatar", getAvatar())
                .append("sex", getSex())
                .toString();
    }
}
