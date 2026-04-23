package org.tester.xxx_Play;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NouveauTestJUnit {

    private static Playwright playwright;
    private static Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeAll
    static void setupBrowser() {
        playwright = Playwright.create();
        browser    = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void setupPage() {
        context = browser.newContext();
        page    = context.newPage();
        page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
        page.getByLabel("Username").fill("cubecart");
        page.getByLabel("Password").fill("cubecart");
        clickButton("Log In");
        System.out.println("✅ Login réussi.");
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private void clickLink(String name) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(name)).click();
    }

    private void clickButton(String name) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(name)).click();
    }

    private void fillTextbox(String label, String value) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(label)).fill(value);
    }

    private void addCustomer(String firstName, String lastName, String email) {
        clickLink("Customer List");
        clickLink("Add Customer");
        fillTextbox("First Name", firstName);
        fillTextbox("Last Name", lastName);
        page.getByLabel("Email").fill(email);
        clickButton("Save");
        assertThat(page.getByText("Customer successfully added.")).isVisible();
    }

    // ── Tests ─────────────────────────────────────────────────────────────────

    @Test
    void testAddCustomer1() {
        addCustomer("katachan", "charlotte", "katachan" + System.currentTimeMillis() + "@gg.cc");
        System.out.println("✅ Customer 1 ajouté avec succès.");
    }

    @Test
    void testAddCustomer2() {
        addCustomer("koala", "awstrol", "koala" + System.currentTimeMillis() + "@gg.cc");
        System.out.println("✅ Customer 2 ajouté avec succès.");
    }

    @Test
    void testUpdateCustomer() {
        clickLink("Customer List");
        page.waitForLoadState();
        page.locator("td a[href*='action=edit']").first().click();
        page.waitForLoadState();
        fillTextbox("First Name", "Katach");
        clickButton("Save");
        assertThat(page.getByText("Customer successfully updated.")).isVisible();
        System.out.println("✅ Customer mis à jour avec succès.");
    }

    @Test
    void testLogout() {
        page.locator("a[href*='logout']").click();
        assertThat(page.getByLabel("Username")).isVisible();
        System.out.println("✅ Déconnexion réussie.");
    }

    @AfterEach
    void tearDownPage() {
        context.close();
    }

    @AfterAll
    static void tearDownBrowser() {
        browser.close();
        playwright.close();
    }
}
