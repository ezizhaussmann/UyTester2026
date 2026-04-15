package org.tester.tekrar.a_tekrar.g_excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @created : 31/03/2026,18:53,mar.
 **/
public class ExcelLog {
    public static void main(String[] args) {

//        String fileName="loginU";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Logins");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("user_name");
        row.createCell(1).setCellValue("password");
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("cubecart");
        row1.createCell(1).setCellValue("cubecart");
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
