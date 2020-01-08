package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.pojo.SysRoleMenu;
import com.ipanel.partymember.mapper.SysRoleMenuMapper;
import com.ipanel.partymember.service.SysRoleMenuService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int updateBatch(List<SysRoleMenu> list) {
        return sysRoleMenuMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysRoleMenu> list) {
        return sysRoleMenuMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysRoleMenu record) {
        return sysRoleMenuMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertOrUpdateSelective(record);
    }

}
