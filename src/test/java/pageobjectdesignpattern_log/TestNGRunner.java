package pageobjectdesignpattern_log;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({ReportListener.class})
public class TestNGRunner extends BaseClass {
    ChromeDriver driver;
    FunctionLibrary functionLibrary;
    ProductsPage productsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @BeforeSuite
    public void setUpSuite() {
        ExtentReportManager.initReports();
    }

    @BeforeClass
    public void setUp(ITestContext context){
        driver = new ChromeDriver();
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        driver.manage().window().maximize();
        functionLibrary = new FunctionLibrary(driver);
        productsPage = new ProductsPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("cubecart", "cubecart");
        context.setAttribute("driver", driver);
    }
    
    @Test
    @Description("Test d'ajout d'un produit")
    @Severity(SeverityLevel.CRITICAL)
    public void addProduct(){
        dashboardPage.clickProducts();
        productsPage.addProduct();
        boolean productAddedSuccessfully = productsPage.isProductAddedSuccessfully();
        Assert.assertTrue(productAddedSuccessfully);
    }
    
    @Test
    @Description("Test de suppression d'un produit")
    @Severity(SeverityLevel.NORMAL)
    public void removeProduct(){
        dashboardPage.clickProducts();
        productsPage.deleteProduct();
        boolean productDeletedSuccessfully = productsPage.verifyProductDelete();
        Assert.assertTrue(productDeletedSuccessfully);
    }
    
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    
    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReports();
    }
}
