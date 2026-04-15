package org.tester.d_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @created : 19/03/2026,19:18,jeu.
 **/
public class Preceding {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--guest");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        driver.findElement(By.xpath("//a[@href='/elements']")).click();
        driver.findElement(By.xpath("//a[@href=\"/webtables\"]")).click();
        int i = driver.findElements(By.xpath("//td[text()=\"Alden\"]/preceding::tr")).size() - 1;
        System.out.println(i);
        int size = driver.findElements(By.xpath("//td[text()=\"Alden\"]/parent::tr/preceding-sibling::tr")).size();
        System.out.println("size = " + size);
        System.out.println();
        int i1 = driver.findElements(By.xpath("//td[text()=\"Alden\"]/preceding::tr")).size() - 1;
        System.out.println(i1);
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
