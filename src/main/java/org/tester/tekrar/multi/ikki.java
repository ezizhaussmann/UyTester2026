package org.tester.tekrar.multi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @created : 27/03/2026,18:09,ven.
 **/
public class ikki extends Bir implements Runnable{


    @Override
    public void run() {

        Bir bir = new Bir();
        bir.setup();
//        bir.attend(driver.findElement(By.linkText("https://demo.cubecart.com/cc6/admin_5xArPd.php")));
        WebElement element1 = bir.driver.findElement(By.id("logo"));

        bir.attend(element1);
        bir.ferme();


    }
}
