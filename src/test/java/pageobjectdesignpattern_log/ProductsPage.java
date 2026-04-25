package pageobjectdesignpattern_log;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @created : 25/04/2026,17:58,sam.
 **/
public class ProductsPage {
    ChromeDriver driver;
    FunctionLibrary functionLibrary;
    @FindBy(linkText = "Add Product")
    WebElement addProductLink;
    @FindBy(id = "name")
    WebElement productNameField;
    @FindBy(id = "product_code")
    WebElement productCodeField;
    @FindBy(id = "stock_level")
    WebElement stockLevelField;
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath ="//*[contains(text(),\"Product successfully created.\")]" )
    WebElement productAddSuccessMessage;
    @FindBy(css ="i.fa-trash" )
    WebElement deleteIcon;
    @FindBy(xpath ="//*[contains(text(),\"Product(s) successfully deleted.\")]" )
    WebElement getProductDeleteSuccessMessage;



    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }
    public void addProduct() {
        functionLibrary.waitForElementPresent(addProductLink);
        addProductLink.click();
        productNameField.sendKeys(functionLibrary.generateFakeProductName());
        productCodeField.sendKeys(functionLibrary.generateFakeProductCode());
        stockLevelField.sendKeys(functionLibrary.generateFakeStockLevel());
        saveButton.click();

    }
    public boolean isProductAddedSuccessfully() {
        functionLibrary.waitForElementPresent(productAddSuccessMessage);
//        return functionLibrary.isElementDisplayed(productAddSuccessMessage);
        if (productAddSuccessMessage.isDisplayed()) {
            System.out.println("Product is added successfully");
            return true;
        } else {
            System.out.println("Product is not added successfully");
            return false;
        }

    }

        public void deleteProduct() {
            functionLibrary.waitForElementPresent(deleteIcon);
            deleteIcon.click();
            functionLibrary.waitForAlertPresent();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

        public boolean verifyProductDelete() {
        functionLibrary.waitForElementPresent(getProductDeleteSuccessMessage);
         if (getProductDeleteSuccessMessage.isDisplayed() ){
            System.out.println("Product is deleted successfully");
            return true;
        } else {
            System.out.println("Product is not deleted successfully");
            return false;
        }
        }



}

