package pagedesigne;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @created : 20/04/2026,20:01,lun.
 **/
public class LoginPage {
    ChromeDriver driver;
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
     WebElement passwordField;
    @FindBy(id = "login")
     WebElement loginButton;
    



    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
