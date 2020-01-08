package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.mapper.SysUserRoleMapper;
import com.ipanel.partymember.pojo.SysUserRole;
import com.ipanel.partymember.service.SysUserRoleService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int updateBatch(List<SysUserRole> list) {
        return sysUserRoleMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysUserRole> list) {
        return sysUserRoleMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysUserRole record) {
        return sysUserRoleMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysUserRole record) {
        return sysUserRoleMapper.insertOrUpdateSelective(record);
    }

    @Override
    public List<SysUserRole> selectUserRoleListByUserId(Integer userId) {
        return sysUserRoleMapper.selectUserRoleListByUserId(userId);
    }

}
