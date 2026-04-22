package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests pour la page Dropdown du site the-internet.herokuapp.com
 * Tests de sélection d'options dans un menu déroulant
 */
public class DropdownTest extends BaseTest {
    
    @Test
    public void testDropdownPageTitle() {
        navigateTo("/dropdown");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page dropdown n'est pas correct");
        
        System.out.println("Titre de la page dropdown vérifié avec succès");
    }
    
    @Test
    public void testDropdownPageHeaders() {
        navigateTo("/dropdown");
        
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Dropdown List", 
            "Le header de la page dropdown n'est pas correct");
        
        System.out.println("Header de la page dropdown vérifié avec succès");
    }
    
    @Test
    public void testDropdownExists() {
        navigateTo("/dropdown");
        
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Assert.assertTrue(dropdown.isDisplayed(), "Le dropdown n'est pas visible");
        Assert.assertEquals(dropdown.getTagName(), "select", 
            "L'élément dropdown n'est pas de type select");
        
        System.out.println("Dropdown vérifié avec succès");
    }
    
    @Test
    public void testDropdownOptions() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Vérifier le nombre d'options
        Assert.assertEquals(dropdown.getOptions().size(), 3, 
            "Le dropdown devrait avoir 3 options");
        
        // Vérifier les textes des options
        Assert.assertEquals(dropdown.getOptions().get(0).getText(), "Please select an option", 
            "La première option n'est pas correcte");
        Assert.assertEquals(dropdown.getOptions().get(1).getText(), "Option 1", 
            "La deuxième option n'est pas correcte");
        Assert.assertEquals(dropdown.getOptions().get(2).getText(), "Option 2", 
            "La troisième option n'est pas correcte");
        
        // Vérifier les valeurs des options
        Assert.assertEquals(dropdown.getOptions().get(0).getAttribute("value"), "", 
            "La valeur de la première option n'est pas correcte");
        Assert.assertEquals(dropdown.getOptions().get(1).getAttribute("value"), "1", 
            "La valeur de la deuxième option n'est pas correcte");
        Assert.assertEquals(dropdown.getOptions().get(2).getAttribute("value"), "2", 
            "La valeur de la troisième option n'est pas correcte");
        
        System.out.println("Options du dropdown vérifiées avec succès");
    }
    
    @Test
    public void testSelectOption1() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Sélectionner l'option 1
        dropdown.selectByVisibleText("Option 1");
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", 
            "L'option 1 n'est pas sélectionnée");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getAttribute("value"), "1", 
            "La valeur sélectionnée n'est pas correcte");
        
        // Vérifier que l'option est effectivement sélectionnée
        Assert.assertTrue(dropdown.getFirstSelectedOption().isSelected(), 
            "L'option sélectionnée n'a pas l'attribut selected");
        
        System.out.println("Sélection de l'option 1 réussie");
    }
    
    @Test
    public void testSelectOption2() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Sélectionner l'option 2
        dropdown.selectByVisibleText("Option 2");
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", 
            "L'option 2 n'est pas sélectionnée");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getAttribute("value"), "2", 
            "La valeur sélectionnée n'est pas correcte");
        
        // Vérifier que l'option est effectivement sélectionnée
        Assert.assertTrue(dropdown.getFirstSelectedOption().isSelected(), 
            "L'option sélectionnée n'a pas l'attribut selected");
        
        System.out.println("Sélection de l'option 2 réussie");
    }
    
    @Test
    public void testSelectByValue() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Sélectionner par valeur
        dropdown.selectByValue("1");
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", 
            "L'option sélectionnée par valeur n'est pas correcte");
        
        // Sélectionner l'autre option par valeur
        dropdown.selectByValue("2");
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", 
            "L'option sélectionnée par valeur n'est pas correcte");
        
        System.out.println("Sélection par valeur réussie");
    }
    
    @Test
    public void testSelectByIndex() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Sélectionner par index (option 1 = index 1)
        dropdown.selectByIndex(1);
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", 
            "L'option sélectionnée par index n'est pas correcte");
        
        // Sélectionner par index (option 2 = index 2)
        dropdown.selectByIndex(2);
        
        // Vérifier que l'option est sélectionnée
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", 
            "L'option sélectionnée par index n'est pas correcte");
        
        System.out.println("Sélection par index réussie");
    }
    
    @Test
    public void testMultipleSelectionNotSupported() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Vérifier que le dropdown ne supporte pas la sélection multiple
        Assert.assertFalse(dropdown.isMultiple(), 
            "Le dropdown ne devrait pas supporter la sélection multiple");
        
        System.out.println("Vérification de la sélection multiple réussie");
    }
    
    @Test
    public void testDefaultSelection() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Vérifier que par défaut aucune option n'est sélectionnée
        // ou que la première option (Please select an option) est sélectionnée
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        Assert.assertTrue(selectedOption.getText().equals("Please select an option") || 
                         selectedOption.getAttribute("value").equals(""), 
            "La sélection par défaut n'est pas correcte");
        
        System.out.println("Sélection par défaut vérifiée avec succès");
    }
    
    @Test
    public void testChangeSelection() {
        navigateTo("/dropdown");
        
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        
        // Sélectionner l'option 1
        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", 
            "L'option 1 n'est pas sélectionnée");
        
        // Changer vers l'option 2
        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", 
            "L'option 2 n'est pas sélectionnée");
        
        // Vérifier que l'option 1 n'est plus sélectionnée
        boolean option1StillSelected = false;
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().equals("Option 1") && option.isSelected()) {
                option1StillSelected = true;
                break;
            }
        }
        Assert.assertFalse(option1StillSelected, 
            "L'option 1 ne devrait plus être sélectionnée");
        
        System.out.println("Changement de sélection réussi");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/dropdown");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier le dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Assert.assertTrue(dropdown.isDisplayed(), "Le dropdown n'est pas visible");
        
        // Vérifier que c'est bien un élément select
        Assert.assertEquals(dropdown.getTagName(), "select", 
            "L'élément dropdown n'est pas de type select");
        
        System.out.println("Structure de la page dropdown vérifiée avec succès");
    }
}
