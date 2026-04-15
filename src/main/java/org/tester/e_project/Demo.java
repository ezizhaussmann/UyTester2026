package org.tester.e_project;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

/**
 * @created : 20/03/2026,00:08,ven.
 **/
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        //login
        driver.findElement(By.id("username")).sendKeys("cubecart");
        driver.findElement(By.id("password")).sendKeys("cubecart");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

           try {

               Robot robot = new Robot();
               robot.keyPress(KeyEvent.VK_ENTER);
               robot.keyRelease(KeyEvent.VK_ENTER);
           } catch (AWTException e) {
               throw new RuntimeException(e);
           }
           Thread.sleep(3000);
           driver.close();
           driver.quit();


       }



    }

