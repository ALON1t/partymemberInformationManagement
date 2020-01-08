package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysRole;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysRoleService{


    int updateBatch(List<SysRole> list);

    int batchInsert(List<SysRole> list);

    int insertOrUpdate(SysRole record);

    int insertOrUpdateSelective(SysRole record);

}
