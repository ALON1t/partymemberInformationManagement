package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_dept")
public class SysDept implements Serializable {
    /**
     * 部门主键ID
     */
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(generator = "JDBC")
    private Integer deptId;

    /**
     * 部门名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

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
     * 是否删除  -1：已删除  0：正常
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 上级部门
     */
    @Column(name = "parent_id")
    private Integer parentId;

    private static final long serialVersionUID = 1L;
}