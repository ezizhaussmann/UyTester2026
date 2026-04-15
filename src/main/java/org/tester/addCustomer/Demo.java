package org.tester.addCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 17/03/2026,22:54,mar.
 **/
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[3]"))).click();
//        driver.navigate().refresh();
//        WebElement logbut = driver.findElement(By.xpath("//*[contains(@class,\"element-group\")]"));
        WebElement logbut = driver.findElement(By.xpath("//div[@class=\"element-group\"]"));
        logbut.click();
        // 1. Initialiser l'exécuteur JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

// 2. Supprimer la bannière du bas (ID: fixedban)
        js.executeScript("var banner = document.getElementById('fixedban'); if(banner) banner.remove();");

// 3. Supprimer toutes les zones de publicités Google
        js.executeScript("var ads = document.querySelectorAll('div[id^=\"google_ads\"], ins.adsbygoogle'); " +
                "for (var i = 0; i < ads.length; i++) { ads[i].remove(); }");

// 4. Facultatif : Réduire le zoom pour voir tout le formulaire sans scroller
        js.executeScript("document.body.style.zoom='80%'");

        System.out.println("Nettoyage de la page terminé : Les pubs sont supprimées.");
//        driver.get("https://demoqa.com/webtables");

        WebElement web = driver.findElement(By.xpath("//a[@href=\"/webtables\"]"));
//        JavascriptExecutor jss= (JavascriptExecutor) driver;
//        jss.executeScript("arguments[0],click", web);
        web.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();
        Thread.sleep(3000);
        long tt=System.currentTimeMillis();
        AddInfo addInfo = new AddInfo("Kata","Charlotte","abs"+tt+"@gg.com",25,3000,"Informatic");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(addInfo.getPrenom());
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(addInfo.getNom());
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(addInfo.getEmail());
        WebElement aage = driver.findElement(By.id("age"));
        aage.sendKeys(addInfo.getAge()+"");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys(addInfo.getSalaire()+"");
        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys(addInfo.getDepartement());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
