package org.tester.the_internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests pour la page Sortable Data Tables du site the-internet.herokuapp.com
 * Tests de manipulation et de lecture de tableaux de données
 */
public class TablesTest extends BaseTest {
    
    @Test
    public void testTablesPageTitle() {
        navigateTo("/tables");
        
        String expectedTitle = "The Internet";
        String actualTitle = getPageTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Le titre de la page tables n'est pas correct");
        
        System.out.println("Titre de la page tables vérifié avec succès");
    }
    
    @Test
    public void testTablesPageHeaders() {
        navigateTo("/tables");
        
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        
        Assert.assertEquals(headerText, "Data Tables", 
            "Le header de la page tables n'est pas correct");
        
        System.out.println("Header de la page tables vérifié avec succès");
    }
    
    @Test
    public void testTablesExist() {
        navigateTo("/tables");
        
        List<WebElement> tables = driver.findElements(By.tagName("table"));
        
        // Vérifier qu'il y a au moins 2 tableaux
        Assert.assertTrue(tables.size() >= 2, 
            "Le nombre de tableaux est insuffisant: " + tables.size());
        
        // Vérifier que les tableaux sont visibles
        for (WebElement table : tables) {
            Assert.assertTrue(table.isDisplayed(), 
                "Un tableau n'est pas visible");
        }
        
        System.out.println("Tableaux vérifiés avec succès");
    }
    
    @Test
    public void testFirstTableHeaders() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        List<WebElement> headers = firstTable.findElements(By.cssSelector("thead th"));
        
