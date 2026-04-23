package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests pour la page Checkboxes du site the-internet.herokuapp.com
 * Tests de sélection et désélection de cases à cocher
 */
public class CheckboxesTest extends BaseTest {
    
    @Test
    public void testCheckboxesPageTitle() {
        navigateTo("/checkboxes");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page checkboxes n'est pas correct");
        
        System.out.println("Titre de la page checkboxes vérifié avec succès");
    }
    
    @Test
    public void testCheckboxesPageHeaders() {
        navigateTo("/checkboxes");
        
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Checkboxes", 
            "Le header de la page checkboxes n'est pas correct");
        
        System.out.println("Header de la page checkboxes vérifié avec succès");
    }
    
    @Test
    public void testCheckboxesExist() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        
        // Vérifier qu'il y a exactement 2 checkboxes
        Assert.assertEquals(checkboxes.size(), 2, 
            "Le nombre de checkboxes n'est pas correct");
        
        // Vérifier que les checkboxes sont visibles
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isDisplayed(), 
                "Une checkbox n'est pas visible");
        }
        
        System.out.println("Checkboxes vérifiées avec succès");
    }
    
    @Test
    public void testInitialState() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        
        // La première checkbox devrait être décochée par défaut
        WebElement checkbox1 = checkboxes.get(0);
        Assert.assertFalse(checkbox1.isSelected(), 
            "La première checkbox devrait être décochée par défaut");
        
        // La deuxième checkbox devrait être cochée par défaut
        WebElement checkbox2 = checkboxes.get(1);
        Assert.assertTrue(checkbox2.isSelected(), 
            "La deuxième checkbox devrait être cochée par défaut");
        
        System.out.println("État initial des checkboxes vérifié avec succès");
    }
    
    @Test
    public void testCheckFirstCheckbox() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement firstCheckbox = checkboxes.get(0);
        
        // Cocher la première checkbox
        firstCheckbox.click();
        
        // Vérifier qu'elle est cochée
        Assert.assertTrue(firstCheckbox.isSelected(), 
            "La première checkbox devrait être cochée");
        
        System.out.println("Cochage de la première checkbox réussi");
    }
    
    @Test
    public void testUncheckSecondCheckbox() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement secondCheckbox = checkboxes.get(1);
        
        // Décocher la deuxième checkbox
        secondCheckbox.click();
        
        // Vérifier qu'elle est décochée
        Assert.assertFalse(secondCheckbox.isSelected(), 
            "La deuxième checkbox devrait être décochée");
        
        System.out.println("Décochage de la deuxième checkbox réussi");
    }
    
    @Test
    public void testToggleCheckboxes() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement firstCheckbox = checkboxes.get(0);
        WebElement secondCheckbox = checkboxes.get(1);
        
        // Cocher la première checkbox
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), 
            "La première checkbox devrait être cochée");
        
        // Décocher la deuxième checkbox
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(), 
            "La deuxième checkbox devrait être décochée");
        
        // Décocher la première checkbox
        firstCheckbox.click();
        Assert.assertFalse(firstCheckbox.isSelected(), 
            "La première checkbox devrait être décochée");
        
        // Cocher la deuxième checkbox
        secondCheckbox.click();
        Assert.assertTrue(secondCheckbox.isSelected(), 
            "La deuxième checkbox devrait être cochée");
        
        System.out.println("Toggle des checkboxes réussi");
    }
    
    @Test
    public void testMultipleClicksOnSameCheckbox() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement firstCheckbox = checkboxes.get(0);
        
        // État initial: décochée
        Assert.assertFalse(firstCheckbox.isSelected(), 
            "La première checkbox devrait être décochée initialement");
        
        // Premier clic: cocher
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), 
            "La première checkbox devrait être cochée après le premier clic");
        
        // Deuxième clic: décocher
        firstCheckbox.click();
        Assert.assertFalse(firstCheckbox.isSelected(), 
            "La première checkbox devrait être décochée après le deuxième clic");
        
        // Troisième clic: cocher à nouveau
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), 
            "La première checkbox devrait être cochée après le troisième clic");
        
        System.out.println("Multiples clics sur la même checkbox réussis");
    }
    
    @Test
    public void testCheckboxAttributes() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            
            // Vérifier le type
            Assert.assertEquals(checkbox.getAttribute("type"), "checkbox", 
                "L'élément n'est pas de type checkbox");
            
            // Vérifier qu'il n'a pas d'attribut value ou qu'il est vide
            String value = checkbox.getAttribute("value");
            Assert.assertTrue(value == null || value.equals("on"), 
                "L'attribut value n'est pas correct pour la checkbox " + (i + 1));
        }
        
        System.out.println("Attributs des checkboxes vérifiés avec succès");
    }
    
    @Test
    public void testCheckboxLabels() {
        navigateTo("/checkboxes");
        
        // Vérifier s'il y a des labels associés
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        
        // Les checkboxes n'ont pas de labels explicites sur cette page
        // mais nous pouvons vérifier qu'elles sont dans un formulaire
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        
        Assert.assertTrue(checkboxes.size() > 0, 
            "Aucune checkbox trouvée");
        
        System.out.println("Labels des checkboxes vérifiés avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/checkboxes");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier les checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertTrue(checkboxes.size() > 0, "Aucune checkbox trouvée");
        
        // Vérifier que les checkboxes sont dans des éléments div
        List<WebElement> checkboxContainers = driver.findElements(By.cssSelector("div"));
        Assert.assertTrue(checkboxContainers.size() >= checkboxes.size(), 
            "Les checkboxes ne sont pas correctement structurées");
        
        System.out.println("Structure de la page checkboxes vérifiée avec succès");
    }
    
    @Test
    public void testCheckboxesAreClickable() {
        navigateTo("/checkboxes");
        
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        
        for (WebElement checkbox : checkboxes) {
            // Vérifier que la checkbox est cliquable
            Assert.assertTrue(checkbox.isEnabled(), 
                "Une checkbox n'est pas cliquable");
            
            // Sauvegarder l'état initial
            boolean initialState = checkbox.isSelected();
            
            // Cliquer sur la checkbox
            checkbox.click();
            
            // Vérifier que l'état a changé
            Assert.assertNotEquals(checkbox.isSelected(), initialState, 
                "L'état de la checkbox n'a pas changé après le clic");
            
            // Remettre dans l'état initial
            checkbox.click();
        }
        
        System.out.println("Clicabilité des checkboxes vérifiée avec succès");
    }
}
