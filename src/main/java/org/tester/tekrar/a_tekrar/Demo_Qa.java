package org.tester.tekrar.a_tekrar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @created : 25/03/2026,17:28,mer.
 **/
public class Demo_Qa {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//a[@href='/elements']"));
        element.click();
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
    }
}
