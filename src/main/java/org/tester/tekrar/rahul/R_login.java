package org.tester.tekrar.rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @created : 24/03/2026,22:30,mar.
 **/
public class R_login {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String userN="rahulshettyacademy";
        String pass="Learning@830$3mK2";
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(userN);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement selector = driver.findElement(By.xpath("//div[@class=\"form-group\"]/select"));
        Select select = new Select(selector);
        select.selectByVisibleText("Student");
        WebElement chec = driver.findElement(By.id("terms"));
        chec.click();
        WebElement sign = driver.findElement(By.xpath("//*[@id='signInBtn']"));
        sign.click();
    }
}
