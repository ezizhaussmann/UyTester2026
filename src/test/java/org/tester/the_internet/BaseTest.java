package org.tester.the_internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

/**
 * Classe de base pour les tests Selenium du site the-internet.herokuapp.com
 * Configuration WebDriver et gestion du cycle de vie des tests
 */
public abstract class BaseTest {
    
    protected WebDriver driver;
    protected static final String BASE_URL = "https://the-internet.herokuapp.com";
    protected static final int IMPLICIT_WAIT = 10;
    protected static final int PAGE_LOAD_TIMEOUT = 30;
    
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser == null) {
            browser = "chrome"; // Navigateur par défaut
        }
        
        switch (browser.toLowerCase()) {
            case "chrome":
                setupChromeDriver();
                break;
            case "firefox":
                setupFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Navigateur non supporté: " + browser);
        }
        
        configureDriver();
        System.out.println("Navigateur " + browser + " initialisé avec succès");
    }
    
    private void setupChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        // Désactiver les notifications
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver(options);
    }
    
    private void setupFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }
    
    private void configureDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().deleteAllCookies();
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Navigateur fermé avec succès");
            } catch (Exception e) {
                System.err.println("Erreur lors de la fermeture du navigateur: " + e.getMessage());
            }
        }
    }
    
    /**
     * Méthode utilitaire pour naviguer vers une URL spécifique
     */
    protected void navigateTo(String path) {
        String url = BASE_URL + (path.startsWith("/") ? path : "/" + path);
        driver.get(url);
        System.out.println("Navigation vers: " + url);
    }
    
    /**
     * Méthode utilitaire pour attendre un certain temps (à utiliser avec modération)
     */
    protected void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Méthode utilitaire pour vérifier si un élément est présent
     */
    protected boolean isElementPresent(org.openqa.selenium.By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    
    /**
     * Méthode utilitaire pour obtenir le titre de la page
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Méthode utilitaire pour obtenir l'URL actuelle
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
