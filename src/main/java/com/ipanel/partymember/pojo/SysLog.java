package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_log")
public class SysLog implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 操作IP
     */
    @Column(name = "request_ip")
    private String requestIp;

    /**
     * 操作类型 1 操作记录2异常记录
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 操作人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 请求方法
     */
    @Column(name = "action_method")
    private String actionMethod;

    @Column(name = "action_url")
    private String actionUrl;

    /**
     * 请求参数
     */
    @Column(name = "params")
    private String params;

    /**
     * 浏览器
     */
    @Column(name = "ua")
    private String ua;

    /**
     * 类路径
     */
    @Column(name = "class_path")
    private String classPath;

    /**
     * 请求方法
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 消耗时间
     */
    @Column(name = "consuming_time")
    private Long consumingTime;

    /**
     * 异常详情信息
     */
    @Column(name = "ex_desc")
    private String exDesc;

    /**
     * 异常描述
     */
    @Column(name = "ex_detail")
    private String exDetail;

    private static final long serialVersionUID = 1L;
}