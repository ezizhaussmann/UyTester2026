package org.tester.pom;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.io.FileWriter;
import java.io.IOException;

public class GetSuccessSource {
    public static void main(String[] args) throws IOException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();

            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
            page.waitForLoadState();

            page.navigate("https://demo.cubecart.com/admin_5xArPd.php?_g=customers&action=add");
            page.waitForLoadState();

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("test");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("user");
            page.getByLabel("Email").fill("test" + System.currentTimeMillis() + "@gg.cc");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            page.waitForLoadState();

            try (FileWriter fw = new FileWriter("target/success_source.html")) {
                fw.write(page.content());
            }
            System.out.println("HTML saved !");
        }
    }
}
