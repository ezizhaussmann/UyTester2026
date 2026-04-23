package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests pour la page Add/Remove Elements du site the-internet.herokuapp.com
 * Tests d'ajout et de suppression dynamique d'éléments
 */
public class AddRemoveElementsTest extends BaseTest {
    
    @Test
    public void testAddRemoveElementsPageTitle() {
        navigateTo("/add_remove_elements/");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page add/remove elements n'est pas correct");
        
        System.out.println("Titre de la page add/remove elements vérifié avec succès");
    }
    
    @Test
    public void testAddRemoveElementsPageHeaders() {
        navigateTo("/add_remove_elements/");
        
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Add/Remove Elements", 
            "Le header de la page add/remove elements n'est pas correct");
        
        System.out.println("Header de la page add/remove elements vérifié avec succès");
    }
    
    @Test
    public void testAddButtonExists() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        Assert.assertTrue(addButton.isDisplayed(), "Le bouton Add n'est pas visible");
        Assert.assertTrue(addButton.isEnabled(), "Le bouton Add n'est pas cliquable");
        Assert.assertEquals(addButton.getText(), "Add Element", 
            "Le texte du bouton Add n'est pas correct");
        
        System.out.println("Bouton Add vérifié avec succès");
    }
    
    @Test
    public void testAddSingleElement() {
        navigateTo("/add_remove_elements/");
        
        // Cliquer sur le bouton Add
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addButton.click();
        
        // Vérifier qu'un élément a été ajouté
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 1, 
            "Un seul élément devrait avoir été ajouté");
        
        WebElement deleteButton = deleteButtons.get(0);
        Assert.assertTrue(deleteButton.isDisplayed(), "Le bouton Delete n'est pas visible");
        Assert.assertTrue(deleteButton.isEnabled(), "Le bouton Delete n'est pas cliquable");
        Assert.assertEquals(deleteButton.getText(), "Delete", 
            "Le texte du bouton Delete n'est pas correct");
        
        System.out.println("Ajout d'un seul élément réussi");
    }
    
    @Test
    public void testAddMultipleElements() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Ajouter 5 éléments
        int elementsToAdd = 5;
        for (int i = 0; i < elementsToAdd; i++) {
            addButton.click();
        }
        
        // Vérifier que tous les éléments ont été ajoutés
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), elementsToAdd, 
            "Le nombre d'éléments ajoutés n'est pas correct");
        
        // Vérifier que tous les boutons sont visibles et cliquables
        for (WebElement button : deleteButtons) {
            Assert.assertTrue(button.isDisplayed(), "Un bouton Delete n'est pas visible");
            Assert.assertTrue(button.isEnabled(), "Un bouton Delete n'est pas cliquable");
            Assert.assertEquals(button.getText(), "Delete", 
                "Un bouton Delete n'a pas le bon texte");
        }
        
        System.out.println("Ajout de plusieurs éléments réussi");
    }
    
    @Test
    public void testDeleteSingleElement() {
        navigateTo("/add_remove_elements/");
        
        // Ajouter un élément d'abord
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addButton.click();
        
        // Vérifier que l'élément existe
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 1, 
            "Un élément devrait exister avant la suppression");
        
        // Supprimer l'élément
        WebElement deleteButton = deleteButtons.get(0);
        deleteButton.click();
        
        // Vérifier que l'élément a été supprimé
        List<WebElement> remainingButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(remainingButtons.size(), 0, 
            "L'élément n'a pas été supprimé");
        
        System.out.println("Suppression d'un seul élément réussie");
    }
    
    @Test
    public void testDeleteMultipleElements() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Ajouter 3 éléments
        int elementsToAdd = 3;
        for (int i = 0; i < elementsToAdd; i++) {
            addButton.click();
        }
        
        // Vérifier que tous les éléments existent
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), elementsToAdd, 
            "Les éléments devraient exister avant la suppression");
        
        // Supprimer tous les éléments un par un
        while (deleteButtons.size() > 0) {
            deleteButtons.get(0).click();
            deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        }
        
        // Vérifier que tous les éléments ont été supprimés
        Assert.assertEquals(deleteButtons.size(), 0, 
            "Tous les éléments devraient avoir été supprimés");
        
        System.out.println("Suppression de plusieurs éléments réussie");
    }
    
    @Test
    public void testDeleteSpecificElement() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Ajouter 3 éléments
        for (int i = 0; i < 3; i++) {
            addButton.click();
        }
        
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 3, 
            "3 éléments devraient exister");
        
        // Supprimer le deuxième élément
        WebElement middleButton = deleteButtons.get(1);
        middleButton.click();
        
        // Vérifier qu'il reste 2 éléments
        List<WebElement> remainingButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(remainingButtons.size(), 2, 
            "2 éléments devraient rester après suppression");
        
        // Vérifier que les éléments restants sont les bons
        Assert.assertTrue(remainingButtons.get(0).isDisplayed(), 
            "Le premier élément devrait encore exister");
        Assert.assertTrue(remainingButtons.get(1).isDisplayed(), 
            "Le troisième élément devrait encore exister");
        
        System.out.println("Suppression d'un élément spécifique réussie");
    }
    
    @Test
    public void testAddDeleteSequence() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Séquence: ajouter 2, supprimer 1, ajouter 3, supprimer tous
        
        // Ajouter 2 éléments
        addButton.click();
        addButton.click();
        
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 2, "2 éléments devraient exister");
        
        // Supprimer 1 élément
        deleteButtons.get(0).click();
        
        deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 1, "1 élément devrait rester");
        
        // Ajouter 3 éléments
        addButton.click();
        addButton.click();
        addButton.click();
        
        deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 4, "4 éléments devraient exister");
        
        // Supprimer tous les éléments
        while (deleteButtons.size() > 0) {
            deleteButtons.get(0).click();
            deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        }
        
        Assert.assertEquals(deleteButtons.size(), 0, "Aucun élément ne devrait rester");
        
        System.out.println("Séquence add/delete réussie");
    }
    
    @Test
    public void testElementOrder() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Ajouter plusieurs éléments et vérifier l'ordre
        for (int i = 0; i < 3; i++) {
            addButton.click();
        }
        
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 3, "3 éléments devraient exister");
        
        // Vérifier que tous les éléments sont dans le bon ordre
        for (int i = 0; i < deleteButtons.size(); i++) {
            WebElement button = deleteButtons.get(i);
            Assert.assertTrue(button.isDisplayed(), "L'élément " + i + " n'est pas visible");
            Assert.assertEquals(button.getText(), "Delete", "L'élément " + i + " n'a pas le bon texte");
        }
        
        System.out.println("Ordre des éléments vérifié avec succès");
    }
    
    @Test
    public void testElementAttributes() {
        navigateTo("/add_remove_elements/");
        
        // Ajouter un élément
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addButton.click();
        
        // Vérifier les attributs de l'élément ajouté
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        
        Assert.assertEquals(deleteButton.getTagName(), "button", 
            "L'élément ajouté n'est pas un bouton");
        Assert.assertEquals(deleteButton.getAttribute("onclick"), "deleteElement()", 
            "L'attribut onclick n'est pas correct");
        Assert.assertEquals(deleteButton.getText(), "Delete", 
            "Le texte du bouton n'est pas correct");
        
        System.out.println("Attributs des éléments vérifiés avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/add_remove_elements/");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier le bouton Add
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        Assert.assertTrue(addButton.isDisplayed(), "Le bouton Add n'est pas visible");
        
        // Vérifier qu'aucun bouton Delete n'existe au début
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 0, 
            "Aucun bouton Delete ne devrait exister au début");
        
        System.out.println("Structure de la page add/remove elements vérifiée avec succès");
    }
    
    @Test
    public void testRapidAddDelete() {
        navigateTo("/add_remove_elements/");
        
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        
        // Ajouter rapidement plusieurs éléments
        for (int i = 0; i < 10; i++) {
            addButton.click();
            waitFor(100); // Petite pause pour simuler une interaction rapide
        }
        
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(), 10, "10 éléments devraient exister");
        
        // Supprimer rapidement tous les éléments
        while (deleteButtons.size() > 0) {
            deleteButtons.get(0).click();
            deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            waitFor(50); // Petite pause
        }
        
        Assert.assertEquals(deleteButtons.size(), 0, "Tous les éléments devraient avoir été supprimés");
        
        System.out.println("Add/Delete rapide réussi");
    }
}
