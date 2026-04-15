package org.tester.d_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * @created : 19/03/2026,19:18,jeu.
 **/
public class CubeCart {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("document.body.style.zoom='80%'");
        CubeInfo cubeInfo = new CubeInfo("cubecart","cubecart");
        driver.findElement(By.id("username")).sendKeys(cubeInfo.getUser());
        driver.findElement(By.id("password")).sendKeys(cubeInfo.getPvd());
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("//a[text()=\"Customer List\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class=\"fa fa-sign-out\"]")).click();
        Thread.sleep(3000);





//        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
