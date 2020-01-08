package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.mapper.SysLogMapper;
import com.ipanel.partymember.pojo.SysLog;
import com.ipanel.partymember.service.SysLogService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public int updateBatch(List<SysLog> list) {
        return sysLogMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysLog> list) {
        return sysLogMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysLog record) {
        return sysLogMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysLog record) {
        return sysLogMapper.insertOrUpdateSelective(record);
    }

    @Override
    public void save(SysLog sysLog) {

    }

}
