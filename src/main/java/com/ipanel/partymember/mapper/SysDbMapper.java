package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysDb;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lenovo
 */
@Mapper
public interface SysDbMapper extends tk.mybatis.mapper.common.Mapper<SysDb> {
    int updateBatch(List<SysDb> list);

    int batchInsert(@Param("list") List<SysDb> list);

    int insertOrUpdate(SysDb record);

    int insertOrUpdateSelective(SysDb record);
}