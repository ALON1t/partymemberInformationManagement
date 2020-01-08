package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysRoleDept;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleDeptMapper extends tk.mybatis.mapper.common.Mapper<SysRoleDept> {
    int updateBatch(List<SysRoleDept> list);

    int batchInsert(@Param("list") List<SysRoleDept> list);

    int insertOrUpdate(SysRoleDept record);

    int insertOrUpdateSelective(SysRoleDept record);
}