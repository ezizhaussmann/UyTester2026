package org.tester.bb_amazon;

/**
 * @created : 27/03/2026,17:00,ven.
 **/

    import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

    public class BasePage {
        // PAS de static ici : chaque test aura son PROPRE driver
        public WebDriver driver;
        public WebDriverWait wait;
        public String productName;

        public BasePage(String productName) {
            this.productName = productName;
        }

        public void setUp() {
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
            this.driver.get("https://www.amazon.fr/");
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Gestion des cookies
            try {
                WebElement acc = wait.until(ExpectedConditions.elementToBeClickable(By.id("sp-cc-accept")));
                acc.click();
            } catch (Exception e) {
                // Si la bannière n'est pas là, on ignore
            }
        }

        public void waitForPresent(WebElement element) {
            this.wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void close() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

