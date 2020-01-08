package com.ipanel.partymember.service;

import java.util.List;
import com.ipanel.partymember.pojo.SysUserRole;
    /**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
public interface SysUserRoleService{


    int updateBatch(List<SysUserRole> list);

    int batchInsert(List<SysUserRole> list);

    int insertOrUpdate(SysUserRole record);

    int insertOrUpdateSelective(SysUserRole record);

        /**
         * 根据用户id查询用户角色关系
         * @param userId
         * @return
         */
        List<SysUserRole> selectUserRoleListByUserId(Integer userId);

}
