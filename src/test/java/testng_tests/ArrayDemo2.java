package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern_log.DashboardPage;
import pageobjectdesignpattern_log.LoginPage;

/**
 * @created : 23/04/2026,17:46,jeu.
 **/
public class ArrayDemo2 {
    ChromeDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeClass
    public void beforeclass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage     = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"cubecart", "cubecart"},
                {"cubecart", "cubecart"},
                {"cubecart", "cubecart"}
        };
    }

    @Test(dataProvider = "getData")
    public void LoginTest(String username, String password) {
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        loginPage.login(username, password);
        dashboardPage.clickLogout();
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }
}
