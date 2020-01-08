package com.ipanel.partymember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liyu
 */
@SpringBootApplication
@MapperScan("com.ipanel.partymember.mapper")
public class PartymemberInformationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartymemberInformationManagementApplication.class, args);
    }

//    @Bean
//    public RedisTemplate createRedisTemplate(){
//        return new RedisTemplate();
//    }

}
