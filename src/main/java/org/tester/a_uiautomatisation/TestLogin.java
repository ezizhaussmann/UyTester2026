package org.tester.a_uiautomatisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

        // Initialisation de la page
        LoginPage loginPage = new LoginPage(driver);

        // Utilisation des méthodes de la page
        loginPage.loginAction("standard_user", "secret_sauce");

        // Vérification
        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("Test Réussi !");
        }

        driver.quit();
    }
}
