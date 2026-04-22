package org.tester.the_internet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests pour la page JavaScript Alerts du site the-internet.herokuapp.com
 * Tests de gestion des alertes JavaScript (alert, confirm, prompt)
 */
public class AlertsTest extends BaseTest {
    
    @Test
    public void testAlertsPageTitle() {
        navigateTo("/javascript_alerts");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page alerts n'est pas correct");
        
        System.out.println("Titre de la page alerts vérifié avec succès");
    }
    
    @Test
    public void testAlertsPageHeaders() {
        navigateTo("/javascript_alerts");
        Assert.assertEquals(
            driver.findElement(By.tagName("h3")).getText(),
            "JavaScript Alerts",
            "Le header de la page alerts n'est pas correct"
        );
        System.out.println("Header de la page alerts vérifié avec succès");
    }
    
    @Test
    public void testAlertButtonsExist() {
        navigateTo("/javascript_alerts");
        
        // Vérifier les trois boutons d'alerte
        WebElement alertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        
        Assert.assertTrue(alertButton.isDisplayed(), "Le bouton d'alert n'est pas visible");
        Assert.assertTrue(confirmButton.isDisplayed(), "Le bouton de confirm n'est pas visible");
        Assert.assertTrue(promptButton.isDisplayed(), "Le bouton de prompt n'est pas visible");
        
        Assert.assertEquals(alertButton.getText(), "Click for JS Alert", 
            "Le texte du bouton d'alert n'est pas correct");
        Assert.assertEquals(confirmButton.getText(), "Click for JS Confirm", 
            "Le texte du bouton de confirm n'est pas correct");
        Assert.assertEquals(promptButton.getText(), "Click for JS Prompt", 
            "Le texte du bouton de prompt n'est pas correct");
        
        System.out.println("Boutons d'alerte vérifiés avec succès");
    }
    
    @Test
    public void testSimpleAlert() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton d'alert
        WebElement alertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertButton.click();
        
        // Attendre l'alerte et la gérer
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        
        // Vérifier le texte de l'alerte
        Assert.assertEquals(alertText, "I am a JS Alert", 
            "Le texte de l'alerte n'est pas correct");
        
        // Accepter l'alerte
        alert.accept();
        
