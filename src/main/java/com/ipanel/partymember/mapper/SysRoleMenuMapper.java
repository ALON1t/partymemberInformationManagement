package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysRoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuMapper extends tk.mybatis.mapper.common.Mapper<SysRoleMenu> {
    int updateBatch(List<SysRoleMenu> list);

    int batchInsert(@Param("list") List<SysRoleMenu> list);

    int insertOrUpdate(SysRoleMenu record);

    int insertOrUpdateSelective(SysRoleMenu record);
}