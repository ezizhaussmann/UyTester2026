package org.tester.aa_base;

/**
 * @created : 01/04/2026,17:54,mer.
 **/


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AlertScreenshotExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1. Aller sur une page qui génère de vraies alertes JS
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.manage().window().maximize();

            // 2. Cliquer sur le bouton qui déclenche l'alerte
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

            // 3. Attendre que l'alerte soit présente et l'accepter
            // Note: On ne peut pas prendre de screenshot TANT QUE l'alerte est ouverte
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Message de l'alerte : " + alert.getText());
            alert.accept();

            // 4. Une fois l'alerte fermée, on prend la capture d'écran
            // pour prouver qu'on a bien cliqué sur "OK"
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String fileName = "alerte_acceptee_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(source, new File(fileName));

            System.out.println("Capture d'écran réussie : " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
