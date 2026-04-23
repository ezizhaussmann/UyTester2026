package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.CustomerListePage;
import pageobjectdesignpattern.FunctionLibrary;
import pageobjectdesignpattern_log.DashboardPage;
import pageobjectdesignpattern_log.LoginPage;

/**
 * @created : 23/04/2026,17:14,jeu.
 **/
public class DataProviderDemo2 {
    ChromeDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    FunctionLibrary functionLibrary;
    CustomerListePage customerListePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        functionLibrary = new FunctionLibrary(driver);
        customerListePage = new CustomerListePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void LoginTest(){
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        loginPage.login("cubecart", "cubecart");
    }
    @Test(priority = 2, dataProvider = "customerData")
    public void addCustomerTest(String firstName, String lastName, String email){
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName,lastName,email);
    }

    @Test(priority = 3, dataProvider = "fakerCustomerData")
    public void addCustomerTestFaker(String firstName, String lastName, String email){
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName,lastName,email);
    }
    @Test(priority = 4, dataProvider = "fakerCustomerData1")
    public void addCustomerTestFaker1(String firstName, String lastName, String email){
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName,lastName,email);
    }



    @DataProvider
    public Object[][] customerData(){
        long ts = System.currentTimeMillis();
        String[] generated = functionLibrary.generateCustomer();
        return new Object[][]{
                {"Anton",      "Devane", "anton.devane"     + ts + "@gmail.com"},
                {"Antone",     "Devain", "antone.devain"    + ts + "@gmail.com"},
                {"Antonella",  "Devane", "antonella.devane" + ts + "@gmail.com"},
                {generated[0], generated[1], generated[2]}
        };
    }

    @DataProvider
    public Object[][] fakerCustomerData(){
        String[] c1 = functionLibrary.generateCustomer();
        String[] c2 = functionLibrary.generateCustomer();
        String[] c3 = functionLibrary.generateCustomer();
        String[] c4 = functionLibrary.generateCustomer();
        return new Object[][]{
                {c1[0], c1[1], c1[2]},
                {c2[0], c2[1], c2[2]},
                {c3[0], c3[1], c3[2]},
                {c4[0], c4[1], c4[2]}
        };
    }

    @DataProvider
    public Object[][] fakerCustomerData1(){
        Object[][] data = new Object[4][];
        for (int i = 0; i < 4; i++) {
            data[i] = functionLibrary.generateCustomer();
        }
        return data;
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
