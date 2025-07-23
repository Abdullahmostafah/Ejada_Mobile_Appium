package TestCases;

import Pages.LoginPage;
import TestBases.TestBase;
import Utils.ConfigReaderWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase {
    LoginPage login;
    @Test(priority = 1)
    public void loginWithInvalidCredentials() {
        login = new LoginPage(driver);
        login.performLogin(
                ConfigReaderWriter.getPropKey("username.valid"),
                ConfigReaderWriter.getPropKey("password.invalid")
        );
        Assert.assertEquals(
                login.errorMessageText(),  // Changed from productTitleText to errorMessageText
                ConfigReaderWriter.getPropKey("login.failure.expectedText")
        );
    }

    @Test(priority = 2)
    public void loginWithValidCredentials() {
        login = new LoginPage(driver);
        login.performLogin(
                ConfigReaderWriter.getPropKey("username.valid"),
                ConfigReaderWriter.getPropKey("password.valid")
        );
        Assert.assertEquals(
                login.productTitleText(),  // Changed from errorMessageText to productTitleText
                ConfigReaderWriter.getPropKey("login.success.expectedText")
        );
    }
}