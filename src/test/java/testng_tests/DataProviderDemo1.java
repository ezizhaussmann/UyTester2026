package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjectdesignpattern_log.DashboardPage;
import pageobjectdesignpattern_log.LoginPage;

/**
 * @created : 23/04/2026,17:14,jeu.
 **/
public class DataProviderDemo1 {
    ChromeDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void LoginTest(String username, String password){
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        loginPage.login(username,password);
        dashboardPage.clickLogout();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][2];

        data[0][0] = "cubecart";
        data[0][1] = "cubecart";

        data[1][0] = "cubecart";
        data[1][1] = "cubecart";


        return data;
    }
}
