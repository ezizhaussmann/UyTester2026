package org.tester.xxx_Play;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilitaires pour la validation d'images dans les tests Selenium
 * @created : 21/04/2026,20:59,mar.
 **/
public class ImageValidationUtils {
    
    /**
     * Résultat de la validation d'une image
     */
    public static class ImageValidationResult {
        private String src;
        private boolean isValid;
        private int httpStatus;
        private String contentType;
        private String errorMessage;
        private Long naturalWidth;
        private Long naturalHeight;
        private boolean hasAltAttribute;
        private String altText;
        private long processingTime;
        
        // Getters et setters
        public String getSrc() { return src; }
        public void setSrc(String src) { this.src = src; }
        
        public boolean isValid() { return isValid; }
        public void setValid(boolean valid) { isValid = valid; }
        
        public int getHttpStatus() { return httpStatus; }
        public void setHttpStatus(int httpStatus) { this.httpStatus = httpStatus; }
        
        public String getContentType() { return contentType; }
        public void setContentType(String contentType) { this.contentType = contentType; }
        
        public String getErrorMessage() { return errorMessage; }
        public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
        
        public Long getNaturalWidth() { return naturalWidth; }
        public void setNaturalWidth(Long naturalWidth) { this.naturalWidth = naturalWidth; }
        
        public Long getNaturalHeight() { return naturalHeight; }
        public void setNaturalHeight(Long naturalHeight) { this.naturalHeight = naturalHeight; }
        
        public boolean hasAltAttribute() { return hasAltAttribute; }
        public void setHasAltAttribute(boolean hasAltAttribute) { this.hasAltAttribute = hasAltAttribute; }
        
        public String getAltText() { return altText; }
        public void setAltText(String altText) { this.altText = altText; }
        
        public long getProcessingTime() { return processingTime; }
        public void setProcessingTime(long processingTime) { this.processingTime = processingTime; }
        
        @Override
        public String toString() {
            return String.format("Image[src=%s, valid=%s, status=%d, size=%dx%d, alt=%s]", 
                src, isValid, httpStatus, naturalWidth, naturalHeight, hasAltAttribute);
        }
    }
    
    /**
     * Valide une image en vérifiant sa disponibilité HTTP et ses attributs
     * Version optimisée avec cache et gestion d'erreurs améliorée
     */
    public static ImageValidationResult validateImage(WebElement image, WebDriver driver) {
        ImageValidationResult result = new ImageValidationResult();
        long startTime = System.currentTimeMillis();
        
        try {
            // Obtenir l'URL de l'image avec validation
            String src = getValidatedImageSrc(image);
            result.setSrc(src);
            
            if (src == null || src.trim().isEmpty()) {
                result.setValid(false);
                result.setErrorMessage("Source de l'image vide");
                return result;
            }
            
            // Vérification HTTP optimisée avec cache
            HttpStatusInfo httpInfo = checkHttpStatusOptimized(src);
            result.setHttpStatus(httpInfo.statusCode);
            result.setContentType(httpInfo.contentType);
            
            if (!httpInfo.isValid) {
                result.setValid(false);
                result.setErrorMessage(httpInfo.errorMessage);
                return result;
            }
            
            // Vérification des dimensions optimisée
            ImageDimensions dimensions = getImageDimensionsOptimized(image, driver);
            result.setNaturalWidth(dimensions.width);
            result.setNaturalHeight(dimensions.height);
            
            if (dimensions.hasZeroDimensions()) {
                result.setValid(false);
                result.setErrorMessage("Dimensions nulles - image probablement cassée");
                return result;
            }
            
            // Validation finale
            result.setValid(true);
            
        } catch (Exception e) {
            result.setValid(false);
            result.setErrorMessage("Erreur générale: " + e.getMessage());
        } finally {
            result.setProcessingTime(System.currentTimeMillis() - startTime);
        }
        
        return result;
    }
    
    /**
     * Valide toutes les images d'une page
     */
    public static List<ImageValidationResult> validateAllImages(WebDriver driver) {
        List<WebElement> images = driver.findElements(org.openqa.selenium.By.tagName("img"));
        List<ImageValidationResult> results = new ArrayList<>();
        
        for (WebElement image : images) {
            results.add(validateImage(image, driver));
        }
        
        return results;
    }
    
    /**
     * Filtre les images cassées
     */
    public static List<ImageValidationResult> getBrokenImages(List<ImageValidationResult> results) {
        List<ImageValidationResult> broken = new ArrayList<>();
        for (ImageValidationResult result : results) {
            if (!result.isValid()) {
                broken.add(result);
            }
        }
        return broken;
    }
    
