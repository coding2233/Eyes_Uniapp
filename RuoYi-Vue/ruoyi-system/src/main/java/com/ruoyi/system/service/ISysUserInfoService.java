package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysUserInfo;

/**
 * 个人信息Service接口
 * 
 * @author ruoyi
 * @date 2021-06-11
 */
public interface ISysUserInfoService 
{
    /**
     * 查询个人信息
     * 
     * @param userId 个人信息ID
     * @return 个人信息
     */
    public SysUserInfo selectSysUserInfoById(Long userId);

    /**
     * 查询个人信息列表
     * 
     * @param sysUserInfo 个人信息
     * @return 个人信息集合
     */
    public List<SysUserInfo> selectSysUserInfoList(SysUserInfo sysUserInfo);

    /**
     * 新增个人信息
     * 
     * @param sysUserInfo 个人信息
     * @return 结果
     */
    public int insertSysUserInfo(SysUserInfo sysUserInfo);

    /**
     * 修改个人信息
     * 
     * @param sysUserInfo 个人信息
     * @return 结果
     */
    public int updateSysUserInfo(SysUserInfo sysUserInfo);

    /**
     * 批量删除个人信息
     * 
     * @param userIds 需要删除的个人信息ID
     * @return 结果
     */
    public int deleteSysUserInfoByIds(Long[] userIds);

    /**
     * 删除个人信息信息
     * 
     * @param userId 个人信息ID
     * @return 结果
     */
    public int deleteSysUserInfoById(Long userId);
}
