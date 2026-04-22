package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests pour la page de Form Authentication du site the-internet.herokuapp.com
 * Tests de connexion avec identifiants valides et invalides
 */
public class LoginTest extends BaseTest {
    
    @Test
    public void testLoginPageTitle() {
        navigateTo("/login");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page de login n'est pas correct");
        
        System.out.println("Titre de la page de login vérifié avec succès");
    }
    
    @Test
    public void testLoginPageHeaders() {
        navigateTo("/login");
        
        WebElement header = driver.findElement(By.tagName("h2"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Login Page", 
            "Le header de la page de login n'est pas correct");
        
        System.out.println("Header de la page de login vérifié avec succès");
    }
    
    @Test
    public void testLoginFormElementsExist() {
        navigateTo("/login");
        
        // Vérifier le champ username
        WebElement usernameField = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField.isDisplayed(), "Le champ username n'est pas visible");
        Assert.assertEquals(usernameField.getAttribute("type"), "text", 
            "Le type du champ username n'est pas correct");
        
        // Vérifier le champ password
        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField.isDisplayed(), "Le champ password n'est pas visible");
        Assert.assertEquals(passwordField.getAttribute("type"), "password", 
            "Le type du champ password n'est pas correct");
        
        // Vérifier le bouton de connexion
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Le bouton de login n'est pas visible");
        Assert.assertEquals(loginButton.getText().trim(), "Login", 
            "Le texte du bouton de login n'est pas correct");
        
        System.out.println("Éléments du formulaire de login vérifiés avec succès");
    }
    
    @Test
    public void testLoginWithValidCredentials() {
        navigateTo("/login");
        
        // Entrer les identifiants valides
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        
        // Vérifier que nous sommes redirigés vers la page sécurisée
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/secure"), 
            "La redirection vers la page sécurisée a échoué");
        
        // Vérifier le message de succès
        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"), 
            "Le message de succès n'est pas correct");
        
        // Vérifier le bouton de déconnexion
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Le bouton de déconnexion n'est pas visible");
        
        System.out.println("Connexion avec identifiants valides réussie");
    }
    
    @Test
    public void testLoginWithInvalidUsername() {
        navigateTo("/login");
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        usernameField.sendKeys("invaliduser");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        
        // Vérifier que nous restons sur la page de login
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), 
            "Nous ne devrions pas être redirigés avec un username invalide");
        
        // Vérifier le message d'erreur
        WebElement errorMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"), 
            "Le message d'erreur pour username invalide n'est pas correct");
        
        System.out.println("Test avec username invalide réussi");
    }
    
    @Test
    public void testLoginWithInvalidPassword() {
        navigateTo("/login");
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("wrongpassword");
        loginButton.click();
        
        // Vérifier que nous restons sur la page de login
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), 
            "Nous ne devrions pas être redirigés avec un password invalide");
        
        // Vérifier le message d'erreur
        WebElement errorMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"), 
            "Le message d'erreur pour password invalide n'est pas correct");
        
        System.out.println("Test avec password invalide réussi");
    }
    
    @Test
    public void testLoginWithEmptyCredentials() {
        navigateTo("/login");
        
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        
        // Vérifier que nous restons sur la page de login
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), 
            "Nous ne devrions pas être redirigés avec des identifiants vides");
        
        // Vérifier le message d'erreur
        WebElement errorMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"), 
            "Le message d'erreur pour identifiants vides n'est pas correct");
        
        System.out.println("Test avec identifiants vides réussi");
    }
    
    @Test
    public void testLogoutFunctionality() {
        // D'abord se connecter
        navigateTo("/login");
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        
        // Attendre la redirection
        waitFor(1000);
        
        // Se déconnecter
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
        logoutButton.click();
        
        // Vérifier que nous sommes redirigés vers la page de login
        String currentUrl = getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login") || currentUrl.contains("the-internet"),
            "La déconnexion ne nous a pas redirigés vers la page de login");
        
        // Vérifier le message de déconnexion
        WebElement logoutMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"), 
            "Le message de déconnexion n'est pas correct");
        
        System.out.println("Fonctionnalité de déconnexion vérifiée avec succès");
    }
    
    @Test
    public void testPasswordFieldMasking() {
        navigateTo("/login");
        
        WebElement passwordField = driver.findElement(By.id("password"));
        
        // Vérifier que le champ est de type password
        Assert.assertEquals(passwordField.getAttribute("type"), "password", 
            "Le champ password n'est pas masqué");
        
        // Entrer du texte et vérifier qu'il est masqué
        passwordField.sendKeys("testpassword");
        String enteredValue = passwordField.getAttribute("value");
        Assert.assertEquals(enteredValue, "testpassword", 
            "La valeur du champ password n'est pas correcte");
        
        // Le type doit toujours être password
        Assert.assertEquals(passwordField.getAttribute("type"), "password", 
            "Le champ password a changé de type après saisie");
        
        System.out.println("Masquage du champ password vérifié avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/login");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier le formulaire
        WebElement loginForm = driver.findElement(By.id("login"));
        Assert.assertTrue(loginForm.isDisplayed(), "Le formulaire de login n'est pas visible");
        
        // Vérifier les labels
        WebElement usernameLabel = driver.findElement(By.cssSelector("label[for='username']"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='password']"));
        
        Assert.assertEquals(usernameLabel.getText(), "Username", "Le label username n'est pas correct");
        Assert.assertEquals(passwordLabel.getText(), "Password", "Le label password n'est pas correct");
        
        System.out.println("Structure de la page de login vérifiée avec succès");
    }
}
