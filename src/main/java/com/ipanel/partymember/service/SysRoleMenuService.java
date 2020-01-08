package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysRoleMenu;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysRoleMenuService{


    int updateBatch(List<SysRoleMenu> list);

    int batchInsert(List<SysRoleMenu> list);

    int insertOrUpdate(SysRoleMenu record);

    int insertOrUpdateSelective(SysRoleMenu record);

}
