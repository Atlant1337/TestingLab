package com.testing.ApachePOI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ApachePOI {

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("tag1Name1");

        XSSFFont font = workbook.createFont();
        font.setBold(true);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFRow row1 = sheet.createRow(0);

        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("tag2Id");
        cell1.setCellStyle(style);
        XSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("t1");
        cell2.setCellStyle(style);
        XSSFCell cell3 = row1.createCell(2);
        cell3.setCellValue("t2");
        cell3.setCellStyle(style);
        XSSFCell cell4 = row1.createCell(3);
        cell4.setCellValue("t3");
        cell4.setCellStyle(style);
        XSSFCell cell5 = row1.createCell(4);
        cell5.setCellValue("t4");
        cell5.setCellStyle(style);
        XSSFCell cell7 = row1.createCell(5);
        cell7.setCellValue("listElemets");
        cell7.setCellStyle(style);
        XSSFCell cell8 = row1.createCell(6);
        cell8.setCellValue("t5");
        cell8.setCellStyle(style);

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("2", new Object[] {"001", "string", "string", "date or int", "string", "1. string\n" +
                "   2. string\n", "int"});
        data.put("3", new Object[] {"002", "string", "string", "date or int", "string", "1. string\n" +
                "   2. string\n", "001"});

        XSSFSheet sheet2 = workbook.createSheet("tag1Name2");
        XSSFRow row4 = sheet2.createRow(0);
        XSSFCell cell12 = row4.createCell(0);
        cell12.setCellValue("tag2Id");
        cell12.setCellStyle(style);
        XSSFCell cell22 = row4.createCell(1);
        cell22.setCellValue("t1");
        cell22.setCellStyle(style);
        XSSFCell cell32 = row4.createCell(2);
        cell32.setCellValue("t2");
        cell32.setCellStyle(style);
        XSSFCell cell42 = row4.createCell(3);
        cell42.setCellValue("t3");
        cell42.setCellStyle(style);
        XSSFCell cell52 = row4.createCell(4);
        cell52.setCellValue("t4");
        cell52.setCellStyle(style);
        XSSFCell cell72 = row4.createCell(5);
        cell72.setCellValue("listElemets");
        cell72.setCellStyle(style);
        XSSFCell cell82 = row4.createCell(6);
        cell82.setCellValue("t5");
        cell82.setCellStyle(style);

        Map<String, Object[]> data2 = new TreeMap<String, Object[]>();
        data2.put("3", new Object[] {"003", "string", "string", "date or int", "string", "1. string\n" +
                "   2. string\n", "int"});
        data2.put("4", new Object[] {"004", "string", "string", "date or int", "string", "1. string\n" +
                "   2. string\n", "002"});

        Set<String> keyset = data.keySet();
        int rownum = 1;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        Set<String> keyset2 = data2.keySet();
        int rownum2 = 1;
        for (String key2 : keyset2)
        {
            Row row2 = sheet2.createRow(rownum2++);
            Object [] objArr2 = data2.get(key2);
            int cellnum2 = 0;
            for (Object obj2 : objArr2)
            {
                Cell cell = row2.createCell(cellnum2++);
                if(obj2 instanceof String)
                    cell.setCellValue((String)obj2);
                else if(obj2 instanceof Integer)
                    cell.setCellValue((Integer)obj2);
            }
        }
        try
        {
            FileOutputStream out = new FileOutputStream(new File("Excel.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel.xlsx written successfully.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

