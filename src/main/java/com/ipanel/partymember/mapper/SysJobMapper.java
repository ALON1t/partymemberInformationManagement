package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysJob;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysJobMapper extends tk.mybatis.mapper.common.Mapper<SysJob> {
    int updateBatch(List<SysJob> list);

    int batchInsert(@Param("list") List<SysJob> list);

    int insertOrUpdate(SysJob record);

    int insertOrUpdateSelective(SysJob record);
}