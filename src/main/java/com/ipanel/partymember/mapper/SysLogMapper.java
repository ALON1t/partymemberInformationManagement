package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysLog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLogMapper extends tk.mybatis.mapper.common.Mapper<SysLog> {
    int updateBatch(List<SysLog> list);

    int batchInsert(@Param("list") List<SysLog> list);

    int insertOrUpdate(SysLog record);

    int insertOrUpdateSelective(SysLog record);
}