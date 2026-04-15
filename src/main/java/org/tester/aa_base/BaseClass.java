package org.tester.aa_base;

/**
 * @created : 30/03/2026,13:32,lun.
 **/
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tester.propertiesFile.RedFromeConfig;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    // Les variables doivent aussi être static
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public static void setBrowser(String url) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void login(String userName, String passWord) {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.id("login")).click();
    }

    public static void addCustomerTest(String customerTitle, String firstName, String lastName, String email) {
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.linkText("Add Customer")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"general\"]/h3")));

        driver.findElement(By.xpath("//img[@title='Enable']")).click();
        driver.findElement(By.id("cust-title")).sendKeys(customerTitle);
        driver.findElement(By.cssSelector("#cust-firstname")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='cust-lastname']")).sendKeys(lastName);
        driver.findElement(By.name("customer[email]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"save\"]")).click();
    }

    public static boolean verifyCustomerAdded() {
        WebElement successMessage = driver.findElement(By.className("success"));
        if (successMessage.isDisplayed()) {
            System.out.println("Customer added successfully");
            return true;
        } else {
            System.out.println("Add customer test failed");
            return false;
        }
    }

    public static void tryForBrowser() throws InterruptedException {
        Thread.sleep(1000);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void javaScripte() {
        js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
    }

    public static void logOut() {
        driver.findElement(By.xpath("//i[@class=\"fa fa-sign-out\"]")).click();
    }

    public static void takeSCreenShort(String imageName){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File srs=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String folderName="screen shots";
        File file = new File(folderName+File.separator+System.currentTimeMillis()+imageName);
        try {
            FileUtils.copyFile(srs,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static boolean deleteCustomer(String email) {
        WebElement elementDelete = driver.findElement(By.xpath("//*[text()='" + email + "']/following-sibling::td//i[@title='Delete']"));
        elementDelete.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement messageDelete = driver.findElement(By.xpath("//*[contains(text(),'Customer successfully deleted.')]"));
        return messageDelete.isDisplayed();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void waitForElementVisible(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresent(WebElement element){
        Long timeOut=Long.parseLong(RedFromeConfig.readFromConfig("config.properties","timeout"));
        wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fluentWait(WebElement element) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }
    public  static void ccAlert(){

// ... dans votre méthode main ou test ...

        try {
            // 1. Créer une attente courte (ex: 5 secondes) pour voir si le pop-up s'affiche
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // 2. Chercher la croix (le 'x') par son sélecteur.
            // D'après l'image, c'est souvent un bouton avec la classe 'close' ou un texte 'x'
            WebElement closeButton = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[contains(text(), 'X')])[1]")
            ));

            // 3. Cliquer sur la croix
            closeButton.click();
            System.out.println("Pop-up 'Hey Philip' détecté et fermé.");

        } catch (Exception e) {
            // Si le pop-up n'apparaît pas dans les 5 secondes, on arrive ici
            System.out.println("Pas de pop-up affiché, on continue le script...");
        }

// --- LE RESTE DE VOTRE CODE CONTINUE ICI ---
//        driver.findElement(By.id("mon_element_suivant")).click();
    }
}