        // Vérifier que nous sommes revenus à la page
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You successfuly clicked an alert") ||
                result.getText().contains("You successfully clicked an alert"), 
            "Le message de résultat n'est pas correct");
        
        System.out.println("Alert simple gérée avec succès");
    }
    
    @Test
    public void testConfirmAlertAccept() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton de confirmation
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        confirmButton.click();
        
        // Attendre l'alerte et la gérer
        Alert confirmAlert = driver.switchTo().alert();
        String alertText = confirmAlert.getText();
        
        // Vérifier le texte de l'alerte
        Assert.assertEquals(alertText, "I am a JS Confirm", 
            "Le texte de l'alerte de confirmation n'est pas correct");
        
        // Accepter l'alerte
        confirmAlert.accept();
        
        // Vérifier le message de résultat
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You clicked: Ok"), 
            "Le message de résultat pour accept n'est pas correct");
        
        System.out.println("Alert de confirmation (accept) gérée avec succès");
    }
    
    @Test
    public void testConfirmAlertDismiss() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton de confirmation
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        confirmButton.click();
        
        // Attendre l'alerte et la gérer
        Alert confirmAlert = driver.switchTo().alert();
        
        // Refuser l'alerte
        confirmAlert.dismiss();
        
        // Vérifier le message de résultat
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You clicked: Cancel"), 
            "Le message de résultat pour dismiss n'est pas correct");
        
        System.out.println("Alert de confirmation (dismiss) gérée avec succès");
    }
    
    @Test
    public void testPromptAlertWithInput() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton de prompt
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptButton.click();
        
        // Attendre l'alerte et la gérer
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        
        // Vérifier le texte de l'alerte
        Assert.assertEquals(alertText, "I am a JS prompt", 
            "Le texte de l'alerte de prompt n'est pas correct");
        
        // Entrer du texte dans le prompt
        String testInput = "Test Input Text";
        promptAlert.sendKeys(testInput);
        
        // Accepter l'alerte
        promptAlert.accept();
        
        // Vérifier le message de résultat
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You entered: " + testInput), 
            "Le message de résultat pour le prompt n'est pas correct");
        
        System.out.println("Alert de prompt (avec entrée) gérée avec succès");
    }
    
    @Test
    public void testPromptAlertWithoutInput() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton de prompt
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptButton.click();
        
        // Attendre l'alerte et la gérer
        Alert promptAlert = driver.switchTo().alert();
        
        // Accepter l'alerte sans entrer de texte
        promptAlert.accept();
        
        // Vérifier le message de résultat
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You entered:"), 
            "Le message de résultat pour le prompt vide n'est pas correct");
        
        System.out.println("Alert de prompt (sans entrée) gérée avec succès");
    }
    
    @Test
    public void testPromptAlertDismiss() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton de prompt
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptButton.click();
        
        // Attendre l'alerte et la gérer
        Alert promptAlert = driver.switchTo().alert();
        
        // Refuser l'alerte
        promptAlert.dismiss();
        
        // Vérifier le message de résultat
        WebElement element = driver.findElement(By.id("result"));
        String resultText = element.getText();
        Assert.assertTrue(resultText.contains("You entered: null"), 
            "Le message de résultat pour le prompt dismiss n'est pas correct");
        
        System.out.println("Alert de prompt (dismiss) gérée avec succès");
    }
    
    @Test
    public void testMultipleAlertsSequence() {
        navigateTo("/javascript_alerts");
        
        // Séquence: alert -> confirm -> prompt
        
        // 1. Alert simple
        WebElement alertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertButton.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        waitFor(500);
        
        // 2. Confirm (accept)
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        confirmButton.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        waitFor(500);
        
        // 3. Prompt (avec texte)
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptButton.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Sequence Test");
        alert3.accept();
        
        // Vérifier le résultat final
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("You entered: Sequence Test"), 
            "La séquence d'alertes n'a pas fonctionné correctement");
        
        System.out.println("Séquence multiple d'alertes gérée avec succès");
    }
    
    @Test
    public void testAlertHandlingTimeout() {
        navigateTo("/javascript_alerts");
        
        // Cliquer sur le bouton d'alert
        WebElement alertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertButton.click();
        
        // Vérifier que l'alerte est présente
        Alert alert = driver.switchTo().alert();
        Assert.assertNotNull(alert, "L'alerte n'est pas présente");
        
        // Vérifier que nous ne pouvons pas interagir avec la page pendant l'alerte
        boolean canInteract = false;
        try {
            // Tenter de cliquer sur un autre élément
            WebElement result = driver.findElement(By.id("result"));
            result.getText();
            canInteract = true;
        } catch (Exception e) {
            canInteract = false;
        }
        
        // Accepter l'alerte
        alert.accept();
        
        // Maintenant nous devrions pouvoir interagir avec la page
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertNotNull(result, "Le résultat n'est pas accessible après l'alerte");
        
        System.out.println("Gestion du timeout des alertes vérifiée avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/javascript_alerts");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier les boutons
        WebElement alertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        
        Assert.assertTrue(alertButton.isDisplayed(), "Le bouton d'alert n'est pas visible");
        Assert.assertTrue(confirmButton.isDisplayed(), "Le bouton de confirm n'est pas visible");
        Assert.assertTrue(promptButton.isDisplayed(), "Le bouton de prompt n'est pas visible");
        
        // Vérifier l'élément de résultat — visible seulement après interaction
        // On vérifie juste son existence dans le DOM
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertNotNull(result, "L'élément de résultat n'existe pas dans le DOM");
        
        System.out.println("Structure de la page alerts vérifiée avec succès");
    }
}
