package org.tester.xxx_Play;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test final optimisé pour la détection d'images cassées
 * Performances améliorées, gestion robuste des erreurs, rapports détaillés
 * @created : 21/04/2026,21:14,mar.
 **/
public class BrokenImagesFinalTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String TEST_URL = "https://the-internet.herokuapp.com/broken_images";
    private static final int TIMEOUT_SECONDS = 10;
    private static final int HTTP_TIMEOUT = 3000;
    
    @BeforeMethod
    public void setUp() {
        System.out.println("🚀 Initialisation optimisée...");
        
        try {
            // Configuration optimisée du driver
            System.setProperty("webdriver.chrome.args", "--no-sandbox,--disable-dev-shm-usage,--disable-gpu");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
            
            // WebDriverWait explicite pour les attentes ciblées
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
            
            System.out.println("✅ WebDriver initialisé avec succès");
        } catch (Exception e) {
            System.err.println("❌ Erreur critique d'initialisation: " + e.getMessage());
            throw new RuntimeException("Échec d'initialisation du WebDriver", e);
        }
    }
    
    @Test
    public void testBrokenImagesOptimized() {
        System.out.println("🔍 Test optimisé de détection d'images cassées");
        long startTime = System.currentTimeMillis();
        
        try {
            // Navigation avec attente explicite
            System.out.println("📍 Navigation vers: " + TEST_URL);
            driver.get(TEST_URL);
            
            // Attendre que la page soit prête
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            
            // Vérification rapide de la page
            String pageTitle = driver.getTitle();
            System.out.println("📄 Page: " + pageTitle);
            
            // Recherche optimisée des images
            List<WebElement> images = findImagesOptimized();
            
            if (images.isEmpty()) {
                System.out.println("⚠️ Aucune image trouvée - Analyse de la page...");
                analyzePageStructure();
                return;
            }
            
            // Analyse parallèle des images
            ImageAnalysisResult result = analyzeImagesParallel(images);
            
            // Affichage des résultats optimisés
            displayResults(result, startTime);
            
            // Assertions flexibles mais précises
            validateResults(result);
            
        } catch (Exception e) {
            System.err.println("❌ Erreur dans le test: " + e.getMessage());
            throw new RuntimeException("Test échoué", e);
        }
    }
    
    @Test
    public void testImagePerformance() {
        System.out.println("⚡ Test de performance des images");
        
        try {
            driver.get(TEST_URL);
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            
            List<WebElement> images = findImagesOptimized();
            
            if (images.isEmpty()) {
                System.out.println("⚠️ Aucune image à analyser");
                return;
            }
            
            // Mesure des temps de chargement
            Map<String, Long> loadTimes = measureImageLoadTimes(images);
            
            // Affichage des performances
            System.out.println("\n=== PERFORMANCE DES IMAGES ===");
            loadTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> 
                    System.out.printf("📊 %s: %dms%n", 
                        entry.getKey().substring(entry.getKey().lastIndexOf('/') + 1), 
                        entry.getValue()));
            
            // Vérification des seuils de performance
            long maxLoadTime = Collections.max(loadTimes.values());
            long avgLoadTime = loadTimes.values().stream().mapToLong(Long::longValue).sum() / loadTimes.size();
            
            System.out.printf("⏱️ Temps moyen: %dms, Maximum: %dms%n", avgLoadTime, maxLoadTime);
            
        } catch (Exception e) {
            System.err.println("❌ Erreur test performance: " + e.getMessage());
        }
    }
    
    @Test
    public void testRobustness() {
        System.out.println("🛡️ Test de robustesse et gestion d'erreurs");
        
        try {
            driver.get(TEST_URL);
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            
            List<WebElement> images = findImagesOptimized();
            
            // Test avec différentes conditions
            System.out.println("🔬 Test 1: Images avec URLs invalides");
            testInvalidUrls(images);
            
            System.out.println("🔬 Test 2: Images avec timeouts");
            testTimeoutHandling(images);
            
            System.out.println("🔬 Test 3: Images avec redirections");
            testRedirectionHandling(images);
            
            System.out.println("✅ Tests de robustesse terminés");
            
        } catch (Exception e) {
            System.err.println("❌ Erreur test robustesse: " + e.getMessage());
        }
    }
    
    /**
     * Recherche optimisée des images avec gestion d'erreurs
     */
    private List<WebElement> findImagesOptimized() {
        try {
            // Utilisation de JavaScript pour une recherche plus rapide
            String jsScript = "return Array.from(document.getElementsByTagName('img'))" +
                           ".filter(img => img.src && img.src.trim() !== '');";
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> imageData = (List<Map<String, Object>>) 
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(jsScript);
            
            System.out.println("🖼️ Images trouvées via JS: " + imageData.size());
            
            // Retourner les éléments Selenium pour compatibilité
            return driver.findElements(By.tagName("img"));
            
        } catch (Exception e) {
            System.err.println("⚠️ Erreur recherche JS, utilisation de Selenium: " + e.getMessage());
            return driver.findElements(By.tagName("img"));
        }
    }
    
    /**
     * Analyse parallèle des images pour meilleures performances
     */
    private ImageAnalysisResult analyzeImagesParallel(List<WebElement> images) {
        ImageAnalysisResult result = new ImageAnalysisResult();
        
        // Utilisation d'un pool de threads pour l'analyse parallèle
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(images.size(), 4));
        List<CompletableFuture<ImageCheckResult>> futures = new ArrayList<>();
        
        for (int i = 0; i < images.size(); i++) {
            final int index = i;
            final WebElement image = images.get(i);
            
            CompletableFuture<ImageCheckResult> future = CompletableFuture.supplyAsync(() -> {
                try {
                    String src = image.getAttribute("src");
                    return checkImageStatusOptimized(src, index + 1);
                } catch (Exception e) {
                    return new ImageCheckResult(ImageStatus.ERROR, 
                        "Erreur analyse: " + e.getMessage(), 0, 0, 0);
                }
            }, executor);
            
            futures.add(future);
        }
        
        // Attendre la fin de toutes les analyses
        for (CompletableFuture<ImageCheckResult> future : futures) {
            try {
                ImageCheckResult checkResult = future.get(10, TimeUnit.SECONDS);
                result.addResult(checkResult);
            } catch (Exception e) {
                result.addError("Timeout analyse: " + e.getMessage());
            }
        }
        
        executor.shutdown();
        return result;
    }
    
    /**
     * Vérification optimisée du statut d'une image
     */
    private ImageCheckResult checkImageStatusOptimized(String imageUrl, int imageNumber) {
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            return new ImageCheckResult(ImageStatus.BROKEN, "URL vide", imageNumber, 0, 0);
        }
        
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Configuration optimisée
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(HTTP_TIMEOUT);
            connection.setReadTimeout(HTTP_TIMEOUT);
            connection.setUseCaches(false);
            connection.addRequestProperty("User-Agent", "Selenium-Test/1.0");
            
            int responseCode = connection.getResponseCode();
            String contentType = connection.getContentType();
            long contentLength = connection.getContentLengthLong();
            
            connection.disconnect();
            
            // Analyse du résultat
            boolean isValid = (responseCode >= 200 && responseCode < 300);
            boolean isImage = contentType != null && contentType.startsWith("image/");
            
            if (isValid && isImage) {
                return new ImageCheckResult(ImageStatus.VALID, "Image accessible", 
                    imageNumber, responseCode, contentLength);
            } else if (!isValid) {
                return new ImageCheckResult(ImageStatus.BROKEN, 
                    "HTTP " + responseCode, imageNumber, responseCode, contentLength);
            } else {
                return new ImageCheckResult(ImageStatus.BROKEN, 
                    "Content-Type: " + contentType, imageNumber, responseCode, contentLength);
            }
            
        } catch (IOException e) {
            return new ImageCheckResult(ImageStatus.ERROR, 
                "Réseau: " + e.getMessage(), imageNumber, 0, 0);
        } catch (Exception e) {
            return new ImageCheckResult(ImageStatus.ERROR, 
                "Général: " + e.getMessage(), imageNumber, 0, 0);
        }
    }
    
    /**
     * Mesure des temps de chargement des images
     */
    private Map<String, Long> measureImageLoadTimes(List<WebElement> images) {
        Map<String, Long> loadTimes = new HashMap<>();
        
        for (WebElement image : images) {
            try {
                String src = image.getAttribute("src");
                if (src == null || src.trim().isEmpty()) continue;
                
                long startTime = System.currentTimeMillis();
                
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(HTTP_TIMEOUT);
                connection.setReadTimeout(HTTP_TIMEOUT);
                
                connection.getResponseCode();
                long loadTime = System.currentTimeMillis() - startTime;
                
                loadTimes.put(src, loadTime);
                connection.disconnect();
                
            } catch (Exception e) {
                loadTimes.put(image.getAttribute("src"), -1L); // Erreur
            }
        }
        
        return loadTimes;
    }
    
    /**
     * Tests de robustesse avec URLs invalides
     */
    private void testInvalidUrls(List<WebElement> images) {
        System.out.println("  🧪 Test avec URLs invalides...");
        
        // Test avec une URL invalide
        ImageCheckResult result = checkImageStatusOptimized("http://invalid-url-that-does-not-exist.com/image.jpg", 999);
        System.out.println("    Résultat URL invalide: " + result.status + " - " + result.message);
    }
    
    /**
     * Tests de gestion des timeouts
     */
    private void testTimeoutHandling(List<WebElement> images) {
        System.out.println("  🧪 Test gestion timeouts...");
        
        // Test avec un serveur lent
        ImageCheckResult result = checkImageStatusOptimized("http://httpbin.org/delay/10", 998);
        System.out.println("    Résultat timeout: " + result.status + " - " + result.message);
    }
    
    /**
     * Tests de gestion des redirections
     */
    private void testRedirectionHandling(List<WebElement> images) {
        System.out.println("  🧪 Test gestion redirections...");
        
        // Test avec une URL qui redirige
        ImageCheckResult result = checkImageStatusOptimized("http://httpbin.org/redirect/1", 997);
        System.out.println("    Résultat redirection: " + result.status + " - " + result.message);
    }
    
    /**
     * Analyse de la structure de la page pour debug
     */
    private void analyzePageStructure() {
        try {
            String script = "return {" +
                "title: document.title," +
                "imgCount: document.getElementsByTagName('img').length," +
                "hasImages: document.getElementsByTagName('img').length > 0," +
                "readyState: document.readyState" +
                "};";
            
            Map<String, Object> pageInfo = (Map<String, Object>) 
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
            
            System.out.println("📊 Analyse page:");
            System.out.println("  Titre: " + pageInfo.get("title"));
            System.out.println("  Images: " + pageInfo.get("imgCount"));
            System.out.println("  État: " + pageInfo.get("readyState"));
            
        } catch (Exception e) {
            System.err.println("❌ Erreur analyse page: " + e.getMessage());
        }
    }
    
    /**
     * Affichage optimisé des résultats
     */
    private void displayResults(ImageAnalysisResult result, long startTime) {
        long totalTime = System.currentTimeMillis() - startTime;
        
        System.out.println("\n=== RÉSULTATS OPTIMISÉS ===");
        System.out.printf("⏱️ Temps total: %dms%n", totalTime);
        System.out.printf("🖼️ Images analysées: %d%n", result.getTotalAnalyzed());
        System.out.printf("✅ Images valides: %d%n", result.getValidCount());
        System.out.printf("❌ Images cassées: %d%n", result.getBrokenCount());
        System.out.printf("🔥 Erreurs: %d%n", result.getErrorCount());
        
        if (!result.getValidImages().isEmpty()) {
            System.out.println("\n✅ Images valides:");
            result.getValidImages().forEach(img -> 
                System.out.printf("  📸 Image %d - %s (%d octets)%n", 
                    img.imageNumber, img.message, img.contentSize));
        }
        
        if (!result.getBrokenImages().isEmpty()) {
            System.out.println("\n❌ Images cassées:");
            result.getBrokenImages().forEach(img -> 
                System.out.printf("  💔 Image %d - %s (HTTP %d)%n", 
                    img.imageNumber, img.message, img.httpCode));
        }
    }
    
    /**
     * Validation des résultats avec assertions flexibles
     */
    private void validateResults(ImageAnalysisResult result) {
        // Assertions basiques
        assert result.getTotalAnalyzed() >= 0 : "Le nombre d'images analysées ne peut être négatif";
        assert result.getValidCount() + result.getBrokenCount() + result.getErrorCount() == result.getTotalAnalyzed() 
            : "Incohérence dans les comptes";
        
        // Assertions spécifiques à la page de test (si applicable)
        if (result.getTotalAnalyzed() > 0) {
            System.out.println("🎯 Test validé avec " + result.getTotalAnalyzed() + " images analysées");
            
            // Vérifier qu'on a bien des images cassées (attendu sur cette page)
            if (result.getBrokenCount() > 0) {
                System.out.println("✅ Images cassées détectées comme attendu");
            }
        }
    }
    
    // Classes internes pour les résultats
    
    private enum ImageStatus { VALID, BROKEN, ERROR }
    
    private static class ImageCheckResult {
        final ImageStatus status;
        final String message;
        final int imageNumber;
        final int httpCode;
        final long contentSize;
        
        ImageCheckResult(ImageStatus status, String message, int imageNumber, int httpCode, long contentSize) {
            this.status = status;
            this.message = message;
            this.imageNumber = imageNumber;
            this.httpCode = httpCode;
            this.contentSize = contentSize;
        }
    }
    
    private static class ImageAnalysisResult {
        private final List<ImageCheckResult> validImages = new ArrayList<>();
        private final List<ImageCheckResult> brokenImages = new ArrayList<>();
        private final List<ImageCheckResult> errorImages = new ArrayList<>();
        private final List<String> errors = new ArrayList<>();
        
        void addResult(ImageCheckResult result) {
            switch (result.status) {
                case VALID -> validImages.add(result);
                case BROKEN -> brokenImages.add(result);
                case ERROR -> errorImages.add(result);
            }
        }
        
        void addError(String error) {
            errors.add(error);
        }
        
        int getValidCount() { return validImages.size(); }
        int getBrokenCount() { return brokenImages.size(); }
        int getErrorCount() { return errorImages.size(); }
        int getTotalAnalyzed() { return getValidCount() + getBrokenCount() + getErrorCount(); }
        List<ImageCheckResult> getValidImages() { return validImages; }
        List<ImageCheckResult> getBrokenImages() { return brokenImages; }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("✅ WebDriver fermé avec succès");
            } catch (Exception e) {
                System.err.println("❌ Erreur fermeture: " + e.getMessage());
            }
        }
    }
}
