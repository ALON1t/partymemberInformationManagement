package com.ipanel.partymember.log;

import java.lang.annotation.*;

/**
 * @author liyu
 * @date 2019/11/5 14:34
 * @description 日志注解
 */
//元注解，定义注解被保留策略，一般有三种策略
//1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
//2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候被抛弃，这个是默认的声明周期
//3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
@Retention(RetentionPolicy.RUNTIME)
//定义了注解声明在哪些元素之前
@Target({ElementType.METHOD})
@Documented
public @interface SysLog {
    /**
     * 定义成员
     */
    //描述
    String descrption() default "" ;
}
