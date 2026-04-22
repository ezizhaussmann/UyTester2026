package org.tester.xxx_Play;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Démonstration de l'utilisation de SafariDriver avec Selenium
 * @created : 21/04/2026,20:57,mar.
 **/
public class SafariDriverDemo {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Configuration des options Safari
        SafariOptions options = new SafariOptions();
        
        // Activer le mode automatique (nécessite l'extension SafariDriver)
        options.setAutomaticInspection(true);
        
        // Activer le mode headless si disponible
        // Note: Safari ne supporte pas nativement le mode headless
        
        // Créer l'instance SafariDriver
        driver = new SafariDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        System.out.println("SafariDriver initialisé avec succès");
    }
    
    @Test
    public void testBasicNavigation() {
        System.out.println("Test de navigation de base avec Safari");
        
        // Naviguer vers un site
        driver.get("https://www.google.com");
        
        // Vérifier le titre
        String title = driver.getTitle();
        System.out.println("Titre de la page: " + title);
        
        // Vérifier que nous sommes sur la bonne page
        assert title.contains("Google") : "Le titre ne contient pas 'Google'";
        
        System.out.println("Navigation de base réussie");
    }
    
    @Test
    public void testSearchFunctionality() {
        System.out.println("Test de la fonctionnalité de recherche");
        
        driver.get("https://www.google.com");
        
        // Trouver la barre de recherche
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // Saisir du texte
        String searchText = "Selenium WebDriver";
        searchBox.sendKeys(searchText);
        
        // Soumettre la recherche
        searchBox.submit();
        
        // Attendre les résultats et vérifier
        try {
            Thread.sleep(2000); // Simple wait pour la démo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Vérifier que nous avons des résultats
        String pageTitle = driver.getTitle();
        System.out.println("Page de résultats: " + pageTitle);
        
        assert pageTitle.contains(searchText) : "La recherche a échoué";
        
        System.out.println("Test de recherche réussi");
    }
    
    @Test
    public void testJavaScriptExecution() {
        System.out.println("Test d'exécution JavaScript avec Safari");
        
        driver.get("https://www.google.com");
        
        // Exécuter du JavaScript
        Long pixelRatio = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("return window.devicePixelRatio;");
        
        System.out.println("Device Pixel Ratio: " + pixelRatio);
        
        // Changer la couleur de fond via JavaScript
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("document.body.style.backgroundColor = 'lightblue';");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Exécution JavaScript réussie");
    }
    
    @Test
    public void testWindowManagement() {
        System.out.println("Test de gestion des fenêtres");
        
        driver.get("https://www.google.com");
        
        // Obtenir la fenêtre actuelle
        String originalWindow = driver.getWindowHandle();
        System.out.println("Fenêtre originale: " + originalWindow);
        
        // Ouvrir une nouvelle fenêtre via JavaScript
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("window.open('https://www.github.com', '_blank');");
        
        // Basculer vers la nouvelle fenêtre
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        // Vérifier que nous sommes sur GitHub
        String githubTitle = driver.getTitle();
        System.out.println("Titre GitHub: " + githubTitle);
        assert githubTitle.contains("GitHub") : "Pas sur GitHub";
        
        // Retourner à la fenêtre originale
        driver.switchTo().window(originalWindow);
        
        System.out.println("Gestion des fenêtres réussie");
    }
    
    @Test
    public void testMobileEmulation() {
        System.out.println("Test d'émulation mobile avec Safari");
        
        // Safari supporte l'émulation mobile via les options
        SafariOptions mobileOptions = new SafariOptions();
        
        // Note: Les options d'émulation mobile peuvent varier selon la version
        // Cet exemple montre la configuration de base
        
        driver = new SafariDriver(mobileOptions);
        driver.get("https://www.google.com");
        
        // Vérifier le viewport
        Long viewportWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("return window.innerWidth;");
        
        Long viewportHeight = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("return window.innerHeight;");
        
        System.out.println("Viewport: " + viewportWidth + "x" + viewportHeight);
        
        System.out.println("Test d'émulation mobile terminé");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("SafariDriver fermé");
        }
    }
}
