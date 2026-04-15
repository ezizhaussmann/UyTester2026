package org.tester.record;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 17/03/2026,01:30,mar.
 **/
public class CssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        // --- AJOUTE CE BLOC AVANT TON CLIC SUR LOGIN ---

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1. Attendre et entrer dans l'iframe de consentement
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("fc-consent-root")));

            // 2. Cliquer sur le bouton Consent (ou Autoriser) via sa classe CSS unique
            // On utilise JavaScript pour être sûr que le clic passe même si l'élément est capricieux
            WebElement consentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("fc-cta-consent")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", consentBtn);

            // 3. SORTIR de l'iframe (INDISPENSABLE pour la suite)
            driver.switchTo().defaultContent();
//            JavascriptExecutor driver1 = (JavascriptExecutor) driver;
//            Object o = driver1.executeScript("");

            System.out.println("Pop-up gérée avec succès.");
        } catch (Exception e) {
            System.out.println("La pop-up n'est pas apparue, on continue le test.");
            driver.switchTo().defaultContent();
        }

// --- MAINTENANT TA LIGNE 23 FONCTIONNERA ---
//        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //p[@class="fc-button-label" and contains(text(), "Autoriser")]
//        WebElement auto = driver.findElement(By.xpath("//p[@class=\"fc-button-label\" and contains(text(), \"Autoriser\")]"));
//
//auto.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, \"fc-cta-consent\")]"))).click();
////        WebElement btnAutoriser = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]")));
//        btnAutoriser.click();
//        driver.switchTo().frame(driver.findElement(By.className("fc-consent-root")));
//        try {
//            // 1. Attendre que l'iframe soit présente dans la page
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            // 2. Switcher vers l'iframe (c'est comme si Selenium changeait de fenêtre)
//            // On utilise la classe de l'iframe que l'on voit souvent sur ce site
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("fc-consent-root")));
//
//            // 3. Maintenant que nous sommes "DANS" l'iframe, on cherche le bouton
//            // On utilise ton XPath corrigé ou le sélecteur CSS de la classe
//            WebElement btnAutoriser = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//p[contains(text(), 'Autoriser')]")
//            ));
//
//            // 4. Cliquer sur le bouton
//            btnAutoriser.click();
//            System.out.println("Bouton cliqué avec succès !");
//
//            // 5. IMPORTANT : Revenir au contenu principal de la page
//            // Sinon Selenium cherchera la suite de ton test (Login, etc.) dans l'iframe et ne trouvera rien.
//            driver.switchTo().defaultContent();
//
//        } catch (Exception e) {
//            System.out.println("Le bandeau n'est pas apparu ou erreur : " + e.getMessage());
//            // Au cas où, on essaie de revenir au contenu principal
//            driver.switchTo().defaultContent();
//        }
// Ensuite ton clic ici
//        btnAutoriser.click();
        /*WebElement user = driver.findElement(By.cssSelector("input#username"));
        user.sendKeys("cubecart");
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        pass.sendKeys("cubecart");
        WebElement logbut = driver.findElement(By.cssSelector("#login"));
        logbut.click();*/
        WebElement regis = driver.findElement(By.cssSelector("a[href='/login']"));
        regis.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
