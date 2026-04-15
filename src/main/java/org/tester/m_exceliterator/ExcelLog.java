package org.tester.m_exceliterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @created : 31/03/2026,18:53,mar.
 **/
public class ExcelLog {
    public static void main(String[] args) {
//        String cheminFichier = "TestDataFolders/log.xlsx";
//        FileOutputStream fileOutputStream = null;
//
//        try {
//            FileInputStream inputStream = new FileInputStream(cheminFichier);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        File file = new File("TestDataFolders/log.xlsx");
//        System.out.println("Folder et file est crée");

//        String fileName="loginU";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("ProductInfo");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("product_Name");
        row.createCell(1).setCellValue("product_code");
        row.createCell(2).setCellValue("product_weight");
        row.createCell(3).setCellValue("product_level");
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("kala");
        row1.createCell(1).setCellValue("01");
        row1.createCell(2).setCellValue("300");
        row1.createCell(3).setCellValue("11");
        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("qoy");
        row2.createCell(1).setCellValue("03");
        row2.createCell(2).setCellValue("40");
        row2.createCell(3).setCellValue("13");
        XSSFRow row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("toge");
        row3.createCell(1).setCellValue("02");
        row3.createCell(2).setCellValue("150");
        row3.createCell(3).setCellValue("12");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("TestDataFolders/log.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fichier Excel créé avec succès !");



    }
}
