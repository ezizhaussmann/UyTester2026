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
    @DataProvider
    public Object[][] getData(){
        Object[][] data = {{"cubecart","cubecart"},{"cubecart","cubecart"},{"cubecart","cubecart"}};

        return data;
    }
    @Test(dataProvider = "getData")
    public void LoginTest(String username, String password){
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        driver
        .manage().window().maximize();
        loginPage.login(username,password);
        dashboardPage.clickLogout();

    }
    @BeforeClass
    public void beforeclass(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);


    }
    @AfterClass
    public void afterclass(){
        driver.quit();

    }
}
