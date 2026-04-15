package org.tester.m_exceliterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @created : 31/03/2026,23:25,mar.
 **/
public class ReadMultiple {
    public static List<String>  getProductInfo(String filename ,String sheetName , String product_Name,int column){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        XSSFSheet sheet = workbook.getSheet(sheetName);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <numberOfSheets ; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> cellIterator = firstrow.iterator();
                while (rows.hasNext()){
                    Row next = rows.next();
                    if (next.getCell(column).getStringCellValue().equalsIgnoreCase(product_Name)){
                        Iterator<Cell> c1 = next.iterator();
                        while (c1.hasNext()){
                            Cell next1 = c1.next();
                            if (next1.getCellType()== CellType.STRING){
                                list.add(next1.getStringCellValue());

                            }else {
                                list.add(NumberToTextConverter.toText(next1.getNumericCellValue()));

                            }
                        }

                    }
                }
            }

        }
        return list;


    }

    public static void main(String[] args) {
        String filename="TestDataFolders/log.xlsx";
        List<String> productInfo=getProductInfo(filename,"product3","toge",0);
        System.out.println(productInfo);
        List<String> info=getProductInfo(filename,"product2","13",3);
        System.out.println(info);

    }

}
