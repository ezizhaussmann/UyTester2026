package org.tester.b_Add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//
//        options.setExperimentalOption("prefs", prefs);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        WebDriver coco = new ChromeDriver(options);
//        ChromeDriver coco = new ChromeDriver();
        FirefoxDriver coco = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(coco, Duration.ofSeconds(10));
        String s = "cubecart";
        String s1 = "cubecart";
        coco.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        coco.manage().window().maximize();
//        driver.findElement(By.id()).sendKeys("cubecart");
        WebElement user = coco.findElement(By.id("username"));
        WebElement pass = coco.findElement(By.id("password"));
        user.sendKeys(s);
        pass.sendKeys(s1);
        WebElement login = coco.findElement(By.id("login"));
        login.click();
        WebElement customerList = coco.findElement(By.linkText("Customer List"));
        customerList.click();
        WebElement addCustomer = coco.findElement(By.linkText("Add Customer"));
        addCustomer.click();
        WebElement chec = coco.findElement(By.xpath("//img[@alt=\"Enable\"]"));
        chec.click();
        WebElement prenom = coco.findElement(By.id("cust-firstname"));
        prenom.sendKeys("kata");
        WebElement nom = coco.findElement(By.id("cust-lastname"));
        nom.sendKeys("chan");
        WebElement selec = coco.findElement(By.name("customer[currency]"));
        Select select = new Select(selec);
        WebElement email = coco.findElement(By.id("cust-email"));
        select.selectByValue("JPY");
        email.sendKeys("katachan75@gg.com");
//        selec.click();
        WebElement save = coco.findElement(By.xpath("//input[@value=\"Save\"]"));
        save.click();
//        WebElement logout = coco.findElement(By.xpath("//*[@id=\"header\"]/span/a[2]"));
//        logout.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header']/span/a[2]"))).click();

        coco.close();
        coco.quit();
    }
}
