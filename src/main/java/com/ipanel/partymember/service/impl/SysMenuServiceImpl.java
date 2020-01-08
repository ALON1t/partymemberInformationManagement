package com.ipanel.partymember.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ipanel.partymember.pojo.SysMenu;
import com.ipanel.partymember.mapper.SysMenuMapper;
import com.ipanel.partymember.service.SysMenuService;
/**
 * @author  liyu
 * @date  2019/11/5 14:31
 * @description 
 */
@Service
public class SysMenuServiceImpl implements SysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public int updateBatch(List<SysMenu> list) {
        return sysMenuMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysMenu> list) {
        return sysMenuMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysMenu record) {
        return sysMenuMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysMenu record) {
        return sysMenuMapper.insertOrUpdateSelective(record);
    }

    @Override
    public List<String> findPermsByUserId(Integer userId) {
        return sysMenuMapper.findPermsByUserId(userId);
    }

}