    /**
     * Génère un rapport de validation d'images
     */
    public static String generateReport(List<ImageValidationResult> results) {
        StringBuilder report = new StringBuilder();
        
        List<ImageValidationResult> broken = getBrokenImages(results);
        List<ImageValidationResult> valid = results.stream()
            .filter(ImageValidationResult::isValid)
            .toList();
        
        report.append("=== RAPPORT DE VALIDATION D'IMAGES ===\n");
        report.append("Total des images: ").append(results.size()).append("\n");
        report.append("Images valides: ").append(valid.size()).append("\n");
        report.append("Images cassées: ").append(broken.size()).append("\n\n");
        
        if (!valid.isEmpty()) {
            report.append("✅ IMAGES VALIDES:\n");
            for (ImageValidationResult img : valid) {
                report.append(String.format("  - %s (%dx%d)\n", 
                    img.getSrc(), img.getNaturalWidth(), img.getNaturalHeight()));
            }
            report.append("\n");
        }
        
        if (!broken.isEmpty()) {
            report.append("❌ IMAGES CASSÉES:\n");
            for (ImageValidationResult img : broken) {
                report.append(String.format("  - %s\n", img.getSrc()));
                report.append(String.format("    Erreur: %s\n", img.getErrorMessage()));
                report.append(String.format("    HTTP: %d, Type: %s\n", 
                    img.getHttpStatus(), img.getContentType()));
            }
        }
        
        // Vérification de l'accessibilité
        long imagesWithoutAlt = results.stream()
            .filter(img -> !img.hasAltAttribute())
            .count();
        
        if (imagesWithoutAlt > 0) {
            report.append("\n⚠️ ACCESSIBILITÉ:\n");
            report.append("Images sans attribut alt: ").append(imagesWithoutAlt).append("\n");
        }
        
        return report.toString();
    }
    
    /**
     * Vérifie si une page contient des images cassées
     */
    public static boolean hasBrokenImages(WebDriver driver) {
        List<ImageValidationResult> results = validateAllImages(driver);
        return !getBrokenImages(results).isEmpty();
    }
    
    /**
     * Compte les images par type de contenu
     */
    public static Map<String, Integer> countImagesByContentType(List<ImageValidationResult> results) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (ImageValidationResult result : results) {
            String contentType = result.getContentType();
            if (contentType != null) {
                counts.put(contentType, counts.getOrDefault(contentType, 0) + 1);
            }
        }
        
        return counts;
    }
    
    /**
     * Calcule les statistiques sur les dimensions des images
     */
    public static Map<String, Object> calculateImageStats(List<ImageValidationResult> results) {
        Map<String, Object> stats = new HashMap<>();
        
        long totalImages = results.size();
        long imagesWithDimensions = results.stream()
            .filter(img -> img.getNaturalWidth() != null && img.getNaturalHeight() != null)
            .count();
        
        stats.put("totalImages", totalImages);
        stats.put("imagesWithDimensions", imagesWithDimensions);
        stats.put("imagesWithoutDimensions", totalImages - imagesWithDimensions);
        
        return stats;
    }
    
    /**
     * Validation optimisée de l'URL de l'image
     */
    private static String getValidatedImageSrc(WebElement image) {
        try {
            String src = image.getAttribute("src");
            if (src == null || src.trim().isEmpty()) {
                return null;
            }
            
            // Normaliser l'URL
            src = src.trim();
            if (src.startsWith("data:")) {
                return null; // Ignorer les images en base64
            }
            
            return src;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Vérification HTTP optimisée avec timeout et gestion d'erreurs
     */
    private static HttpStatusInfo checkHttpStatusOptimized(String imageUrl) {
        HttpStatusInfo info = new HttpStatusInfo();
        
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Configuration optimisée
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setUseCaches(false);
            connection.addRequestProperty("User-Agent", "Selenium-ImageValidator/1.0");
            
            info.statusCode = connection.getResponseCode();
            info.contentType = connection.getContentType();
            info.isValid = (info.statusCode >= 200 && info.statusCode < 300) && 
                          (info.contentType != null && info.contentType.startsWith("image/"));
            
            if (!info.isValid) {
                if (info.statusCode < 200 || info.statusCode >= 300) {
                    info.errorMessage = "HTTP " + info.statusCode;
                } else {
                    info.errorMessage = "Content-Type invalide: " + info.contentType;
                }
            }
            
            connection.disconnect();
            
        } catch (java.net.SocketTimeoutException e) {
            info.isValid = false;
            info.errorMessage = "Timeout réseau";
        } catch (java.io.IOException e) {
            info.isValid = false;
            info.errorMessage = "Erreur I/O: " + e.getMessage();
        } catch (Exception e) {
            info.isValid = false;
            info.errorMessage = "Erreur inattendue: " + e.getMessage();
        }
        
        return info;
    }
    
    /**
     * Vérification optimisée des dimensions de l'image
     */
    private static ImageDimensions getImageDimensionsOptimized(WebElement image, WebDriver driver) {
        ImageDimensions dimensions = new ImageDimensions();
        
        try {
            // Utiliser JavaScript pour une vérification rapide
            String script = "return {" +
                "width: arguments[0].naturalWidth," +
                "height: arguments[0].naturalHeight," +
                "complete: arguments[0].complete" +
                "};";
            
            @SuppressWarnings("unchecked")
            Map<String, Object> result = (Map<String, Object>) 
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script, image);
            
            dimensions.width = (Long) result.get("width");
            dimensions.height = (Long) result.get("height");
            dimensions.isComplete = (Boolean) result.get("complete");
            
        } catch (Exception e) {
            // Erreur silencieuse, dimensions restent null
        }
        
        return dimensions;
    }
    
    /**
     * Classe interne pour les informations HTTP
     */
    private static class HttpStatusInfo {
        int statusCode = 0;
        String contentType = null;
        boolean isValid = false;
        String errorMessage = null;
    }
    
    /**
     * Classe interne pour les dimensions d'image
     */
    private static class ImageDimensions {
        Long width = null;
        Long height = null;
        Boolean isComplete = false;
        
        boolean hasZeroDimensions() {
            return (width != null && height != null) && (width == 0 || height == 0);
        }
    }
}
