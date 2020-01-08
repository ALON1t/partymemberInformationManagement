package com.ipanel.partymember.controller;

import com.ipanel.partymember.constant.LoginConstant;
import com.ipanel.partymember.service.SysUserService;
import com.ipanel.partymember.utils.CaptchaUtil;
import com.ipanel.partymember.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author liyu
 * @date 2019/11/5 16:35
 * @description 登录类 登录，登出，验证码，注册
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 请求登录接口
     *
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @GetMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        return R.ok(userService.login(username, password, captcha, request));
    }

    /**
     * 登出 只需要前端清除token即可 暂时返回success
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        return "success";
    }

    /**
     * 生成验证码图片
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成图片验证码
        BufferedImage image = CaptchaUtil.createImage();
        // 生成文字验证码
        String randomText = CaptchaUtil.drawRandomText(image);
        // 保存到验证码到 redis 有效期两分钟
        redisTemplate.opsForValue().set(LoginConstant.PRE_IMAGE_SESSION_KEY, randomText.toLowerCase(), 2, TimeUnit.MINUTES);
        System.out.println("randomText = " + randomText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg", out);
    }

    /**
     * 用户注册 注册前应先调用接口查询用户名是否重复
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @PostMapping("register")
    public R register(@RequestParam(value = "username", required = true) String username,
                      @RequestParam(value = "password", required = true) String password,
                      @RequestParam(value = "email", required = false) String email,
                      @RequestParam(value = "phone", required = false) String phone) {

        return R.ok(userService.register(username,password,email,phone));
    }
}
