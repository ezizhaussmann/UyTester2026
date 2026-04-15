package org.tester.j_multithreading;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

/**
 * @created : 27/03/2026,15:13,ven.
 **/
public class BasePage  {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String prodctName;
    public BasePage() {
    }

    public BasePage(String prodctName) {
        this.prodctName = prodctName;
    }



    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr/");
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        try {
            WebElement acc = wait.until(ExpectedConditions.elementToBeClickable((By.id("sp-cc-accept"))));
            acc.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void sleep(int second) {
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public  static void waitForPresent(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static void tryForBrowser() throws InterruptedException {
//        wait.withTimeout(Duration.ofSeconds(2)).until(d -> true);
//        Thread.sleep(1000);
        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}
