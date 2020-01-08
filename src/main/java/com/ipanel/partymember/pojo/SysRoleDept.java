package com.ipanel.partymember.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_role_dept")
public class SysRoleDept implements Serializable {
    /**
     * 部门主键ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Integer deptId;

    private static final long serialVersionUID = 1L;
}