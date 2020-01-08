package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    /**
     * 菜单ID
     */
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(generator = "JDBC")
    private Integer menuId;

    /**
     * 菜单名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 菜单权限标识
     */
    @Column(name = "perms")
    private String perms;

    /**
     * 前端跳转URL
     */
    @Column(name = "`path`")
    private String path;

    /**
     * 菜单组件
     */
    @Column(name = "component")
    private String component;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 菜单类型 （类型   0：目录   1：菜单   2：按钮）
     */
    @Column(name = "`type`")
    private String type;

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
     * 逻辑删除标记(0--正常 1--删除)
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 是否为外链
     */
    @Column(name = "is_frame")
    private Boolean isFrame;

    private static final long serialVersionUID = 1L;
}