package com.ipanel.partymember;

import com.ipanel.partymember.utils.PDFUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liyu
 * @date 2019/12/27 18:24
 * @description
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PDFTest {
    PdfTemplate template;
    PdfTemplate template1;

    /**
     * 简单的pdf生成测试
     */
    @Test
    public void simplePdf() throws FileNotFoundException, DocumentException {
//创建文档写入器
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        writer.setStrictImageSequence(true);
        //设置权限
//        writer.setEncryption("".getBytes(), "".getBytes(),
//                //Only printing allowed; Try to copy text !!
//                PdfWriter.ALLOW_PRINTING,
//                PdfWriter.ENCRYPTION_AES_128);

        //设置密码
//        writer.setEncryption("password".getBytes(),
//                "lokesh".getBytes(), PdfWriter.ALLOW_PRINTING,
//                PdfWriter.ENCRYPTION_AES_128);

        //打开文档
        document.open();
        document.add(new Paragraph("A Hello World PDF document."));

        //设置属性
        PDFUtil.setAttribute(document);

        //增加图像
        PDFUtil.addImage(document);

        //添加表格
        PDFUtil.addTable(document);

        //创建列表
        PDFUtil.addList(document);

        //设置样式
        PDFUtil.setStyle(document);

        //读取修改pdf
        PDFUtil.readAndModify();

        //关闭文档
        document.close();
        writer.close();

//        String filepath = "D:\\javaWorkplace\\ideaWorkplace\\partymemberInformationManagement\\src\\main\\resources\\templates\\pdf";
//        String pdfName = "simplePdf";
//        //1.创建一个document
//        Document document = new Document(PageSize.A4);
//        //2.定义pdfWriter，指明文件输出流输出到一个文件,定义writer写入页码等
//        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(filepath + File.separator + pdfName + ".pdf"));
//        //3.打开文档
//        document.open();
//        //4.创建模板存放页码内容以及模块大小
//        template = pdfWriter.getDirectContent().createTemplate(100, 100);
//        template1 = pdfWriter.getDirectContent().createTemplate(100, 100);
//        //5.显示固定页码位置
//        getTotalNum(pdfWriter);
//
//        //第一行
//        PdfPCell pdfPCell = new PdfPCell();
//        Paragraph elements = new Paragraph();
//        Chunk chunk = new Chunk("*****cccccc******");
//        elements.add(new Paragraph(chunk));
//        BaseFont baseFont;
//        Font font = new Font(Font.FontFamily.TIMES_ROMAN, (float) 10.5, Font.BOLD);
//        elements.add(new Paragraph("" + "Automotive Components" + "Co., Ltd.", font));
//        pdfPCell.setPhrase(elements);
//        document.add(pdfPCell);
//
//        document.close();
//        pdfWriter.close();

    }

    private void getTotalNum(PdfWriter writer) {
        PdfContentByte cb = writer.getDirectContent();
        cb.saveState();
        //** 创建以及固定显示总页数的位置
        cb.addTemplate(template, 205, 720);//定位“y页” 在具体的页面调试时候需要更改这xy的坐标

//            cb.saveState();
        cb.stroke();
        cb.restoreState();
        cb.closePath();
    }

//    //** 显示总页数
//    public void onCloseDocument(PdfWriter writer, Document document) {
////        //关闭document的时候获取总页数，并把总页数按模版写道之前预留的位置
//        template.beginText();
//        template.setFontAndSize(BaseFont.TIMES_ROMAN, 8);
//        template.showText(Integer.toString(writer.getPageNumber() )+"页");
//        template.endText();
//        template.closePath();//sanityCheck();
//    }
}
