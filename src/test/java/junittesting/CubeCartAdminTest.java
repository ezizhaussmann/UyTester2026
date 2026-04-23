package junittesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CubeCartAdminTest {

    private WebDriver driver;
    private CubeCartAdminPage adminPage;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
        driver    = new ChromeDriver(options);
        wait      = new WebDriverWait(driver, Duration.ofSeconds(15));
        adminPage = new CubeCartAdminPage(driver, wait);
        adminPage.navigate();
        adminPage.login("cubecart", "cubecart");
    }

    @Test
    void testNavigateToCustomerList() {
        adminPage.goToCustomerList();
    }

    @Test
    void testAddCustomer() {
        String email = "katachan" + System.currentTimeMillis() + "@gg.cc";
        adminPage.goToAddCustomer();
        adminPage.addCustomer("katachan", "charlotte", email);
        adminPage.verifyCustomerAdded();
    }

    @Test
    void testLogout() {
        adminPage.goToDashboard();
        adminPage.logout();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
