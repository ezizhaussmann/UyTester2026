package junittesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CubeCartAdminPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(linkText = "Customer List")
    private WebElement customerListLink;

    @FindBy(linkText = "Add Customer")
    private WebElement addCustomerLink;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(css = "a[href*='logout']")
    private WebElement logoutLink;

    @FindBy(name = "customer[first_name]")
    private WebElement firstNameField;

    @FindBy(name = "customer[last_name]")
    private WebElement lastNameField;

    @FindBy(name = "customer[email]")
    private WebElement emailField;

    @FindBy(css = "input[name='save']")
    private WebElement saveButton;

    @FindBy(css = "div.success")
    private WebElement successMessage;

    public CubeCartAdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get("https://demo.cubecart.com/admin_5xArPd.php");
        System.out.println("✅ Navigation vers la page de connexion réussie.");
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        System.out.println("✅ Connexion réussie avec l'utilisateur : " + username);
    }

    public void goToCustomerList() {
        wait.until(ExpectedConditions.elementToBeClickable(customerListLink));
        customerListLink.click();
        System.out.println("✅ Navigation vers la liste des clients réussie.");
    }

    public void goToAddCustomer() {
        driver.get("https://demo.cubecart.com/admin_5xArPd.php?_g=customers&action=add");
        PageFactory.initElements(driver, this);
        System.out.println("✅ Navigation vers le formulaire d'ajout client réussie.");
    }

    public void addCustomer(String firstName, String lastName, String email) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        System.out.println("✅ Prénom saisi : " + firstName);

        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        System.out.println("✅ Nom saisi : " + lastName);

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("✅ Email saisi : " + email);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        System.out.println("✅ Formulaire soumis, en attente de confirmation...");
    }

    public void verifyCustomerAdded() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        System.out.println("✅ Client ajouté avec succès : " + successMessage.getText());
    }

    public void goToDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLink));
        dashboardLink.click();
        System.out.println("✅ Navigation vers le Dashboard réussie.");
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        System.out.println("✅ Déconnexion réussie.");
    }
}
