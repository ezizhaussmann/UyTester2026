package org.tester.pom;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.io.FileWriter;
import java.io.IOException;

public class GetPageSource {
    public static void main(String[] args) throws IOException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newContext().newPage();

            // Login page
            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            saveHtml(page.content(), "target/login_source.html");

            // After login - Add Customer page
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Customer")).click();
            page.waitForLoadState();
            saveHtml(page.content(), "target/addcustomer_source.html");

            System.out.println("HTML saved !");
        }
    }

    static void saveHtml(String content, String path) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(content);
        }
    }
}
