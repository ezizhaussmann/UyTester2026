package org.tester.cc_amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @created : 27/03/2026,17:31,ven.
 **/

    public class BasePage {
        public WebDriver driver;
        public String productName;
        public WebDriverWait wait;

        public BasePage(String productName) {
            this.productName = productName;
        }

        public void setUp() {
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
            this.driver.get("https://www.amazon.fr/");

            // ... (code pour accepter les cookies ici)
            try {
                WebElement acc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"a-button a-button-base a-button-primary\"]")));
                acc.click();
            } catch (Exception e) {

                // Si la bannière n'est pas là, on ignore
            }
        }
    }

