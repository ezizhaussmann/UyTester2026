package org.tester.pom;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.io.FileWriter;
import java.io.IOException;

public class GetAddCustomerSource {
    public static void main(String[] args) throws IOException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();

            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
            page.waitForLoadState();

            // Click Customer List
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.waitForLoadState();

            // Click Add Customer
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer")).click();
            page.waitForLoadState();

            // Save HTML
            try (FileWriter fw = new FileWriter("target/addcustomer_form.html")) {
                fw.write(page.content());
            }
            System.out.println("URL actuelle : " + page.url());
            System.out.println("HTML saved !");
        }
    }
}
