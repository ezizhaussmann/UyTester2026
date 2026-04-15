package org.tester.aa_base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

public class ScreenshotExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Création d'un objet d'attente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            // CORRECTION : Gérer la modale des cookies (HTML) au lieu d'une Alert
            try {
                // On cherche le bouton "Tout accepter" (l'ID peut varier selon la langue,
                // le sélecteur ci-dessous est assez générique pour le bouton d'acceptation)
                WebElement btnAccepter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/div[contains(text(),'Tout accepter')] | //button/div[contains(text(),'I agree')]")));
                btnAccepter.click();
            } catch (TimeoutException e) {
                System.out.println("Pas de fenêtre de cookies affichée.");
            }

            // 2. Interaction
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.sendKeys("Selenium Java TakesScreenshot" + Keys.ENTER);

            // Attendre un peu que les résultats s'affichent avant la capture
            Thread.sleep(2000);
            ChromeOptions options = new ChromeOptions();
// Empêche Selenium d'être détecté comme un automate par certains scripts
//            options.addArguments("--disable-blink-features=AutomationControlled");
//            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//            options.setExperimentalOption("useAutomationExtension", false);
//
//            driver = new ChromeDriver(options);
            driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();

            // 3. Capture d'écran
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 4. Sauvegarde
            String path = "capture_google_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(screenshot, new File(path));

            System.out.println("Capture d'écran enregistrée sous : " + path);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}