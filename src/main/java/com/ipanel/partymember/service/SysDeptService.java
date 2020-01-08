package com.ipanel.partymember.service;

import com.ipanel.partymember.pojo.SysDept;
import java.util.List;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysDeptService{


    int updateBatch(List<SysDept> list);

    int batchInsert(List<SysDept> list);

    int insertOrUpdate(SysDept record);

    int insertOrUpdateSelective(SysDept record);

}
