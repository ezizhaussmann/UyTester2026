package pageobjectdesignpattern_log;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import testng_tests.ExtentReportListener;
import testng_tests.ScreenShotListener;

@Listeners({ReportListener.class, ScreenShotListener.class, ExtentReportListener.class})
public class TestNGRunner1 extends BaseClass {

    ChromeDriver driver;
    FunctionLibrary functionLibrary;
    ProductsPage productsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        driver.manage().window().maximize();
        functionLibrary = new FunctionLibrary(driver);
        productsPage  = new ProductsPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage     = new LoginPage(driver);
        loginPage.login("cubecart", "cubecart");
        context.setAttribute("driver", driver);
    }

    @Test
    @Description("Test d'ajout d'un produit")
    @Severity(SeverityLevel.CRITICAL)
    public void addProduct() {
        dashboardPage.clickProducts();
        productsPage.addProduct();
        Assert.assertTrue(productsPage.isProductAddedSuccessfully());
    }

    @Test
    @Description("Test de suppression d'un produit")
    @Severity(SeverityLevel.NORMAL)
    public void removeProduct() {
        dashboardPage.clickProducts();
        productsPage.deleteProduct();
        Assert.assertTrue(productsPage.verifyProductDelete());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
