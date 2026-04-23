package org.tester.xxx_Play;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Démonstration de la gestion des alertes avec Selenium
 * @created : 21/04/2026,20:47,mar.
 **/
public class AlertHandlingDemo {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testSimpleAlert() {
        // Page de test avec alerte simple
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        // Cliquer sur le bouton qui déclenche une alerte simple
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();
        
        // Gérer l'alerte
        try {
            Alert alert = driver.switchTo().alert();
            
            // Récupérer le texte de l'alerte
            String alertText = alert.getText();
            System.out.println("Texte de l'alerte: " + alertText);
            
            // Accepter l'alerte (cliquer sur OK)
            alert.accept();
            System.out.println("Alerte acceptée avec succès");
            
        } catch (NoAlertPresentException e) {
            System.out.println("Aucune alerte présente: " + e.getMessage());
        }
    }
    
    @Test
    public void testConfirmationAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        // Cliquer sur le bouton qui déclenche une alerte de confirmation
        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmButton.click();
        
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Texte de confirmation: " + alert.getText());
            
            // Accepter la confirmation (cliquer sur OK)
            alert.accept();
            System.out.println("Confirmation acceptée");
            
            // Vérifier le résultat
            WebElement result = driver.findElement(By.id("result"));
            System.out.println("Résultat: " + result.getText());
            
        } catch (NoAlertPresentException e) {
            System.out.println("Aucune alerte de confirmation présente: " + e.getMessage());
        }
    }
    
    @Test
    public void testConfirmationAlertDismiss() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmButton.click();
        
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Texte de confirmation: " + alert.getText());
            
            // Rejeter la confirmation (cliquer sur Annuler/Cancel)
            alert.dismiss();
            System.out.println("Confirmation rejetée");
            
            // Vérifier le résultat
            WebElement result = driver.findElement(By.id("result"));
            System.out.println("Résultat: " + result.getText());
            
        } catch (NoAlertPresentException e) {
            System.out.println("Aucune alerte de confirmation présente: " + e.getMessage());
        }
    }
    
    @Test
    public void testPromptAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        // Cliquer sur le bouton qui déclenche une alerte avec champ de saisie
        WebElement promptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptButton.click();
        
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Texte du prompt: " + alert.getText());
            
            // Saisir du texte dans le champ de l'alerte
            String inputText = "Test Selenium";
            alert.sendKeys(inputText);
            System.out.println("Texte saisi: " + inputText);
            
            // Accepter l'alerte
            alert.accept();
            System.out.println("Prompt accepté avec texte");
            
            // Vérifier le résultat
            WebElement result = driver.findElement(By.id("result"));
            System.out.println("Résultat: " + result.getText());
            
        } catch (NoAlertPresentException e) {
            System.out.println("Aucune alerte de prompt présente: " + e.getMessage());
        }
    }
    
    @Test
    public void testAlertHandlingWithWait() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        // Utiliser une attente explicite pour l'alerte
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();
        
        // Attendre que l'alerte soit présente
        long startTime = System.currentTimeMillis();
        Alert alert = null;
        
        while (System.currentTimeMillis() - startTime < 5000) { // Attendre max 5 secondes
            try {
                alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                try {
                    Thread.sleep(500); // Attendre 500ms avant de réessayer
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        
        if (alert != null) {
            System.out.println("Alerte détectée: " + alert.getText());
            alert.accept();
            System.out.println("Alerte gérée avec succès");
        } else {
            System.out.println("Aucune alerte détectée après 5 secondes");
        }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
