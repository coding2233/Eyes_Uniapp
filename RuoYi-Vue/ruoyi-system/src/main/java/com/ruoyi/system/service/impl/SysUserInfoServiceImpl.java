package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserInfoMapper;
import com.ruoyi.system.domain.SysUserInfo;
import com.ruoyi.system.service.ISysUserInfoService;

/**
 * 个人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-11
 */
@Service
public class SysUserInfoServiceImpl implements ISysUserInfoService 
{
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 查询个人信息
     * 
     * @param userId 个人信息ID
     * @return 个人信息
     */
    @Override
    public SysUserInfo selectSysUserInfoById(Long userId)
    {
        return sysUserInfoMapper.selectSysUserInfoById(userId);
    }

    /**
     * 查询个人信息列表
     * 
     * @param sysUserInfo 个人信息
     * @return 个人信息
     */
    @Override
    public List<SysUserInfo> selectSysUserInfoList(SysUserInfo sysUserInfo)
    {
        return sysUserInfoMapper.selectSysUserInfoList(sysUserInfo);
    }

    /**
     * 新增个人信息
     * 
     * @param sysUserInfo 个人信息
     * @return 结果
     */
    @Override
    public int insertSysUserInfo(SysUserInfo sysUserInfo)
    {
        return sysUserInfoMapper.insertSysUserInfo(sysUserInfo);
    }

    /**
     * 修改个人信息
     * 
     * @param sysUserInfo 个人信息
     * @return 结果
     */
    @Override
    public int updateSysUserInfo(SysUserInfo sysUserInfo)
    {
        return sysUserInfoMapper.updateSysUserInfo(sysUserInfo);
    }

    /**
     * 批量删除个人信息
     * 
     * @param userIds 需要删除的个人信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserInfoByIds(Long[] userIds)
    {
        return sysUserInfoMapper.deleteSysUserInfoByIds(userIds);
    }

    /**
     * 删除个人信息信息
     * 
     * @param userId 个人信息ID
     * @return 结果
     */
    @Override
    public int deleteSysUserInfoById(Long userId)
    {
        return sysUserInfoMapper.deleteSysUserInfoById(userId);
    }
}
