package org.tester.m_exceliterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created : 01/04/2026,16:31,mer.
 **/
public class WriteToExcel {
    public void writeContenToExcel(String fileName ,String sheetName ,List<String> contents){
        File excelFile = new File(fileName);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(excelFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowSize=contents.size();
        for (int rowNumber = 0; rowNumber < rowSize; rowNumber++) {
            XSSFRow row = sheet.createRow(rowNumber);
            String[] split = contents.get(rowNumber).split(",");
            int totalCell = split.length;
            for (int cellNumber = 0; cellNumber < totalCell; cellNumber++) {
                XSSFCell cell = row.createCell(cellNumber);
                cell.setCellValue(split[cellNumber]);

            }


        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("user name,password");
       list.add("cubecart,cubecart");
       list.add("cubecart1,cubecart");
        WriteToExcel writeToExcel = new WriteToExcel();
        String fileN="TestDataFolders/AdminUserInfo.xlsx";
        writeToExcel.writeContenToExcel(fileN,"userInfo",list);



    }
}
