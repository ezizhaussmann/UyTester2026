package org.tester.record;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @created : 17/03/2026,00:31,mar.
 **/
public class Demo3 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//a[@href=\"/elements\"]"));
        element.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
       /* WebElement element = driver.findElement(By.xpath("//img[@alt=\"Selenium Online Training\"]"));
        element.click();*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();

    }
}
