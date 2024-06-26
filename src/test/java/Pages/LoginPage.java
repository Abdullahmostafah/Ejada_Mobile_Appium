package Pages;

import TestBases.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    WebElement userNameField;

    @FindBy (xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    WebElement passWordField;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    WebElement loginButton;

    @FindBy (xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    WebElement productTitle;

    @FindBy (xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    WebElement validationMessage;


    public void performLogin(String username , String password) {
        userNameField.sendKeys(username);
        passWordField.sendKeys(password);
        loginButton.click();

    }

    public String productTitleText(){
        return productTitle.getText();
    }

    public String errorMessageText() {
        return validationMessage.getText();
    }

}
