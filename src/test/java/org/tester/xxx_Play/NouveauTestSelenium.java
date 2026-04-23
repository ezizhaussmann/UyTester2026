package org.tester.xxx_Play;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NouveauTestSelenium {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Faker faker = new Faker();

    @BeforeEach
    void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
        driver = new ChromeDriver(options);
        wait   = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        fillField(By.id("username"), "cubecart");
        fillField(By.id("password"), "cubecart");
        clickElement(By.id("login"));

        try {
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("✅ Alerte Chrome fermée.");
        } catch (Exception e) {
            System.out.println("ℹ️ Pas d'alerte : " + e.getMessage());
        }
        System.out.println("✅ Login réussi.");
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private void fillField(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
    }

    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void printCustomerInfo(String firstName, String lastName, String email) {
        System.out.println("\n========================================");
        System.out.println("📋 Informations du client ajouté :");
        System.out.println("   Prénom  : " + firstName);
        System.out.println("   Nom     : " + lastName);
        System.out.println("   Email   : " + email);
        System.out.println("========================================\n");
    }

    private void addCustomer(String firstName, String lastName, String email) {
        clickElement(By.linkText("Customer List"));
        driver.get("https://demo.cubecart.com/admin_5xArPd.php?_g=customers&action=add");
        fillField(By.name("customer[first_name]"), firstName);
        fillField(By.name("customer[last_name]"), lastName);
        fillField(By.name("customer[email]"), email);
        clickElement(By.cssSelector("input[name='save']"));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success")));
        assertTrue(msg.getText().contains("Customer successfully added."));
        printCustomerInfo(firstName, lastName, email);
    }

    // ── Tests ─────────────────────────────────────────────────────────────────

    @Test
    void testAddCustomer1() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String firstName = faker.name().firstName();
        String lastName  = faker.name().lastName();
        String email     = firstName.toLowerCase() + "." + lastName.toLowerCase() + timestamp + "@" + faker.internet().domainName();

        addCustomer(firstName, lastName, email);
        System.out.println("✅ Customer 1 ajouté avec succès.");
    }

    @Test
    void testAddCustomer2() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String firstName = faker.name().firstName();
        String lastName  = faker.name().lastName();
        String email     = firstName.toLowerCase() + "." + lastName.toLowerCase() + timestamp + "@" + faker.internet().domainName();

        addCustomer(firstName, lastName, email);
        System.out.println("✅ Customer 2 ajouté avec succès.");
    }

    @Test
    void testUpdateCustomer() {
        String newFirstName = faker.name().firstName();
        clickElement(By.linkText("Customer List"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td a[href*='action=edit']")));
        clickElement(By.cssSelector("td a[href*='action=edit']"));
        fillField(By.name("customer[first_name]"), newFirstName);
        clickElement(By.cssSelector("input[name='save']"));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success")));
        assertTrue(msg.getText().contains("Customer successfully updated."));
        System.out.println("✅ Customer mis à jour avec le prénom : " + newFirstName);
    }

    @Test
    void testLogout() {
        clickElement(By.cssSelector("a[href*='logout']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        System.out.println("✅ Déconnexion réussie.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
