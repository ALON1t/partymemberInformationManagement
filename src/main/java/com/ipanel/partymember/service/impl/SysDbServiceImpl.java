package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.mapper.SysDbMapper;
import com.ipanel.partymember.pojo.SysDb;
import com.ipanel.partymember.service.SysDbService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysDbServiceImpl implements SysDbService{

    @Resource
    private SysDbMapper sysDbMapper;

    @Override
    public int updateBatch(List<SysDb> list) {
        return sysDbMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysDb> list) {
        return sysDbMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysDb record) {
        return sysDbMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysDb record) {
        return sysDbMapper.insertOrUpdateSelective(record);
    }

}
