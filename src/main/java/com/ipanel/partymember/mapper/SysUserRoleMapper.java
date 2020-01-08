package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lenovo
 */
@Mapper
public interface SysUserRoleMapper extends tk.mybatis.mapper.common.Mapper<SysUserRole> {
    int updateBatch(List<SysUserRole> list);

    int batchInsert(@Param("list") List<SysUserRole> list);

    int insertOrUpdate(SysUserRole record);

    int insertOrUpdateSelective(SysUserRole record);

    /**根据用户id查询用户角色关系
     * @param userId
     * @return
     */
    @Select("SELECT ur.role_id \n" +
            "FROM (sys_role r LEFT JOIN sys_user_role ur ON r.role_id = ur.role_id ) \n" +
            "LEFT JOIN sys_user u ON u.user_id = ur.user_id WHERE u.user_id = #{userId}")
    List<SysUserRole> selectUserRoleListByUserId(Integer userId);
}