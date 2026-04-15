package org.tester.tekrar.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @created : 24/03/2026,22:46,mar.
 **/
public class R_method {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public void setBrowser(String url){
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void login(String userName,String passWord){
        wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(passWord);
        WebElement selector = driver.findElement(By.xpath("//div[@class=\"form-group\"]/select"));
        Select select = new Select(selector);
        select.selectByVisibleText("Student");
        WebElement chec = driver.findElement(By.id("terms"));
        chec.click();
        WebElement sign = driver.findElement(By.xpath("//*[@id='signInBtn']"));
        sign.click();

    }
    public void closeBrowser(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }
}
