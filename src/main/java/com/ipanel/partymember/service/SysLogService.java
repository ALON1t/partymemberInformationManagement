package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysLog;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysLogService{


    int updateBatch(List<SysLog> list);

    int batchInsert(List<SysLog> list);

    int insertOrUpdate(SysLog record);

    int insertOrUpdateSelective(SysLog record);

        void save(SysLog sysLog);
    }
