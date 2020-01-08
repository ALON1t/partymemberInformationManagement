package com.ipanel.partymember.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable {
    /**
     * 主键ID
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
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}