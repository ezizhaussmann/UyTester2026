package org.tester.uiautomatisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
//        ChromeDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.edge.driver","C:\\Program Files\\Common Files\\edgedriver_win64");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        By userName= By.id("username");
        By pass=By.id("password");
        By login=By.id("login");
        driver.findElement(userName).sendKeys("cubecart");
        Thread.sleep(2000);
        driver.findElement(pass).sendKeys("cubecart");
        Thread.sleep(2000);
        driver.findElement(login).click();
        Thread.sleep(3000);
        WebElement philipMaybelle = driver.findElement(By.linkText("Philip Maybelle"));
        if (philipMaybelle.isDisplayed()){
            System.out.println("votre teste  est passé");
        }else {
            System.out.println("apprenez bien et faites  attention aux poins importants");
        }

        By logOut = By.linkText("Log Out");
        driver.findElement(logOut).click();

        driver.close();
        driver.quit();

    }
}
