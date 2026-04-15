package org.tester.tekrar.a_tekrar.g_excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @created : 31/03/2026,18:15,mar.
 **/
public class Excel1 {
    public static void main(String[] args) {
        String fileName = "TestDataFolders/login.xlsx";

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("LoginUser");
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        System.out.println("*********************************");
        int totalLignes = sheet.getLastRowNum();     // nombre total de lignes
        int totalColonnes = sheet.getRow(0).getLastCellNum(); // nombre total de colonnes

        System.out.println("Lignes : " + totalLignes);
        System.out.println("Colonnes : " + totalColonnes);
        System.out.println("---------------------------------------------------");
        for (int i = 0; i <= totalLignes; i++) {
            XSSFRow rows = sheet.getRow(i);

            for (int j = 0; j < totalColonnes; j++) {
                XSSFCell cells = row.getCell(j);
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
