package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysRoleDept;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysRoleDeptService{


    int updateBatch(List<SysRoleDept> list);

    int batchInsert(List<SysRoleDept> list);

    int insertOrUpdate(SysRoleDept record);

    int insertOrUpdateSelective(SysRoleDept record);

}
