package tuto;

import com.github.fge.jsonschema.core.report.AbstractProcessingReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectdesignpattern_log.BaseClass;
import pageobjectdesignpattern_log.LoginPage;

/**
 * @created : 23/04/2026,15:46,jeu.
 **/
public class GitD extends BaseClass {
    private static final Logger log = LogManager.getLogger(GitD.class);
    @Test
    public void testGit(){
        initBrowser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("cubecart","cubecart");
        driver.findElement(By.linkText("Dashboard")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dashboard']/h3")).isDisplayed(),"Dashboard is displayed");

        quitBrowser();
        log.info("Test completed successfully.");

        System.out.println("test git");
    }

}
