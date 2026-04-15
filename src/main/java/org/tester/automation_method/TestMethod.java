package org.tester.automation_method;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

/**
 * @created : 20/03/2026,13:50,ven.
 **/
public class TestMethod {
//    Stup chrome driver
  WebDriver driver;
  WebDriverWait wait;
    JavascriptExecutor js;

    public void setBrowser(String url){

         driver = new ChromeDriver();
         wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void login(String userName,String passWord){
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("cubecart");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("cubecart");
        driver.findElement(By.id("login")).click();

    }
    public void addCustomerTest(String customerTitle,String firsName,String lastName,String email){
        WebElement customerListButton = driver.findElement(By.linkText("Customer List"));
        customerListButton.click();
        WebElement addCustomerButton = driver.findElement(By.linkText("Add Customer"));
        addCustomerButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"general\"]/h3")));
        WebElement statusCheckBox = driver.findElement(By.xpath("//img[@title='Enable']"));
        statusCheckBox.click();
        WebElement title = driver.findElement(By.id("cust-title"));
        title.sendKeys(customerTitle);
        WebElement firstNameField = driver.findElement(By.cssSelector("#cust-firstname"));
        firstNameField.sendKeys(firsName);
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='cust-lastname']"));
        lastNameField.sendKeys(lastName);
//         int i=1+(int)(Math.random())*100000;
//        String emailField=String.format("Charlotte%s@onepiece.com",System.currentTimeMillis());
        driver.findElement(By.name("customer[email]")).sendKeys(email);
        WebElement saveButton = driver.findElement(By.xpath("//input[@name=\"save\"]"));
        saveButton.click();

    }
    public boolean verifyCustomerAdded(){
        WebElement successMessage = driver.findElement(By.className("success"));
        if (successMessage.isDisplayed()){
            System.out.println("Customer added successfully");
            System.out.println("Add customer test passed");
            return true;
        }else {
            System.out.println("Add customer test failed");
            return false;
        }
    }

    public void tryForBrowser() throws InterruptedException {
//        wait.withTimeout(Duration.ofSeconds(2)).until(d -> true);
        Thread.sleep(1000);
        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    public void javaScripte(){
//        WebDriver driver = new ChromeDriver();
        js= (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
    }
    public void logOut(){
        WebElement logOutButton = driver.findElement(By.xpath("//i[@class=\"fa fa-sign-out\"]"));
        logOutButton.click();
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
    public boolean deleteCustomer(String email) throws InterruptedException {
        WebElement elementDelete = driver.findElement(By.xpath("//*[text()='"+email+"']/following-sibling::td//i[@title='Delete']"));
        elementDelete.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement messageDelete = driver.findElement(By.xpath("//*[contains(text(),'Some or all selected " +
                "Customer successfully deleted.')]"));
        if (messageDelete.isDisplayed()){
            System.out.println("Customer deleted");
            return true;
        }else{
            System.out.println("Failed to delete customer");
            return false;
        }

    }
    public  void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void waitForElementVisible(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void  fluentWait(WebElement element){
//        wait= (WebDriverWait) new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5));
        Wait<WebDriver> wait= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

}
