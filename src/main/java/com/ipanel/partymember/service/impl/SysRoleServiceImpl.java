package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.pojo.SysRole;
import com.ipanel.partymember.mapper.SysRoleMapper;
import com.ipanel.partymember.service.SysRoleService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int updateBatch(List<SysRole> list) {
        return sysRoleMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysRole> list) {
        return sysRoleMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysRole record) {
        return sysRoleMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysRole record) {
        return sysRoleMapper.insertOrUpdateSelective(record);
    }

}
