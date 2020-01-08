package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.pojo.SysJob;
import com.ipanel.partymember.mapper.SysJobMapper;
import com.ipanel.partymember.service.SysJobService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysJobServiceImpl implements SysJobService{

    @Resource
    private SysJobMapper sysJobMapper;

    @Override
    public int updateBatch(List<SysJob> list) {
        return sysJobMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysJob> list) {
        return sysJobMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysJob record) {
        return sysJobMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysJob record) {
        return sysJobMapper.insertOrUpdateSelective(record);
    }

}
