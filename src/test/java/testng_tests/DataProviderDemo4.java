package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjectdesignpattern.CustomerListePage;
import pageobjectdesignpattern.FunctionLibrary;
import pageobjectdesignpattern_log.DashboardPage;
import pageobjectdesignpattern_log.LoginPage;

/**
 * @created : 23/04/2026
 * DataProvider avec titre (Mr/Mrs) + generateFakeName() + generateEmail()
 **/
public class DataProviderDemo4 {

    ChromeDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    FunctionLibrary functionLibrary;
    CustomerListePage customerListePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage         = new LoginPage(driver);
        dashboardPage     = new DashboardPage(driver);
        functionLibrary   = new FunctionLibrary(driver);
        customerListePage = new CustomerListePage(driver);
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        loginPage.login("cubecart", "cubecart");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "customerInfo")
    public void addCustomerTest(String firstName, String lastName, String email) {
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName, lastName, email);
        customerListePage.verifyCustomerAdded();
    }

    @DataProvider
    public Object[][] customerInfo() {
        long timeStamp = System.currentTimeMillis();
        return new Object[][]{
                {"Anton",  "Koshko", "anton"  + timeStamp + "@gmail.com"},
                {"Anny",   "Tom",    "anny"   + timeStamp + "@gmail.com"},
                {"Albert", "Koshko", "albert" + timeStamp + "@gmail.com"},
                {functionLibrary.generateFakeName(), functionLibrary.generateFakeName(), functionLibrary.generateEmail()}
        };
    }
}
