package com.ipanel.partymember;

import com.ipanel.partymember.utils.BCryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liyu
 * @date 2019/11/7 15:55
 * @description 测试工具类
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UtillsTest {

    @Test
    public void BCryptUtilTest(){
        String password="123456";
        String encode = BCryptUtil.encode(password);
        System.out.println("encode = " + encode);
        boolean b = BCryptUtil.validatePass(password, encode);
        System.out.println("b = " + b);
    }
}
