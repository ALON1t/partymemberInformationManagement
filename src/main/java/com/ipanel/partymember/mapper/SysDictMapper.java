package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysDict;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysDictMapper extends tk.mybatis.mapper.common.Mapper<SysDict> {
    int updateBatch(List<SysDict> list);

    int batchInsert(@Param("list") List<SysDict> list);

    int insertOrUpdate(SysDict record);

    int insertOrUpdateSelective(SysDict record);
}