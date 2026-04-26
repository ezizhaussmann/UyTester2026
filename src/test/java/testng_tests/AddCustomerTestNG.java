package testng_tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddCustomerTestNG {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Faker faker = new Faker();

    // ── Exécuté une seule fois avant tous les tests ───────────────────────────
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("========================================");
        System.out.println("🚀 Démarrage de la suite TestNG");
        System.out.println("========================================");
    }

    // ── Exécuté avant chaque test ─────────────────────────────────────────────
    @BeforeMethod
    public void setUp(ITestContext context) throws Exception {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("cubecart");
        driver.findElement(By.id("password")).sendKeys("cubecart");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        context.setAttribute("driver", driver);
        System.out.println("✅ Login réussi.");
    }

    // ── Test 1 : Ajouter un client ────────────────────────────────────────────
    @Test(description = "Ajouter un nouveau client avec des données Faker")
    public void testAddCustomer() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String firstName = faker.name().firstName();
        String lastName  = faker.name().lastName();
        String email     = firstName.toLowerCase() + "." + lastName.toLowerCase() + timestamp + "@" + faker.internet().domainName();

        // Naviguer vers Add Customer
        driver.get("https://demo.cubecart.com/admin_5xArPd.php?_g=customers&action=add");

        // Remplir le formulaire
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[first_name]"))).sendKeys(firstName);
        driver.findElement(By.name("customer[last_name]")).sendKeys(lastName);
        driver.findElement(By.name("customer[email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='save']")).click();

        // Vérification avec Assert TestNG
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success")));
        Assert.assertTrue(msg.getText().contains("Customer successfully added."),
                "❌ Message de succès non trouvé !");

        System.out.println("✅ Client ajouté : " + firstName + " " + lastName + " - " + email);
    }

    // ── Test 2 : Vérifier la liste des clients ────────────────────────────────
    @Test(description = "Vérifier que la liste des clients est accessible")
    public void testCustomerListVisible() {
        driver.findElement(By.linkText("Customer List")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td a[href*='action=edit']")));
        Assert.assertTrue(driver.findElements(By.cssSelector("td a[href*='action=edit']")).size() > 0,
                "❌ Aucun client trouvé dans la liste !");
        System.out.println("✅ Liste des clients visible.");
    }

    // ── Test 3 : Logout ───────────────────────────────────────────────────────
    @Test(description = "Vérifier la déconnexion")
    public void testLogout() {
        driver.findElement(By.cssSelector("a[href*='logout']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed(),
                "❌ Page de login non affichée après logout !");
        System.out.println("✅ Déconnexion réussie.");
    }

    // ── Exécuté après chaque test ─────────────────────────────────────────────
    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
        System.out.println("✅ Browser fermé.");
    }

    // ── Exécuté une seule fois après tous les tests ───────────────────────────
    @AfterSuite
    public void afterSuite() {
        System.out.println("========================================");
        System.out.println("🏁 Fin de la suite TestNG");
        System.out.println("========================================");
    }
}
