package com.ipanel.partymember;

import com.spire.doc.*;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TableRowHeightType;
import com.spire.doc.documents.VerticalAlignment;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author liyu
 * @date 2019/11/12 9:28
 * @description
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpireDocTest {

    @Test
    //在Word中，表格可以帮助我们更加清晰、直观地分析和展示数据。本文将介绍如何使用Spire.Doc for Java在Word文档中创建表格。
    public void demo1() {

        //创建Word文档
        Document document = new Document();

        //消除水印
        document.addSection();
        document.getSections().removeAt(0);

        //添加一个section
        Section section = document.addSection();

        //数据
        String[] header = {"姓名", "性别", "部门", "工号"};
        String[][] data =
                {
                        new String[]{"Winny", "女", "综合", "0109"},
                        new String[]{"Lois", "女", "综合", "0111"},
                        new String[]{"Jois", "男", "技术", "0110"},
                        new String[]{"Moon", "女", "销售", "0112"},
                        new String[]{"Vinit", "女", "后勤", "0113"},
                };

        //添加表格
        Table table = section.addTable(true);
        //设置表格的行数和列数
        table.resetCells(data.length + 1, header.length);

        //设置第一行作为表格的表头并添加数据
        TableRow row = table.getRows().get(0);
        row.isHeader(true);
        row.setHeight(20);
        row.setHeightType(TableRowHeightType.Exactly);
        row.getRowFormat().setBackColor(Color.gray);
        for (int i = 0; i < header.length; i++) {
            row.getCells().get(i).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
            Paragraph p = row.getCells().get(i).addParagraph();
            p.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
            TextRange range1 = p.appendText(header[i]);
            range1.getCharacterFormat().setFontName("Arial");
            range1.getCharacterFormat().setFontSize(12f);
            range1.getCharacterFormat().setBold(true);
        }

        //添加数据到剩余行
        for (int r = 0; r < data.length; r++) {
            TableRow dataRow = table.getRows().get(r + 1);
            dataRow.setHeight(25);
            dataRow.setHeightType(TableRowHeightType.Exactly);
            dataRow.getRowFormat().setBackColor(Color.white);
            for (int c = 0; c < data[r].length; c++) {
                dataRow.getCells().get(c).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                TextRange range2 = dataRow.getCells().get(c).addParagraph().appendText(data[r][c]);
                range2.getCharacterFormat().setFontName("Arial");
                range2.getCharacterFormat().setFontSize(10f);
            }
        }

        //设置单元格背景颜色
        for (int j = 1; j < table.getRows().getCount(); j++) {
            if (j % 2 == 0) {
                TableRow row2 = table.getRows().get(j);
                for (int f = 0; f < row2.getCells().getCount(); f++) {
                    row2.getCells().get(f).getCellFormat().setBackColor(new Color(173, 216, 230));
                }
            }
        }

        //保存文档
        document.saveToFile("Demo1.docx", FileFormat.Docx_2013);
    }


    @Test
    //嵌套表格，即在一个大的表格单元格中再嵌进去一个或几个小的表格，使表格内容布局合理。以下示例中，将介绍通过Spire.Doc for Java 在Word表格中添加嵌套表格的方法。
    public void demo2() throws FileNotFoundException {
        //加载测试文档
        InputStream inputStream = this.getClass().getResourceAsStream("/templates/word/围场县农村干部人事档案综合信息登记表（模板）.doc");
        Document doc = new Document(inputStream);
        Section sec = doc.getSections().get(0);

        Table table = sec.getTables().get(0);
        InputStream inputStream2 = this.getClass().getResourceAsStream("/templates/word/suda.png");
        DocPicture docPicture = table.get(0, 6).addParagraph().appendPicture(inputStream2);

//        docPicture.setWidth(80f);
//        docPicture.setHeight(140f);


        File outFile = new File("C:/Users/lenovo/Desktop/新建文件夹/liyu.doc");

        doc.saveToFile(new FileOutputStream(outFile), FileFormat.Docx_2013);


    }
}
