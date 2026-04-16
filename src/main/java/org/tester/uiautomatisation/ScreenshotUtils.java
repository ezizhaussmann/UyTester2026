package org.tester.uiautomatisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "target/screenshots";

    /**
     * Capture une capture d'écran et l'enregistre dans le dossier target/screenshots/
     * 
     * @param driver Le WebDriver instance
     * @param fileName Le nom du fichier (sans extension)
     */
    public static void capture(WebDriver driver, String fileName) {
        try {
            // Créer le dossier s'il n'existe pas
            createScreenshotDirectory();
            
            // Générer un nom de fichier avec timestamp si non fourni
            String fullFileName = fileName;
            if (fileName == null || fileName.trim().isEmpty()) {
                fullFileName = "screenshot_" + getCurrentTimestamp();
            }
            
            // Prendre la capture d'écran
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Créer le fichier de destination
            File destination = new File(SCREENSHOT_DIR + "/" + fullFileName + ".png");
            
            // Copier la capture d'écran vers le dossier de destination
            FileUtils.copyFile(screenshot, destination);
            
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            
        } catch (Exception e) {
            System.err.println("Erreur lors de la capture d'écran: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Capture une capture d'écran avec un nom de fichier généré automatiquement
     * 
     * @param driver Le WebDriver instance
     */
    public static void capture(WebDriver driver) {
        capture(driver, null);
    }

    /**
     * Crée le dossier des captures d'écran s'il n'existe pas
     */
    private static void createScreenshotDirectory() {
        File directory = new File(SCREENSHOT_DIR);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Dossier de screenshots créé: " + SCREENSHOT_DIR);
            } else {
                System.err.println("Impossible de créer le dossier: " + SCREENSHOT_DIR);
            }
        }
    }

    /**
     * Génère un timestamp formaté pour les noms de fichiers
     * 
     * @return String timestamp au format yyyyMMdd_HHmmss
     */
    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(new Date());
    }

    /**
     * Capture une capture d'écran avec un préfixe et timestamp
     * 
     * @param driver Le WebDriver instance
     * @param prefix Le préfixe du nom de fichier
     */
    public static void captureWithTimestamp(WebDriver driver, String prefix) {
        String fileName = prefix + "_" + getCurrentTimestamp();
        capture(driver, fileName);
    }
}
