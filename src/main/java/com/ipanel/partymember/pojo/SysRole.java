package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_role")
public class SysRole implements Serializable {
    /**
     * 角色主键
     */
    @Id
    @Column(name = "role_id")
    @GeneratedValue(generator = "JDBC")
    private Integer roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色标识
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

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

    /**
     * 删除标识（0-正常,1-删除）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 数据权限类型
     */
    @Column(name = "ds_type")
    private Integer dsType;

    /**
     * 数据权限范围 1 全部 2 本级 3 本级以及子级 4 自定义
     */
    @Column(name = "ds_scope")
    private String dsScope;

    private static final long serialVersionUID = 1L;
}