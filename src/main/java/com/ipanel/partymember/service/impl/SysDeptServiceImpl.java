package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipanel.partymember.pojo.SysDept;
import java.util.List;
import com.ipanel.partymember.mapper.SysDeptMapper;
import com.ipanel.partymember.service.SysDeptService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysDeptServiceImpl implements SysDeptService{

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public int updateBatch(List<SysDept> list) {
        return sysDeptMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysDept> list) {
        return sysDeptMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysDept record) {
        return sysDeptMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysDept record) {
        return sysDeptMapper.insertOrUpdateSelective(record);
    }

}
