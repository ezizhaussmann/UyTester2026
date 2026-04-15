package org.tester.record;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 17/03/2026,15:07,mar.
 **/
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        String titrePage = driver.getTitle();
        if (titrePage.contains("Automation Exercise")){
            System.out.println("SUCCÈS : La page d'accueil est visible.");
        } else {
            System.out.println("ÉCHEC : La page d'accueil n'est pas la bonne. Titre trouvé : " + titrePage);
        }
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));


        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("fc-consent-root")));
            WebElement consentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("fc-cta-consent")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", consentBtn);
            driver.switchTo().defaultContent();
         System.out.println("Pop-up gérée avec succès.");
    } catch (Exception e) {
        System.out.println("La pop-up n'est pas apparue, on continue le test.");
        driver.switchTo().defaultContent();
    }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, \"fc-cta-consent\")]"))).click();
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.navigate().refresh();
        WebElement email = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        email.sendKeys("narp6562bm@mrotzis.com");
        WebElement pass = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        pass.sendKeys("Charlotte246688");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ins[2]/div[1]//ins/span/svg/path"))).click();
////        WebElement login = driver.findElement(By.cssSelector(""));
////        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-qa='login-button']"))).click();
////        WebElement lo = driver.findElement(By.xpath("//*[@type='password']"));
//        WebElement lo = driver.findElement(By.xpath("driver.findElement(By.xpath(\"//button[normalize-space()='Login']\"))"));
//        lo.click();
//        WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
//// On utilise JavascriptExecutor pour forcer le clic
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

// Après un refresh, il faut souvent redéclarer l'élément ou retenter l'action
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
//        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href='/logout']")).click();


//        driver.close();
//        driver.quit();
    }
}
