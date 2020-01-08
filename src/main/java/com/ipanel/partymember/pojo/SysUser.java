package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "sys_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

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
     * 部门ID
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 岗位ID
     */
    @Column(name = "job_id")
    private Integer jobId;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0-正常，1-锁定
     */
    @Column(name = "lock_flag")
    private String lockFlag;

    /**
     * 0-正常，1-删除
     */
    @Column(name = "del_flag")
    private String delFlag;

    private static final long serialVersionUID = 1L;
}