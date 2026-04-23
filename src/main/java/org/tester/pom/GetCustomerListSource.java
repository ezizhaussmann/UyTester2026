package org.tester.pom;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.io.FileWriter;
import java.io.IOException;

public class GetCustomerListSource {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();

            page.navigate("https://demo.cubecart.com/admin_5xArPd.php");
            page.getByLabel("Username").fill("cubecart");
            page.getByLabel("Password").fill("cubecart");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
            page.waitForLoadState();

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customer List")).click();
            page.waitForLoadState();
            Thread.sleep(2000);

            try (FileWriter fw = new FileWriter("target/customerlist_source.html")) {
                fw.write(page.content());
            }
            System.out.println("HTML saved !");
            System.out.println("URL : " + page.url());
        }
    }
}
