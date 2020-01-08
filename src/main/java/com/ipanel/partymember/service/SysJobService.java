package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysJob;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysJobService{


    int updateBatch(List<SysJob> list);

    int batchInsert(List<SysJob> list);

    int insertOrUpdate(SysJob record);

    int insertOrUpdateSelective(SysJob record);

}
