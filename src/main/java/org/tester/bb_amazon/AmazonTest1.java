package org.tester.bb_amazon;

/**
 * @created : 27/03/2026,17:02,ven.
 **/
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;

public class AmazonTest1 {

    public static void main(String[] args) {
        // Liste des 5 produits à chercher
        List<String> produits = Arrays.asList("iphone 16", "ps5", "lego star wars", "clavier meca", "souris gamer");

        // On lance un Thread pour chaque produit
        for (String p : produits) {
            new Thread(() -> runSingleTest(p)).start();
            new Thread(()-> runSingleTest(p)).start();

        }
    }

    public static void runSingleTest(String NomDuProduit) {
        // 1. Création d'une instance UNIQUE pour ce thread
        BasePage page = new BasePage(NomDuProduit);

        try {
            // 2. Initialisation du navigateur
            page.setUp();

            // 3. Recherche
            WebElement search = page.driver.findElement(By.id("twotabsearchtextbox"));
            page.waitForPresent(search);
            search.sendKeys(NomDuProduit);
            search.submit();

            // 4. Vérification
            if (page.driver.getPageSource().contains(NomDuProduit)) {
                System.out.println("✅ SUCCÈS : " + NomDuProduit + " trouvé !");
            } else {
                System.out.println("❌ ÉCHEC : " + NomDuProduit + " non trouvé.");
            }

            // Petite pause pour voir le résultat
            Thread.sleep(3000);

        } catch (Exception e) {
            System.err.println("Erreur sur le test " + NomDuProduit + " : " + e.getMessage());
        } finally {
            // 5. Fermeture PROPRE du navigateur de ce thread
            page.close();
        }
    }
}
