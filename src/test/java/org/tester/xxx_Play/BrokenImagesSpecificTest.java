package org.tester.xxx_Play;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/**
 * Test spécifique pour la page https://the-internet.herokuapp.com/broken_images
 * Contient exactement 3 images avec 2 images cassées attendues
 * @created : 21/04/2026,21:01,mar.
 **/
public class BrokenImagesSpecificTest {
    
    private WebDriver driver;
    private static final String TEST_URL = "https://the-internet.herokuapp.com/broken_images";
    
    @BeforeMethod
    public void setUp() {
        // ÉTAPE 1: Initialisation du WebDriver
        // Crée une nouvelle instance de ChromeDriver
        // Chaque test commence avec un navigateur propre
        driver = new ChromeDriver();
        
        // ÉTAPE 2: Maximisation de la fenêtre
        // Assure que les éléments sont visibles comme en mode normal
        driver.manage().window().maximize();
        
        // ÉTAPE 3: Configuration des timeouts
        // implicitlyWait: Attend jusqu'à 10s avant de lancer NoSuchElementException
        // C'est une attente "globale" qui s'applique à tous les findElement()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testSpecificBrokenImagesPage() {
        System.out.println("🔍 Test spécifique de la page broken_images");
        
        // ÉTAPE 1: Navigation vers la page de test
        // On utilise get() pour charger l'URL dans le navigateur
        driver.get(TEST_URL);
        
        // ÉTAPE 2: Vérification du contexte
        // On récupère le titre pour s'assurer qu'on est sur la bonne page
        String pageTitle = driver.getTitle();
        System.out.println("Titre de la page: " + pageTitle);
        
        // ÉTAPE 3: Recherche des éléments images
        // findElements() retourne TOUTES les balises <img> de la page
        // By.tagName("img") est le sélecteur pour trouver les éléments par nom de balise
        List<WebElement> images = driver.findElements(By.tagName("img"));
        
        // ÉTAPE 4: Validation du nombre d'images attendu
        // Cette page de test contient exactement 3 images (2 cassées + 1 valide)
        assert images.size() == 3 : 
            "Attendu: 3 images, Trouvé: " + images.size();
        System.out.println("✅ Nombre d'images correct: " + images.size());
        
        // ÉTAPE 5: Initialisation des compteurs
        // On va compter séparément les images valides et cassées
        int validImages = 0;
        int brokenImages = 0;
        
        // ÉTAPE 6: Analyse individuelle de chaque image
        // On parcourt la liste d'images trouvées pour les vérifier une par une
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            
            // Récupération de l'attribut 'src' qui contient l'URL de l'image
            // getAttribute() permet de lire n'importe quel attribut HTML
            String imageSrc = image.getAttribute("src");
            
            System.out.println("\n--- Image " + (i + 1) + " ---");
            System.out.println("Source: " + imageSrc);
            
            // ÉTAPE 7: Vérification du statut de l'image
            // checkImageStatus() envoie une requête HTTP HEAD pour vérifier si l'URL est accessible
            boolean isValid = checkImageStatus(imageSrc);
            
            // ÉTAPE 8: Comptage basé sur le résultat
            if (isValid) {
                validImages++;
                System.out.println("✅ Image VALIDE");
            } else {
                brokenImages++;
                System.out.println("❌ Image CASSÉE");
            }
        }
        
        // ÉTAPE 9: Affichage du résumé des résultats
        System.out.println("\n=== RÉSULTATS FINAUX ===");
        System.out.println("Images valides: " + validImages);
        System.out.println("Images cassées: " + brokenImages);
        System.out.println("Total: " + (validImages + brokenImages));
        
        // ÉTAPE 10: Assertions finales pour valider le test
        // On vérifie que les résultats correspondent exactement aux attentes pour cette page
        assert validImages == 1 : 
            "Attendu: 1 image valide, Trouvé: " + validImages;
        assert brokenImages == 2 : 
            "Attendu: 2 images cassées, Trouvé: " + brokenImages;
        
