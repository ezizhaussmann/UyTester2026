package org.tester.record;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 16/03/2026,18:15,lun.
 **/
public class Demo1 {
    public static void main(String[] args) {
        FirefoxDriver fdriver = new FirefoxDriver();
//        fdriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        fdriver.get("https://www.google.com/");
        WebDriverWait weit = new WebDriverWait(fdriver,Duration.ofSeconds(3));
        WebDriverWait webDriverWait = new WebDriverWait(fdriver, Duration.ofSeconds(2));
        fdriver.findElement(By.xpath("//button[@id=\"L2AGLb\"]")).click();



        fdriver.quit();

    }
}