        // Vérifier les en-têtes du premier tableau
        String[] expectedHeaders = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};
        
        Assert.assertEquals(headers.size(), expectedHeaders.length, 
            "Le nombre d'en-têtes du premier tableau n'est pas correct");
        
        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(headers.get(i).getText(), expectedHeaders[i], 
                "L'en-tête " + i + " n'est pas correct");
        }
        
        System.out.println("En-têtes du premier tableau vérifiés avec succès");
    }
    
    @Test
    public void testFirstTableData() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        List<WebElement> rows = firstTable.findElements(By.cssSelector("tbody tr"));
        
        // Vérifier qu'il y a des lignes de données
        Assert.assertTrue(rows.size() > 0, 
            "Le premier tableau ne contient aucune ligne de données");
        
        // Vérifier les données de la première ligne
        WebElement firstRow = rows.get(0);
        List<WebElement> cells = firstRow.findElements(By.tagName("td"));
        
        Assert.assertEquals(cells.size(), 6,
            "La première ligne devrait avoir 6 cellules");
        
        // Vérifier les données de la première ligne
        Assert.assertEquals(cells.get(0).getText(), "Smith",
            "Le nom de famille de la première ligne n'est pas correct");
        Assert.assertEquals(cells.get(1).getText(), "John",
            "Le prénom de la première ligne n'est pas correct");
        Assert.assertEquals(cells.get(2).getText(), "jsmith@gmail.com",
            "L'email de la première ligne n'est pas correct");
        
        System.out.println("Données du premier tableau vérifiées avec succès");
    }
    
    @Test
    public void testSecondTableData() {
        navigateTo("/tables");
        
        WebElement secondTable = driver.findElement(By.cssSelector("table#table2"));
        List<WebElement> rows = secondTable.findElements(By.cssSelector("tbody tr"));
        
        Assert.assertTrue(rows.size() > 0,
            "Le deuxième tableau ne contient aucune ligne de données");
        
        WebElement firstRow = rows.get(0);
        List<WebElement> cells = firstRow.findElements(By.tagName("td"));
        
        Assert.assertEquals(cells.size(), 6,
            "La première ligne devrait avoir 6 cellules");
        
        Assert.assertEquals(cells.get(0).getText(), "Conway",
            "Le nom de famille de la première ligne n'est pas correct");
        Assert.assertEquals(cells.get(1).getText(), "Tim",
            "Le prénom de la première ligne n'est pas correct");
        Assert.assertEquals(cells.get(2).getText(), "tconway@earthlink.net",
            "L'email de la première ligne n'est pas correct");
        
        System.out.println("Données du deuxième tableau vérifiées avec succès");
    }
    
    @Test
    public void testTableSorting() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        
        // Cliquer sur l'en-tête "Last Name" pour trier
        WebElement lastNameHeader = firstTable.findElement(By.xpath(".//th[contains(text(), 'Last Name')]"));
        lastNameHeader.click();
        
        // Attendre un peu pour le tri
        waitFor(1000);
        
        // Vérifier que les données sont triées par nom de famille
        List<WebElement> rows = firstTable.findElements(By.cssSelector("tbody tr"));
        String previousLastName = "";
        
        for (WebElement row : rows) {
            WebElement lastNameCell = row.findElement(By.cssSelector("td:first-child"));
            String currentLastName = lastNameCell.getText();
            
            if (!previousLastName.isEmpty()) {
                Assert.assertTrue(currentLastName.compareTo(previousLastName) >= 0, 
                    "Les données ne sont pas correctement triées par nom de famille");
            }
            previousLastName = currentLastName;
        }
        
        System.out.println("Tri du tableau vérifié avec succès");
    }
    
    @Test
    public void testTableLinks() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        List<WebElement> links = firstTable.findElements(By.cssSelector("td a"));
        
        // Vérifier qu'il y a des liens dans le tableau
        Assert.assertTrue(links.size() > 0, 
            "Le tableau ne contient aucun lien");
        
        // Vérifier que les liens sont valides
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            Assert.assertNotNull(href, "Un lien n'a pas d'attribut href");
            Assert.assertFalse(href.isEmpty(), "Un lien a un href vide");
            Assert.assertTrue(href.startsWith("http"), "Un lien n'est pas une URL valide");
        }
        
        System.out.println("Liens du tableau vérifiés avec succès");
    }
    
    @Test
    public void testDeleteButtons() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        List<WebElement> deleteButtons = firstTable.findElements(By.cssSelector("a[href='#delete']"));
        
        // Vérifier qu'il y a des boutons de suppression
        Assert.assertTrue(deleteButtons.size() > 0, 
            "Le tableau ne contient aucun bouton de suppression");
        
        // Vérifier que les boutons sont cliquables
        for (WebElement button : deleteButtons) {
            Assert.assertTrue(button.isDisplayed(), 
                "Un bouton de suppression n'est pas visible");
            Assert.assertTrue(button.isEnabled(), 
                "Un bouton de suppression n'est pas cliquable");
        }
        
        System.out.println("Boutons de suppression vérifiés avec succès");
    }
    
    @Test
    public void testEditButtons() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        List<WebElement> editButtons = firstTable.findElements(By.cssSelector("a[href='#edit']"));
        
        // Vérifier qu'il y a des boutons d'édition
        Assert.assertTrue(editButtons.size() > 0, 
            "Le tableau ne contient aucun bouton d'édition");
        
        // Vérifier que les boutons sont cliquables
        for (WebElement button : editButtons) {
            Assert.assertTrue(button.isDisplayed(), 
                "Un bouton d'édition n'est pas visible");
            Assert.assertTrue(button.isEnabled(), 
                "Un bouton d'édition n'est pas cliquable");
        }
        
        System.out.println("Boutons d'édition vérifiés avec succès");
    }
    
    @Test
    public void testTableStructure() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        
        // Vérifier la structure du tableau
        WebElement thead = firstTable.findElement(By.tagName("thead"));
        WebElement tbody = firstTable.findElement(By.tagName("tbody"));
        
        Assert.assertTrue(thead.isDisplayed(), "L'en-tête du tableau n'est pas visible");
        Assert.assertTrue(tbody.isDisplayed(), "Le corps du tableau n'est pas visible");
        
        // Vérifier les lignes d'en-tête
        List<WebElement> headerRows = thead.findElements(By.tagName("tr"));
        Assert.assertEquals(headerRows.size(), 1, 
            "L'en-tête devrait avoir une seule ligne");
        
        // Vérifier les colonnes
        List<WebElement> headerCells = headerRows.get(0).findElements(By.tagName("th"));
        Assert.assertEquals(headerCells.size(), 6,
            "L'en-tête devrait avoir 6 colonnes");
        
        System.out.println("Structure du tableau vérifiée avec succès");
    }
    
    @Test
    public void testSpecificDataRetrieval() {
        navigateTo("/tables");
        
        WebElement firstTable = driver.findElement(By.cssSelector("table#table1"));
        
        // Chercher une personne spécifique (John Smith)
        List<WebElement> rows = firstTable.findElements(By.cssSelector("tbody tr"));
        boolean found = false;
        
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() >= 2) {
                String firstName = cells.get(1).getText();
                String lastName = cells.get(0).getText();
                
                if (firstName.equals("John") && lastName.equals("Smith")) {
                    found = true;
                    
                    // Vérifier les autres informations
                    Assert.assertEquals(cells.get(2).getText(), "jsmith@gmail.com", 
                        "L'email de John Smith n'est pas correct");
                    Assert.assertEquals(cells.get(3).getText(), "$50.00", 
                        "Le montant dû de John Smith n'est pas correct");
                    Assert.assertEquals(cells.get(4).getText(), "http://www.jsmith.com", 
                        "Le site web de John Smith n'est pas correct");
                    
                    break;
                }
            }
        }
        
        Assert.assertTrue(found, "John Smith n'a pas été trouvé dans le tableau");
        
        System.out.println("Récupération de données spécifiques vérifiée avec succès");
    }
    
    @Test
    public void testPageLayout() {
        navigateTo("/tables");
        
        // Vérifier la structure principale
        WebElement mainContent = driver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(mainContent.isDisplayed(), "Le contenu principal n'est pas visible");
        
        // Vérifier les tableaux
        List<WebElement> tables = driver.findElements(By.tagName("table"));
        Assert.assertTrue(tables.size() >= 2, "Moins de 2 tableaux trouvés");
        
        // Vérifier que chaque tableau a une structure correcte
        for (WebElement table : tables) {
            Assert.assertTrue(table.isDisplayed(), "Un tableau n'est pas visible");
            
            // Vérifier que le tableau a des lignes
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            Assert.assertTrue(rows.size() > 0, "Un tableau n'a aucune ligne");
        }
        
        System.out.println("Structure de la page tables vérifiée avec succès");
    }
}
