package org.tester.record;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @created : 17/03/2026,01:18,mar.
 **/
public class Css {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        WebElement user = driver.findElement(By.cssSelector("input#username"));
        user.sendKeys("cubecart");
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        pass.sendKeys("cubecart");
        WebElement logbut = driver.findElement(By.cssSelector("#login"));
        logbut.click();
        Thread.sleep(2000);
        driver.quit();
    }

}
