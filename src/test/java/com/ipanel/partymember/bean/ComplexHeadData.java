package com.ipanel.partymember.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liyu
 * @date 2020/1/8 14:12
 * @description
 */
@Data
public class ComplexHeadData {
    @ExcelProperty({"信息表", "姓名"})
    private String name;
    @ExcelProperty({"信息表", "年龄"})
    private Integer age;
    @ExcelProperty({"信息表", "性别"})
    private String sex;
}
