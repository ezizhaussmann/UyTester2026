package org.tester.xxx_Play;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @created : 21/04/2026,02:46,mar.
 **/
public class NouveauTest {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // ── Login ────────────────────────────────────────────────
            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();

            // ── Add Customer 1 ───────────────────────────────────────
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("katachan");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("charlotte");
            page.getByLabel("Email").fill("katachan" + System.currentTimeMillis() + "@gg.cc");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            assertThat(page.getByText("Customer successfully added.")).isVisible();

            // ── Add Customer 2 ───────────────────────────────────────
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("koala");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("awstrol");
            page.getByLabel("Email").fill("koala" + System.currentTimeMillis() + "@gg.cc");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            assertThat(page.getByText("Customer successfully added.")).isVisible();

            // ── Update Customer ──────────────────────────────────────
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.waitForLoadState();
            page.locator("td a[href*='action=edit']").first().click();
            page.waitForLoadState();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Katach");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            assertThat(page.getByText("Customer successfully updated.")).isVisible();

            // ── Logout ───────────────────────────────────────────────
            page.locator("a[href*='logout']").click();
        }
    }
}
