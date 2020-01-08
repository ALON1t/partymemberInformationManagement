package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_db")
public class SysDb implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 数据库类型
     */
    @Column(name = "db_type")
    private String dbType;

    /**
     * 数据库地址
     */
    @Column(name = "`host`")
    private Integer host;

    /**
     * 数据库端口
     */
    @Column(name = "port")
    private String port;

    /**
     * 数据库名称
     */
    @Column(name = "db_name")
    private String dbName;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}