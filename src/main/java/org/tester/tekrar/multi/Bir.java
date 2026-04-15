package org.tester.tekrar.multi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 27/03/2026,18:06,ven.
 **/
public class Bir {
    WebDriver driver;
    WebDriverWait wait;
    WebElement element;

    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cubecart.com/demo");
        WebElement element1 = driver.findElement(By.linkText("https://demo.cubecart.com/cc6/admin_5xArPd.php"));
        element1.click();

    }

    public void attend(WebElement element){
         wait = new WebDriverWait(driver, Duration.ofSeconds(3));
         wait.until(ExpectedConditions.elementToBeClickable(element));


    }
    public void waitForElementVisible(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void ferme() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }finally {
//            driver.close();
//            driver.quit();
//        }
//    }
//        try {
//            // On attend un peu pour voir le résultat final
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            System.out.println("Le sommeil a été interrompu");
//        } finally {
//            // On vérifie TOUJOURS si le driver existe avant de fermer
//            if (this.driver != null) {
//                try {
//                    this.driver.quit(); // quit() suffit largement
//                    System.out.println("Navigateur fermé proprement.");
//                } catch (Exception e) {
//                    System.out.println("Erreur lors de la fermeture : " + e.getMessage());
//                }
//            }
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }}
