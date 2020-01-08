package com.ipanel.partymember.mapper;

import com.ipanel.partymember.pojo.SysDept;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lenovo
 */
@Mapper
public interface SysDeptMapper extends tk.mybatis.mapper.common.Mapper<SysDept> {
    int updateBatch(List<SysDept> list);

    int batchInsert(@Param("list") List<SysDept> list);

    int insertOrUpdate(SysDept record);

    int insertOrUpdateSelective(SysDept record);
}