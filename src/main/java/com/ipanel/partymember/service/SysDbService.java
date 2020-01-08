package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysDb;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysDbService{


    int updateBatch(List<SysDb> list);

    int batchInsert(List<SysDb> list);

    int insertOrUpdate(SysDb record);

    int insertOrUpdateSelective(SysDb record);

}
