package TestBases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class TestBase {
    public AndroidDriver driver;

    String appiumServer = "http://localhost:4723";
    String deviceName = "SDE0219C13003122";
    Path appPath = Paths.get("src", "main", "resources", "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
    String appAbsolutePath = appPath.toFile().getAbsolutePath();

    @BeforeMethod
    public void initAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName)
                .setApp(appAbsolutePath)
                .setAppWaitActivity("*")
                .setNoReset(true);
        driver = new AndroidDriver(new URL(appiumServer),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
