package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends tk.mybatis.mapper.common.Mapper<SysUser> {
    int updateBatch(List<SysUser> list);

    int batchInsert(@Param("list") List<SysUser> list);

    int insertOrUpdate(SysUser record);

    int insertOrUpdateSelective(SysUser record);
}