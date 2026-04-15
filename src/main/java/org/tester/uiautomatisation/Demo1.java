package org.tester.uiautomatisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo1 {
    public static void main(String[] args) {
//        FirefoxDriver fire = new FirefoxDriver();
        EdgeDriver fire = new EdgeDriver();
        // WebDriverWait est ton meilleur ami pour éviter les crashs
        WebDriverWait wait = new WebDriverWait(fire, Duration.ofSeconds(10));

        try {
            fire.navigate().to("https://demo.cubecart.com/cc6/admin_5xArPd.php");
            fire.manage().window().maximize();

            // --- ÉTAPE 1 : GÉRER LES POP-UPS D'ABORD ---


            // --- ÉTAPE 2 : CONNEXION ---
            // On utilise wait pour être sûr que le champ est prêt
            WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
            user.sendKeys("cubecart");

            fire.findElement(By.name("password")).sendKeys("cubecart");
            fire.findElement(By.id("login")).click();

            System.out.println("Test terminé avec succès !");

        } catch (Exception e) {
            System.err.println("Erreur durant le test : " + e.getMessage());
        } finally {
            // Toujours fermer à la fin
            fire.quit();
        }
    }
}
