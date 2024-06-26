package TestCases;

import Pages.LoginPage;
import TestBases.TestBase;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase{

    LoginPage login;
    @Test(priority = 2)
    public void loginWithValidCredentials()  {
        login = new LoginPage(driver);
        login.performLogin("standard_user","secret_sauce");
        Assert.assertEquals(login.productTitleText(),"PRODUCTS");
    }

    @Test(priority = 1)
    public void loginWithInvalidCredentials(){
        login = new LoginPage(driver);
        login.performLogin("standard_user","wrong_pass");
        Assert.assertEquals(login.errorMessageText(),"Username and password do not match any user in this service.");
    }

}
