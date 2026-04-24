package pageobjectdesignpattern_log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FunctionLibrary {

    private static final Logger log = LogManager.getLogger(FunctionLibrary.class);

    ChromeDriver driver;
    WebDriverWait wait;

    public FunctionLibrary(ChromeDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            log.error("Interruption pendant sleep : {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void waitForElementPresent(WebElement element) {
        log.debug("Attente de la visibilité de l'élément...");
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
}
