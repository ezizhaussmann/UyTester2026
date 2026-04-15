package org.tester.tekrar.a_tekrar;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @created : 16/03/2026,16:23,lun.
 **/
public class Site1 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.cubecart.com/extensions/affiliate-trackers");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class=\"button expand\"]")).click();
        driver.findElement(By.id("q")).sendKeys("download");
        driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
    }
}
