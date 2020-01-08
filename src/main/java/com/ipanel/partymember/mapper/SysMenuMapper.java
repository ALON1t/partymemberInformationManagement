package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysMenuMapper extends tk.mybatis.mapper.common.Mapper<SysMenu> {
    int updateBatch(List<SysMenu> list);

    int batchInsert(@Param("list") List<SysMenu> list);

    int insertOrUpdate(SysMenu record);

    int insertOrUpdateSelective(SysMenu record);

    /**
     * 通过userid查询对应的菜单权限
     * @param userId
     * @return
     */
    @Select("select m.perms from sys_menu m, sys_user u, sys_user_role ur, sys_role_menu rm\n" +
            "        where u.user_id = #{user_id} and u.user_id = ur.user_id\n" +
            "          and ur.role_id = rm.role_id and rm.menu_id = m.menu_id")
    List<String> findPermsByUserId(Integer userId);
}