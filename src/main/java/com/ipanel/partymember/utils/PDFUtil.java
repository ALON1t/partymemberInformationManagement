package com.ipanel.partymember.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.experimental.UtilityClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author liyu
 * @date 2019/12/30 10:07
 * @description
 */
@UtilityClass
public class PDFUtil {

    public static void setAttribute(Document document) {
        document.addAuthor("Lokesh Gupta");
        document.addCreationDate();
        document.addCreator("HowToDoInJava.com");
        document.addTitle("Set Attribute Example");
        document.addSubject("An example to show how attributes can be added to pdf files.");
    }

    public static void addImage(Document document) {
        try {
            Image image1 = Image.getInstance("demo.jpg");
            //Fixed Positioning
            image1.setAbsolutePosition(100f, 550f);
            //Scale to new height and new width of image
            image1.scaleAbsolute(200, 200);
            document.add(image1);
            String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
            Image image2 = Image.getInstance(new URL(imageUrl));
            document.add(image2);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTable(Document document) {
        try {
            // 3 columns.
            PdfPTable table = new PdfPTable(3);
            // Width 100%
            table.setWidthPercentage(100);
            // Space before table
            table.setSpacingBefore(10f);
            // Space after table
            table.setSpacingAfter(10f);

            // Set Column widths
            float[] columnWidths = {1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
            cell1.setBorderColor(BaseColor.BLUE);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
            cell2.setBorderColor(BaseColor.GREEN);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
            cell3.setBorderColor(BaseColor.RED);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void addList(Document document) {
        try {
            //Add ordered list
            List orderedList = new List(List.ORDERED);
            orderedList.add(new ListItem("Item 1"));
            orderedList.add(new ListItem("Item 2"));
            orderedList.add(new ListItem("Item 3"));
            document.add(orderedList);

            //Add un-ordered list
            List unorderedList = new List(List.UNORDERED);
            unorderedList.add(new ListItem("Item 1"));
            unorderedList.add(new ListItem("Item 2"));
            unorderedList.add(new ListItem("Item 3"));
            document.add(unorderedList);

            //Add roman list
            RomanList romanList = new RomanList();
            romanList.add(new ListItem("Item 1"));
            romanList.add(new ListItem("Item 2"));
            romanList.add(new ListItem("Item 3"));
            document.add(romanList);

            //Add Greek list
            GreekList greekList = new GreekList();
            greekList.add(new ListItem("Item 1"));
            greekList.add(new ListItem("Item 2"));
            greekList.add(new ListItem("Item 3"));
            document.add(greekList);

            //ZapfDingbatsList List Example
            ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(43, 30);
            zapfDingbatsList.add(new ListItem("Item 1"));
            zapfDingbatsList.add(new ListItem("Item 2"));
            zapfDingbatsList.add(new ListItem("Item 3"));
            document.add(zapfDingbatsList);

            //List and Sublist Examples
            List nestedList = new List(List.UNORDERED);
            nestedList.add(new ListItem("Item 1"));

            List sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("A");
            sublist.add("B");
            nestedList.add(sublist);

            nestedList.add(new ListItem("Item 2"));

            sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("C");
            sublist.add("D");
            nestedList.add(sublist);

            document.add(nestedList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void setStyle(Document document) {
        try {
            Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
            Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
            //Paragraph with color and font styles
            Paragraph paragraphOne = new Paragraph("Some colored paragraph text", redFont);
            document.add(paragraphOne);

            //Create chapter and sections
            Paragraph chapterTitle = new Paragraph("Chapter Title", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            Paragraph sectionTitle = new Paragraph("Section Title", redFont);
            Section section1 = chapter1.addSection(sectionTitle);

            Paragraph sectionContent = new Paragraph("Section Text content", yellowFont);
            section1.add(sectionContent);

            document.add(chapter1);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void readAndModify() {
        try {
            //Read file using PdfReader
            PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

            //Modify file using PdfReader
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorld-modified.pdf"));

            Image image = Image.getInstance("temp.jpg");
            image.scaleAbsolute(100, 50);
            image.setAbsolutePosition(100f, 700f);

            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfContentByte content = pdfStamper.getUnderContent(i);
                content.addImage(image);
            }

            pdfStamper.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
