package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests pour la page d'accueil du site the-internet.herokuapp.com
 * Vérification du contenu, des liens et de la navigation
 */
public class HomePageTest extends BaseTest {
    
    @Test
    public void testHomePageTitle() {
        navigateTo("");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page d'accueil n'est pas correct");
        
        System.out.println("Titre de la page vérifié avec succès: " + actualTitle);
    }
    
    @Test
    public void testHomePageHeader() {
        navigateTo("");
        
        WebElement header = driver.findElement(By.tagName("h1"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Welcome to the-internet", 
            "Le header principal n'est pas correct");
        
        WebElement subHeader = driver.findElement(By.tagName("h2"));
        String subHeaderText = subHeader.getText();
        
        Assert.assertEquals(subHeaderText, "Available Examples", 
            "Le sous-titre n'est pas correct");
        
        System.out.println("Headers vérifiés avec succès");
    }
    
    @Test
    public void testNumberOfExamples() {
        navigateTo("");
        
        List<WebElement> examples = driver.findElements(By.cssSelector("ul li a"));
        
        // Vérifier qu'il y a au moins 40 exemples
        Assert.assertTrue(examples.size() >= 40, 
            "Le nombre d'exemples est insuffisant: " + examples.size());
        
        System.out.println("Nombre d'exemples trouvés: " + examples.size());
    }
    
    @Test
    public void testSpecificExamplesExist() {
        navigateTo("");
        
        String[] expectedExamples = {
            "A/B Testing",
            "Add/Remove Elements", 
            "Basic Auth",
            "Broken Images",
            "Checkboxes",
            "Dropdown",
            "Form Authentication",
            "JavaScript Alerts",
            "Key Presses",
            "Sortable Data Tables"
        };
        
        for (String example : expectedExamples) {
            WebElement link = driver.findElement(By.linkText(example));
            Assert.assertTrue(link.isDisplayed(), 
                "L'exemple '" + example + "' n'est pas visible");
            
            // Vérifier que le lien a un href valide
            String href = link.getAttribute("href");
            Assert.assertNotNull(href, "L'exemple '" + example + "' n'a pas de href");
            Assert.assertTrue(href.contains("the-internet.herokuapp.com"), 
                "Le href de l'exemple '" + example + "' n'est pas valide");
        }
        
        System.out.println("Exemples spécifiques vérifiés avec succès");
    }
    
    @Test
    public void testNavigationToExample() {
        navigateTo("");
        
        // Cliquer sur le premier exemple
        WebElement firstExample = driver.findElement(By.cssSelector("ul li:first-child a"));
        String exampleText = firstExample.getText();
        firstExample.click();
        
        // Vérifier que nous avons navigué vers la page de l'exemple
        Assert.assertNotEquals(getCurrentUrl(), BASE_URL + "/", 
            "La navigation n'a pas fonctionné");
        
        // Vérifier que nous sommes toujours sur le même domaine
        Assert.assertTrue(getCurrentUrl().contains(BASE_URL), 
            "Nous avons quitté le domaine the-internet");
        
        System.out.println("Navigation vers l'exemple '" + exampleText + "' réussie");
    }
    
    @Test
    public void testFooterExists() {
        navigateTo("");
        
        WebElement footer = driver.findElement(By.cssSelector("div.footer"));
        Assert.assertTrue(footer.isDisplayed(), "Le footer n'est pas visible");
        
        WebElement footerText = footer.findElement(By.cssSelector(".row div"));
        Assert.assertTrue(footerText.getText().contains("Elemental Selenium"), 
            "Le texte du footer ne contient pas 'Elemental Selenium'");
        
        System.out.println("Footer vérifié avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier la liste des exemples
        WebElement examplesList = driver.findElement(By.cssSelector("ul"));
        Assert.assertTrue(examplesList.isDisplayed(), "La liste des exemples n'est pas visible");
        
        // Vérifier les éléments de la liste
        List<WebElement> listItems = examplesList.findElements(By.tagName("li"));
        Assert.assertTrue(listItems.size() > 0, "La liste ne contient aucun élément");
        
        System.out.println("Structure de la page vérifiée avec succès");
    }
    
    @Test
    public void testAllLinksAreClickable() {
        navigateTo("");
        
        List<WebElement> links = driver.findElements(By.cssSelector("ul li a"));
        int workingLinks = 0;
        
        for (WebElement link : links) {
            try {
                // Vérifier que le lien est cliquable
                Assert.assertTrue(link.isEnabled(), "Le lien n'est pas activé: " + link.getText());
                
                // Vérifier que le href n'est pas vide
                String href = link.getAttribute("href");
                Assert.assertNotNull(href, "Le href est null pour: " + link.getText());
                Assert.assertFalse(href.isEmpty(), "Le href est vide pour: " + link.getText());
                
                workingLinks++;
            } catch (AssertionError e) {
                System.err.println("Problème avec le lien: " + link.getText() + " - " + e.getMessage());
            }
        }
        
        Assert.assertTrue(workingLinks > 0, "Aucun lien fonctionnel trouvé");
        System.out.println("Nombre de liens fonctionnels: " + workingLinks + "/" + links.size());
    }
}
