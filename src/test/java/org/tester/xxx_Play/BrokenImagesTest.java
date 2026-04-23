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
import java.util.ArrayList;
import java.util.List;

/**
 * Test pour détecter les images cassées sur une page web
 * @created : 21/04/2026,20:59,mar.
 **/
public class BrokenImagesTest {
    
    private WebDriver driver;
    private static final String TEST_URL = "https://the-internet.herokuapp.com/broken_images";
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testBrokenImages() {
        System.out.println("Test de détection d'images cassées");
        
        // Naviguer vers la page de test
        driver.get(TEST_URL);
        
        // Trouver toutes les images sur la page
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Nombre total d'images trouvées: " + images.size());
        
        List<String> brokenImages = new ArrayList<>();
        List<String> validImages = new ArrayList<>();
        
        // Vérifier chaque image
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageSrc = image.getAttribute("src");
            
            System.out.println("\nVérification de l'image " + (i + 1) + ": " + imageSrc);
            
            if (imageSrc == null || imageSrc.isEmpty()) {
                System.out.println("❌ Image sans source");
                brokenImages.add("Image " + (i + 1) + ": Source vide");
                continue;
            }
            
            try {
                // Vérifier si l'image est accessible via HTTP
                boolean isImageValid = isImageValid(imageSrc);
                
                if (isImageValid) {
                    System.out.println("✅ Image valide: " + imageSrc);
                    validImages.add(imageSrc);
                } else {
                    System.out.println("❌ Image cassée: " + imageSrc);
                    brokenImages.add(imageSrc);
                }
                
                // Vérifier également les attributs de l'image
                checkImageAttributes(image, i + 1);
                
            } catch (Exception e) {
                System.out.println("❌ Erreur lors de la vérification de l'image: " + e.getMessage());
                brokenImages.add(imageSrc + " - Erreur: " + e.getMessage());
            }
        }
        
        // Afficher le résumé
        System.out.println("\n=== RÉSUMÉ ===");
        System.out.println("Images valides: " + validImages.size());
        System.out.println("Images cassées: " + brokenImages.size());
        
        if (!validImages.isEmpty()) {
            System.out.println("\n✅ Images valides:");
            validImages.forEach(img -> System.out.println("  - " + img));
        }
        
        if (!brokenImages.isEmpty()) {
            System.out.println("\n❌ Images cassées:");
            brokenImages.forEach(img -> System.out.println("  - " + img));
        }
        
        // Assertions spécifiques pour cette page de test
        assert images.size() == 3 : "La page devrait contenir exactement 3 images, trouvé: " + images.size();
        assert brokenImages.size() == 2 : "La page devrait contenir exactement 2 images cassées, trouvé: " + brokenImages.size();
        assert validImages.size() == 1 : "La page devrait contenir exactement 1 image valide, trouvé: " + validImages.size();
        
        System.out.println("\n🎯 Test terminé - " + brokenImages.size() + "/3 images cassées détectées comme attendu");
    }
    
    @Test
    public void testImageDimensions() {
        System.out.println("Test des dimensions des images");
        
        driver.get(TEST_URL);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageSrc = image.getAttribute("src");
            
            try {
                // Obtenir les dimensions via JavaScript
                Long width = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", image);
                
                Long height = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalHeight;", image);
                
                System.out.println("Image " + (i + 1) + " (" + imageSrc + "): " + width + "x" + height);
                
                if (width != null && height != null) {
                    if (width == 0 || height == 0) {
                        System.out.println("❌ Image avec dimensions nulles (probablement cassée)");
                    } else {
                        System.out.println("✅ Image avec dimensions valides");
                    }
                } else {
                    System.out.println("⚠️ Impossible de déterminer les dimensions");
                }
                
            } catch (Exception e) {
                System.out.println("❌ Erreur lors de la vérification des dimensions: " + e.getMessage());
            }
        }
    }
    
    @Test
    public void testImageLoadingWithJavaScript() {
        System.out.println("Test de chargement des images via JavaScript");
        
        driver.get(TEST_URL);
        
        // Attendre que toutes les images soient chargées
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Exécuter du JavaScript pour vérifier le chargement des images
        String script = 
            "var images = document.getElementsByTagName('img');" +
            "var results = [];" +
            "for (var i = 0; i < images.length; i++) {" +
            "  var img = images[i];" +
            "  var result = {" +
            "    src: img.src," +
            "    complete: img.complete," +
            "    naturalWidth: img.naturalWidth," +
            "    naturalHeight: img.naturalHeight" +
            "  };" +
            "  results.push(result);" +
            "}" +
            "return results;";
        
        List<Object> imageResults = (List<Object>) ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript(script);
        
        System.out.println("Analyse JavaScript des images:");
        
        for (int i = 0; i < imageResults.size(); i++) {
            Object result = imageResults.get(i);
            // Note: Le parsing dépend de l'implémentation du driver
            System.out.println("Image " + (i + 1) + ": " + result.toString());
        }
    }
    
    /**
     * Vérifie si une image est valide en envoyant une requête HTTP HEAD
     */
    private boolean isImageValid(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int responseCode = connection.getResponseCode();
            System.out.println("  Code de réponse HTTP: " + responseCode);
            
            // Vérifier si le code de réponse est OK (200-299)
            boolean isValid = (responseCode >= 200 && responseCode < 300);
            
            // Vérifier le content-type
            String contentType = connection.getContentType();
            if (contentType != null) {
                System.out.println("  Content-Type: " + contentType);
                isValid = isValid && contentType.startsWith("image/");
            }
            
            connection.disconnect();
            return isValid;
            
        } catch (IOException e) {
            System.out.println("  Erreur HTTP: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Vérifie les attributs d'une image
     */
    private void checkImageAttributes(WebElement image, int imageNumber) {
        String alt = image.getAttribute("alt");
        String title = image.getAttribute("title");
        String width = image.getAttribute("width");
        String height = image.getAttribute("height");
        
        System.out.println("  Attributs de l'image " + imageNumber + ":");
        System.out.println("    Alt: " + (alt != null ? alt : "non défini"));
        System.out.println("    Title: " + (title != null ? title : "non défini"));
        System.out.println("    Width: " + (width != null ? width : "non défini"));
        System.out.println("    Height: " + (height != null ? height : "non défini"));
        
        // Vérifier si l'image a un attribut alt (accessibilité)
        if (alt == null || alt.trim().isEmpty()) {
            System.out.println("  ⚠️ Attribut alt manquant (problème d'accessibilité)");
        }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
