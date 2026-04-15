package org.tester.tekrar.a_tekrar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @created : 24/03/2026,23:46,mar.
 **/
public class Ex4 {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new EdgeDriver();
       driver.get("https://demo.cubecart.com/admin_5xArPd.php");
       driver.manage().window().maximize();
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("cubecart");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("cubecart");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        WebElement logOutButton = driver.findElement(By.xpath("//i[@class=\"fa fa-sign-out\"]"));
        logOutButton.click();
        driver.close();
        driver.quit();
    }
}
