package tuto;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectdesignpattern_log.BaseClass;
import pageobjectdesignpattern_log.ExtentReportManager;
import pageobjectdesignpattern_log.LoginPage;
import pageobjectdesignpattern_log.ReportListener;
import testng_tests.ScreenShotUtility;

import java.io.File;

/**
 * @created : 23/04/2026,15:46,jeu.
 **/
@Listeners(ReportListener.class)
public class GitD extends BaseClass {

    private static final Logger log = LogManager.getLogger(GitD.class);

    @BeforeSuite
    public void setUpSuite() {
        ExtentReportManager.initReports();
    }

    private final ScreenShotUtility screenShotUtility = new ScreenShotUtility();

    @Test
    public void testGit() {
        initBrowser();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("cubecart", "cubecart");
            driver.findElement(By.linkText("Dashboard")).click();
            Assert.assertTrue(
                driver.findElement(By.xpath("//div[@id='dashboard']/h3")).isDisplayed(),
                "Dashboard is displayed"
            );
            File screenshot = screenShotUtility.captureScreen("testGit_Passed", driver);
            ExtentReportManager.getTest().log(Status.PASS, "Dashboard is displayed")
                .addScreenCaptureFromPath(screenshot.getAbsolutePath());
            log.info("Test completed successfully.");
        } catch (Exception e) {
            if (driver != null) {
                File screenshot = screenShotUtility.captureScreen("testGit_Failed", driver);
                if (ExtentReportManager.getTest() != null)
                    ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + e.getMessage())
                        .addScreenCaptureFromPath(screenshot.getAbsolutePath());
            }
            log.error("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        } finally {
            quitBrowser();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReports();
    }
}
