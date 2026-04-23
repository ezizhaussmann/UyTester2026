package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjectdesignpattern.CustomerListePage;
import pageobjectdesignpattern.FunctionLibrary;
import pageobjectdesignpattern_log.DashboardPage;
import pageobjectdesignpattern_log.LoginPage;
import java.util.stream.IntStream;

/**
 * @created : 23/04/2026
 * Les 3 façons d'utiliser generateCustomer() dans un DataProvider
 **/
public class DataProviderDemo3 {

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

    // ── Façon 1 : variables séparées ─────────────────────────────────────────
    @Test(priority = 1, dataProvider = "fakerData_Variables")
    public void addCustomerTest1(String firstName, String lastName, String email) {
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName, lastName, email);
    }

    @DataProvider
    public Object[][] fakerData_Variables() {
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

    // ── Façon 2 : boucle for ─────────────────────────────────────────────────
    @Test(priority = 2, dataProvider = "fakerData_Loop")
    public void addCustomerTest2(String firstName, String lastName, String email) {
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName, lastName, email);
    }

    @DataProvider
    public Object[][] fakerData_Loop() {
        Object[][] data = new Object[4][];
        for (int i = 0; i < 4; i++) {
            data[i] = functionLibrary.generateCustomer();
        }
        return data;
    }

    // ── Façon 3 : Stream ─────────────────────────────────────────────────────
    @Test(priority = 3, dataProvider = "fakerData_Stream")
    public void addCustomerTest3(String firstName, String lastName, String email) {
        dashboardPage.clickCustomerList();
        dashboardPage.clickAddCustomer();
        customerListePage.addCustomer(firstName, lastName, email);
    }

    @DataProvider
    public Object[][] fakerData_Stream() {
        return IntStream.range(0, 4)
                .mapToObj(i -> functionLibrary.generateCustomer())
                .toArray(Object[][]::new);
    }
}
