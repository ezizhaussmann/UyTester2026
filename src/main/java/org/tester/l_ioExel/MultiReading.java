package org.tester.l_ioExel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @created : 30/03/2026,16:37,lun.
 **/
public class MultiReading {
    public static void main(String[] args) {
        String fileName = "TestDataFolders/login.xlsx";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        workbook.getSheetAt(0);
//        XSSFWorkbook sheets = new XSSFWorkbook();
//        XSSFWorkbook row = new XSSFWorkbook();
        XSSFSheet sheet = workbook.getSheet("LoginUser");
        int rowNum = sheet.getLastRowNum();
        short columnNumber = sheet.getRow(1).getLastCellNum();
        System.out.println("Row number is: " + rowNum);
        System.out.println(" Column number is: " + columnNumber);
        for (int row = 1; row <rowNum ; row++) {
            XSSFRow rows=sheet.getRow(row);
        for (int cell = 0; cell<columnNumber; cell++){
            XSSFCell columns = rows.getCell(cell);
            CellType cellType = columns.getCellType();
            switch (cellType){
                case STRING :
                    System.out.print(columns.getStringCellValue());
                    break;
                case NUMERIC:
                    System.out.print((long) columns.getNumericCellValue()); // cast pour éviter "123.0"
                    break;
                default:
                    System.out.print("N/A");
                    break;
            }
            System.out.print(" | ");
        }



            System.out.println();
        }


    }
}