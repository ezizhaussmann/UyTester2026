package org.tester.a_uiautomatisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // 1. Les Locators (Sélecteurs)
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    // 2. Le Constructeur (Pour utiliser le navigateur du test)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Les Méthodes (Actions sur la page)
    public void enterUsername(String user) {
        driver.findElement(usernameField).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Une méthode combinée pour aller plus vite
    public void loginAction(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
