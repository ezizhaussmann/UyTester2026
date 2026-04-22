package pom;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class CubeCartAdminTest {

    private static Playwright playwright;
    private static Browser browser;
    private BrowserContext context;
    private Page page;
    private CubeCartAdminPage adminPage;

    @BeforeAll
    static void setupBrowser() {
        playwright = Playwright.create();
        browser    = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
    }

    @BeforeEach
    void setupPage() {
        context   = browser.newContext();
        page      = context.newPage();
        adminPage = new CubeCartAdminPage(page);
        adminPage.navigate();
        adminPage.login("cubecart", "cubecart");
    }

    @Test
    void testNavigateToCustomerList() {
        adminPage.goToCustomerList();
    }

    @Test
    void testAddCustomer() {
        adminPage.goToCustomerList();
        adminPage.goToAddCustomer();
    }

    @Test
    void testLogout() {
        adminPage.goToDashboard();
        adminPage.logout();
    }

    @AfterEach
    void tearDownPage() {
        context.close();
    }

    @AfterAll
    static void tearDownBrowser() {
        browser.close();
        playwright.close();
    }
}
