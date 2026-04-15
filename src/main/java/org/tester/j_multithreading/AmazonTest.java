package org.tester.j_multithreading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @created : 27/03/2026,15:29,ven.
 **/
public class AmazonTest extends BasePage {

    public static void main(String[] args) throws InterruptedException {
        BasePage.setUp();
        BasePage basePage = new BasePage("iphone16");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        waitForPresent(search);
        search.sendKeys(prodctName);
        tryForBrowser();
//        verifyProduct();

    }

    public static boolean verifyProduct() {
        if (driver.getPageSource().contains(prodctName)) {
            System.out.println("Produit trouvé !");
            return true;
        } else {
            System.out.println("Produit non trouvé...");
            return false;
        }

    }
}
