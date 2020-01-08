package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.mapper.SysRoleDeptMapper;
import com.ipanel.partymember.pojo.SysRoleDept;
import com.ipanel.partymember.service.SysRoleDeptService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService{

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public int updateBatch(List<SysRoleDept> list) {
        return sysRoleDeptMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysRoleDept> list) {
        return sysRoleDeptMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysRoleDept record) {
        return sysRoleDeptMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysRoleDept record) {
        return sysRoleDeptMapper.insertOrUpdateSelective(record);
    }

}
