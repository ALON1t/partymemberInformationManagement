package com.ipanel.partymember.service.impl;

import com.ipanel.partymember.constant.LoginConstant;
import com.ipanel.partymember.exception.BaseException;
import com.ipanel.partymember.mapper.SysUserMapper;
import com.ipanel.partymember.pojo.SysUser;
import com.ipanel.partymember.pojo.SysUserRole;
import com.ipanel.partymember.security.User;
import com.ipanel.partymember.security.util.JwtUtil;
import com.ipanel.partymember.service.SysMenuService;
import com.ipanel.partymember.service.SysUserRoleService;
import com.ipanel.partymember.service.SysUserService;
import com.ipanel.partymember.utils.BCryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liyu
 * @date 2019/11/5 14:31
 * @description
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SysUserRoleService userRoleService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuService menuService;

    @Override
    public int updateBatch(List<SysUser> list) {
        return sysUserMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<SysUser> list) {
        return sysUserMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysUser record) {
        return sysUserMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysUser record) {
        return sysUserMapper.insertOrUpdateSelective(record);
    }

    @Override
    public SysUser findByUserName(String username) {
        return sysUserMapper.selectOne(SysUser.builder().username(username).build());
    }

    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        return menuService.findPermsByUserId(userId).stream()
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> findRoleIdByUserId(Integer userId) {
        List<SysUserRole> sysUserRoles = userRoleService.selectUserRoleListByUserId(userId);
        return userRoleService.selectUserRoleListByUserId(userId)
                .stream()
                .map(sysUserRole-> "ROLE_" + sysUserRole.getRoleId())
                .collect(Collectors.toSet());
    }

    @Override
    public String login(String username, String password, String captcha, HttpServletRequest request) {
        // 验证验证码
        // 从redis中获取之前保存的验证码跟前台传来的验证码进行匹配
        String kaptcha = redisTemplate.opsForValue().get(LoginConstant.PRE_IMAGE_SESSION_KEY);
        if (kaptcha == null) {
            throw new BaseException("验证码已失效");
        }
        if (!captcha.toLowerCase().equals(kaptcha)) {
            throw new BaseException("验证码错误");
        }

        //用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername()去验证用户名和密码，
            // 如果正确，则存储该用户名密码到security 的 context中
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new BaseException("用户名或密码错误", 402);
            } else if (e instanceof DisabledException) {
                throw new BaseException("账户被禁用", 402);
            } else if (e instanceof AccountExpiredException) {
                throw new BaseException("账户过期无法验证", 402);
            } else {
                throw new BaseException("账户被锁定,无法登录", 402);
            }
        }

        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        User userDetail = (User) authentication.getPrincipal();
        return JwtUtil.generateToken(userDetail);
    }

    @Override
    public String register(String username, String password, String email, String phone) {

        SysUser sysUser = new SysUser();
        sysUser.setUserId(null);
        sysUser.setUsername(username);
        sysUser.setPassword(BCryptUtil.encode(password));
        sysUser.setEmail(email);
        sysUser.setPhone(phone);
        int insert = sysUserMapper.insert(sysUser);
        System.out.println("insert = " + insert);
        if (insert == 1) {
            return null;
        } else {
            throw new BaseException("注册失败,新增用户失败", 403);
        }

    }

}
