package com.ipanel.partymember.service;

import com.ipanel.partymember.pojo.SysDict;
import java.util.List;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysDictService{


    int updateBatch(List<SysDict> list);

    int batchInsert(List<SysDict> list);

    int insertOrUpdate(SysDict record);

    int insertOrUpdateSelective(SysDict record);

}
