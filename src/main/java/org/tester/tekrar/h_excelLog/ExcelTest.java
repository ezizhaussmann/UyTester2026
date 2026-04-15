package org.tester.tekrar.h_excelLog;

/**
 * @created : 31/03/2026,20:18,mar.
 **/
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {

    // 1. Méthode pour lire une cellule spécifique (corrigée)
    public String readFromExcelColumn(String fileName, String sheetName, int rowNumber, int columnNumber) {
        try (FileInputStream fis = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNumber);
            if (row == null) return "";

            XSSFCell cell = row.getCell(columnNumber);
            return (cell == null) ? "" : cell.getStringCellValue();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 2. Méthode pour lire tous les identifiants (corrigée)
    public List<AdminCredentials> readAdminCredentials() {
        List<AdminCredentials> credentials = new ArrayList<>();

        // Utilisation du try-with-resources pour fermer automatiquement les flux
        String fileName = null;
        try (FileInputStream fis = new FileInputStream("TestDataFolders/log.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            String sheetName = null;
            XSSFSheet sheet = workbook.getSheet("Logins");
            int rowCount = sheet.getLastRowNum();

            // On commence souvent à i = 1 si la ligne 0 est l'en-tête (Header)
            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                XSSFCell userN = row.getCell(0);
                XSSFCell pass = row.getCell(1);

                if (userN != null && pass != null) {
                    AdminCredentials creds = new AdminCredentials(
                            userN.getStringCellValue(),
                            pass.getStringCellValue()
                    );
                    credentials.add(creds);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}
