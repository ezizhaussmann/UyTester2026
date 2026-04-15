package org.tester.cc_amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @created : 27/03/2026,17:31,ven.
 **/
public class AmazonTest extends BasePage implements Runnable {

    // Constructeur pour passer le nom du produit
    public AmazonTest(String productName) {
        super(productName);
    }

    // L'ancienne méthode obligatoire de l'interface Runnable
    @Override
    public void run() {
        setUp();

            WebElement search = driver.findElement(By.id("//*[@type=\"text\"]"));
            search.sendKeys(productName);
            search.submit();
            System.out.println("Recherche terminée pour : " + productName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
//            driver.close();
//            driver.quit();

        }

    }
}
