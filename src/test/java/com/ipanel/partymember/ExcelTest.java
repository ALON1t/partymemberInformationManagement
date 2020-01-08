package com.ipanel.partymember;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ipanel.partymember.bean.ComplexHeadData;
import com.ipanel.partymember.bean.User;
import com.ipanel.partymember.util.TestFileUtil;
import com.ipanel.partymember.utils.PathUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author liyu
 * @date 2020/1/8 9:11
 * @description easyExcel使用
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcelTest {

    /**
     * 最简单的写
     * 1. 创建excel对应的实体对象
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() throws IOException {
        // 写法1
        String fileName = PathUtil.toAbsolutePath("resources/templates/excel/simpleWrite" + System.currentTimeMillis() + ".xlsx","src\\main\\");
//        System.out.println("fileName = " + fileName);
//        File file =Paths.get(fileName).toFile();
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(file, User.class).sheet("模板").doWrite(data());

        //写法2
//        System.out.println("fileName = " + fileName);
//        ExcelWriter excelWriter = EasyExcelFactory.write(new FileOutputStream(fileName), User.class).build();
//        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//        excelWriter.write(data(),writeSheet);
//        excelWriter.finish();

        // 写法3
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }


    /**
     * 忽略或只需要某一列导出
     */
    @Test
    public void excludeOrIncludeWrite() {
        String fileName = PathUtil.toAbsolutePath("resources/templates/excel/excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx","src\\main\\");

//        // 根据用户传入字段 假设我们要忽略 date
//        Set<String> excludeColumnFiledNames = new HashSet<String>();
//        excludeColumnFiledNames.add("age");
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        EasyExcel.write(fileName, User.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
//                .doWrite(data());

        // 根据用户传入字段 假设我们只要导出 date
        Set<String> includeColumnFiledNames = new HashSet<String>();
        includeColumnFiledNames.add("name");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, User.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板")
                .doWrite(data());
    }

    /**
     * 复杂表头测试
     */
    @Test
    public void complexHeadWrite() {
        String fileName = PathUtil.toAbsolutePath("resources/templates/excel/complexHeadWrite" + System.currentTimeMillis() + ".xlsx","src\\main\\");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(data());
    }


    private List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("李宇" + i);
            user.setAge(i);
            user.setSex("男");
            user.setPhoto("http://8080:nnnnnn");
            user.setBirthday(new Date());

            list.add(user);
        }
        return list;
    }
}
