package com.ipanel.partymember.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_dict")
public class SysDict implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 数据值
     */
    @Column(name = "`value`")
    private String value;

    /**
     * 标签名
     */
    @Column(name = "`label`")
    private String label;

    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 排序（升序）
     */
    @Column(name = "sort")
    private Integer sort;

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
     * 备注信息
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    private static final long serialVersionUID = 1L;
}