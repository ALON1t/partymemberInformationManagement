package com.ipanel.partymember.service;

import java.util.List;
import java.util.Set;

import com.ipanel.partymember.pojo.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyu
 * @date 2019/11/5 14:31
 * @description
 */
public interface SysUserService {


    int updateBatch(List<SysUser> list);

    int batchInsert(List<SysUser> list);

    int insertOrUpdate(SysUser record);

    int insertOrUpdateSelective(SysUser record);

    SysUser findByUserName(String username);

    Set<String> findPermsByUserId(Integer userId);

    /**
     * 根据用户id查询角色id
     * @param userId
     * @return
     */
    Set<String> findRoleIdByUserId(Integer userId);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    String login(String username, String password, String captcha, HttpServletRequest request);

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    String register(String username, String password, String email, String phone);
}
