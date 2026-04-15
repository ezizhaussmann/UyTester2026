package org.tester.e_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.channels.Selector;
import java.time.Duration;
import java.util.Random;

/**
 * @created : 19/03/2026,22:32,jeu.
 **/
public class Manage {
    public static void main(String[] args) throws InterruptedException {
        //initialisation
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        //login
        driver.findElement(By.id("username")).sendKeys("cubecart");
        driver.findElement(By.id("password")).sendKeys("cubecart");
        driver.findElement(By.id("login")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Customer List\"]")));
        Thread.sleep(2000);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.linkText("Add Customer")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"general\"]/h3")));
        driver.findElement(By.cssSelector("#cust-firstname")).sendKeys("kata");
        driver.findElement(By.xpath("//input[@id='cust-lastname']")).sendKeys("Carlotte");

        WebElement registType = driver.findElement(By.id("cust-type"));
        Select select = new Select(registType);
        select.selectByIndex(1);
        int i=1+(int)(Math.random()*10000);
         String email=String.format("Charlotte%s@onepiece.com",System.currentTimeMillis());
         driver.findElement(By.name("customer[email]")).sendKeys(email);
        WebElement subscriptionStatus = driver.findElement(By.id("subscription_status"));
        Select select1 = new Select(subscriptionStatus);
        select1.selectByValue("2");
        WebElement amount = driver.findElement(By.xpath("//*[@id='cust-credit']"));
        amount.sendKeys(""+i);
        driver.findElement(By.xpath("//input[@name=\"save\"]")).click();
        WebElement costumer = driver.findElement(By.xpath("//td[text()=\""+email+"\"]/parent::tr"));
        if (costumer.isDisplayed()){
            System.out.println("nouveau client avec d'email : " + email + "   est ajouté");
        }
        /*String locator=String.format("//td[text()='%s']/following-sibling::td//i[@title='Delete']",email);
        driver.findElement(By.xpath(locator)).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();*/

        Thread.sleep(2000);




    }
}
