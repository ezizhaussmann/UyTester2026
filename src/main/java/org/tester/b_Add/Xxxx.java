package org.tester.b_Add;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Xxxx {
    public static void main(String[] args) {
        // FORCE le chemin vers le fichier que tu viens de télécharger
        System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Common Files\\edgedriver_win64");

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate"); // Pour éviter les alertes de mot de passe (image_0f517a)

        WebDriver coco = new EdgeDriver(options);

        coco.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        // ... la suite de ton code ...
    }
}
