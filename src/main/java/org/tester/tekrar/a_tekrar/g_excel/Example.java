package org.tester.tekrar.a_tekrar.g_excel;

/**
 * @created : 15/04/2026,18:27,mer.
 **/
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            page.getByLabel("Username").click();
            page.getByLabel("Username").click();
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").click();
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
            page.locator("#Customers i").click();
            page.locator("#Customers i").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer")).click();
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Disabled")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("kata"+System.currentTimeMillis());
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("charlotte");
            page.getByLabel("Type").selectOption("2");
            page.getByLabel("Currency").selectOption("JPY");
            page.getByLabel("Notes (Private)").click();
            page.getByLabel("Amount").click();
            page.getByLabel("Amount").click();
            page.getByLabel("Amount").click(new Locator.ClickOptions()
                    .setClickCount(3));
            page.getByLabel("Amount").fill("20000");
            page.getByLabel("Email").click();
            page.getByLabel("Email").fill("katachan"+System.currentTimeMillis()+"@gg.cc");
            page.getByLabel("Phone").click();
            page.getByLabel("Phone").fill("1234864541564");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).first().click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Katachan");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Log Out")).click();
        }
    }
}
