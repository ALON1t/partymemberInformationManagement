package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ipanel.partymember.pojo.SysDict;
import java.util.List;
import com.ipanel.partymember.mapper.SysDictMapper;
import com.ipanel.partymember.service.SysDictService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysDictServiceImpl implements SysDictService{

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public int updateBatch(List<SysDict> list) {
        return sysDictMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysDict> list) {
        return sysDictMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysDict record) {
        return sysDictMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysDict record) {
        return sysDictMapper.insertOrUpdateSelective(record);
    }

}
