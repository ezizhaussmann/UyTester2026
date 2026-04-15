package org.tester.tekrar.a_tekrar.g_excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @created : 31/03/2026,19:05,mar.
 **/
public class ExcelLogTest {
    public static void main(String[] args) {
        String fileName="TestDataFolders/log.xlsx";
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
        XSSFSheet sheet = workbook.getSheet("Logins");
        XSSFRow row = sheet.getRow(1);
        String user = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        WebDriver driver = new ChromeDriver();
        try {


        driver.get("https://demo.cubecart.com/admin_5xArPd.php"); // Remplacez par votre URL

        // Remplissage des champs (adaptez les sélecteurs 'id' ou 'name')
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);

        // Clic sur le bouton de connexion
        driver.findElement(By.id("login")).click();

        System.out.println("Tentative de connexion avec : " + user);

    }finally {
            driver.quit();
        }
        }
}
