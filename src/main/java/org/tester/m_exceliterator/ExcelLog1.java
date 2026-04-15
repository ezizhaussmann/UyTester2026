package org.tester.m_exceliterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @created : 01/04/2026,00:10,mer.
 **/
public class ExcelLog1 {
    public static void main(String[] args) {
        String cheminFichier = "TestDataFolders/log.xlsx";

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(cheminFichier);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2. Créer une nouvelle feuille
            // Note : Vérifiez si le nom n'existe pas déjà pour éviter une exception
            String nomNouvelleFeuille = "product3";
//            workbook sheet = workbook.createSheet(nomNouvelleFeuille);
        Sheet sheet = workbook.createSheet("nomNouvelleFeuille");


//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("ProductInfo1");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("product_Name");
        row.createCell(1).setCellValue("product_code");
        row.createCell(2).setCellValue("product_weight");
        row.createCell(3).setCellValue("product_level");
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("kala");
        row1.createCell(1).setCellValue("01");
        row1.createCell(2).setCellValue("300");
        row1.createCell(3).setCellValue("11");
        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("qoy");
        row2.createCell(1).setCellValue("03");
        row2.createCell(2).setCellValue("40");
        row2.createCell(3).setCellValue("13");
        Row row3 = sheet.createRow(3);
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

