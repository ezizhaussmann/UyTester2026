package pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CubeCartAdminPage {

    private final Page page;

    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator customerListLink;
    private final Locator addCustomerLink;
    private final Locator dashboardLink;
    private final Locator logoutLink;

    public CubeCartAdminPage(Page page) {
        this.page             = page;
        this.usernameField    = page.getByLabel("Username");
        this.passwordField    = page.getByLabel("Password");
        this.loginButton      = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In"));
        this.customerListLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List"));
        this.addCustomerLink  = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer"));
        this.dashboardLink    = page.locator("#tab_dashboard").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Dashboard"));
        this.logoutLink       = page.locator("a[href*='logout']");
    }

    public void navigate() {
        page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
    }

    public void login(String username, String password) {
        usernameField.click();
        usernameField.fill(username);
        passwordField.click();
        passwordField.fill(password);
        loginButton.click();
    }

    public void goToCustomerList() {
        customerListLink.click();
    }

    public void goToAddCustomer() {
        addCustomerLink.click();
    }

    public void goToDashboard() {
        dashboardLink.click();
    }

    public void logout() {
        logoutLink.click();
    }
}
