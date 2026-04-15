package org.tester.uiautomatisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class User {
    public static void main(String[] args) {
        FirefoxDriver fire = new FirefoxDriver();
        fire.navigate().to("https://demo.cubecart.com/cc6/admin_5xArPd.php");
       By username =By.id("username");
        WebElement user=fire.findElement(username);
        user.sendKeys("cubecart");
        WebElement password = fire.findElement(By.name("password"));
        password.sendKeys("cubecart");
        By login=By.id("login");
        fire.findElement(login).click();
        try {
            fire.findElement(By.linkText("Ok, lets go!")).click();
            fire.findElement(By.linkText("Next")).click();
        } catch (Exception e) {
            System.out.println("La pop-up n'est pas apparue, on continue...");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fire.close();
        fire.quit();


    }
}
