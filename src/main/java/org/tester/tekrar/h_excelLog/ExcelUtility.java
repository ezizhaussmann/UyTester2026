package org.tester.tekrar.h_excelLog;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created : 31/03/2026,19:26,mar.
 **/
public class ExcelUtility {
//    public String readFromExcelColum(String fileName, String sheetName, int rowNumber, int columNumber) {
//
//    }
//
//        public List<AdminCredentials> readAdmincredentials (String fileName, String sheetName){
//            FileInputStream fis = null;
//            try {
//                fis = new FileInputStream(fileName);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            XSSFWorkbook workbook = null;
//            try {
//                workbook = new XSSFWorkbook(fis);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            XSSFSheet sheet = workbook.getSheet(sheetName);
//            List<AdminCredentials> credentials = new ArrayList<>();
//            int rowcount = sheet.getLastRowNum();
//            for (int i = 0; i <= rowcount; i++) {
//                XSSFRow row = sheet.getRow(i);
//                XSSFCell userN = row.getCell(0);
//                XSSFCell pass = row.getCell(1);
//                AdminCredentials adminCredentials1 = new AdminCredentials(userN.getStringCellValue()
//                        , pass.getStringCellValue());
//                credentials.add(adminCredentials1);
//
//
//            }
//            return credentials;
//        }
//    }
}