        System.out.println("\n🎯 TEST RÉUSSI - La page contient bien 2/3 images cassées !");
    }
    
    @Test
    public void testImageDetails() {
        System.out.println("📋 Test détaillé des images de la page");
        
        driver.get(TEST_URL);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        
        // Détails pour chaque image
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String src = image.getAttribute("src");
            String alt = image.getAttribute("alt");
            
            System.out.println("\n📷 Image " + (i + 1) + ":");
            System.out.println("  URL: " + src);
            System.out.println("  Alt: " + (alt != null ? alt : "(non défini)"));
            
            // Vérifier les dimensions
            try {
                Long width = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", image);
                Long height = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalHeight;", image);
                
                System.out.println("  Dimensions: " + width + "x" + height);
                
                if (width != null && height != null && (width == 0 || height == 0)) {
                    System.out.println("  ⚠️ Dimensions nulles = image cassée");
                }
                
            } catch (Exception e) {
                System.out.println("  ❌ Erreur dimensions: " + e.getMessage());
            }
            
            // Vérification HTTP
            boolean isValid = checkImageStatus(src);
            System.out.println("  Statut HTTP: " + (isValid ? "✅ Valide" : "❌ Cassée"));
        }
    }
    
    @Test
    public void testPageStructure() {
        System.out.println("🏗️ Test de la structure de la page");
        
        driver.get(TEST_URL);
        
        // Vérifier le contenu textuel
        try {
            WebElement heading = driver.findElement(By.tagName("h3"));
            String headingText = heading.getText();
            System.out.println("Titre principal: " + headingText);
            
            // Vérifier que le titre parle bien d'images
            assert headingText.toLowerCase().contains("broken") || 
                   headingText.toLowerCase().contains("image") : 
                "Le titre devrait parler d'images cassées";
            
        } catch (Exception e) {
            System.out.println("⚠️ Pas de titre h3 trouvé");
        }
        
        // Vérifier qu'il y a bien des images
        List<WebElement> images = driver.findElements(By.tagName("img"));
        assert !images.isEmpty() : "La page devrait contenir des images";
        
        // Vérifier les attributs des images
        for (WebElement image : images) {
            String src = image.getAttribute("src");
            assert src != null && !src.isEmpty() : "Chaque image devrait avoir un attribut src";
            System.out.println("Image trouvée: " + src);
        }
    }
    
    /**
     * Vérifie le statut HTTP d'une image
     * Cette méthode détermine si une image est accessible via une requête HTTP
     * 
     * @param imageUrl L'URL de l'image à vérifier
     * @return true si l'image est accessible (code 2xx), false sinon
     */
    private boolean checkImageStatus(String imageUrl) {
        // ÉTAPE 1: Validation de l'entrée
        // On vérifie que l'URL n'est pas nulle ou vide
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            return false;
        }
        
        try {
            // ÉTAPE 2: Création de l'objet URL
            // Convertit la chaîne de caractères en objet URL Java
            URL url = new URL(imageUrl);
            
            // ÉTAPE 3: Ouverture de la connexion HTTP
            // openConnection() crée une connexion sans l'ouvrir immédiatement
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // ÉTAPE 4: Configuration de la requête
            // HEAD ne télécharge que les en-têtes, pas le contenu (plus rapide)
            connection.setRequestMethod("HEAD");
            
            // Timeouts pour éviter que le test ne bloque indéfiniment
            connection.setConnectTimeout(3000); // 3 secondes pour se connecter
            connection.setReadTimeout(3000);    // 3 secondes pour lire
            
            // ÉTAPE 5: Envoi de la requête et récupération du code
            // getResponseCode() envoie réellement la requête HTTP
            int responseCode = connection.getResponseCode();
            
            // ÉTAPE 6: Nettoyage de la connexion
            // Important pour libérer les ressources réseau
            connection.disconnect();
            
            // ÉTAPE 7: Interprétation du code de réponse
            // Codes 2xx (200-299) indiquent que l'image est accessible
            // 200 = OK, 201 = Created, etc.
            return (responseCode >= 200 && responseCode < 300);
            
        } catch (IOException e) {
            // ÉTAPE 8: Gestion des erreurs
            // Si la connexion échoue (URL invalide, réseau inaccessible, etc.)
            // on considère que l'image est cassée
            return false;
        }
    }
    
    @AfterMethod
    public void tearDown() {
        // ÉTAPE 1: Vérification que le driver existe
        // Évite les NullPointerException si le test a échoué avant l'initialisation
        if (driver != null) {
            // ÉTAPE 2: Fermeture complète du navigateur
            // quit() ferme toutes les fenêtres/onglets ET termine le processus du navigateur
            // C'est plus propre que close() qui ne ferme que la fenêtre actuelle
            driver.quit();
        }
        // ÉTAPE 3: Nettoyage automatique
        // Le garbage collector pourra libérer la mémoire utilisée par le driver
    }
}
