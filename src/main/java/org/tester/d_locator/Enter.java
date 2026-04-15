package org.tester.d_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

/**
 * @created : 19/03/2026,22:02,jeu.
 **/
public class Enter {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--guest");
//            options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("document.body.style.zoom='80%'");
        CubeInfo cubeInfo = new CubeInfo("cubecart","cubecart");
        driver.findElement(By.id("username")).sendKeys(cubeInfo.getUser());
        driver.findElement(By.id("password")).sendKeys(cubeInfo.getPvd());
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).build().perform();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Customer List\"]"))).click();
//        driver.findElement(By.xpath("//a[text()=\"Customer List\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class=\"fa fa-sign-out\"]")).click();
        Thread.sleep(3000);





//        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}
