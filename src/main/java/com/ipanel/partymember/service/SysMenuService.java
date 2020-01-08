package com.ipanel.partymember.service;

import java.util.List;

import com.ipanel.partymember.pojo.SysMenu;

/**
 * @author liyu
 * @date 2019/11/5 14:31
 * @description
 */
public interface SysMenuService {


    int updateBatch(List<SysMenu> list);

    int batchInsert(List<SysMenu> list);

    int insertOrUpdate(SysMenu record);

    int insertOrUpdateSelective(SysMenu record);

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    List<String> findPermsByUserId(Integer userId);
}
