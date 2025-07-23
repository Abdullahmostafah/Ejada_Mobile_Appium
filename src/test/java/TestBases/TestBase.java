package TestBases;

import Utils.ConfigReaderWriter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class TestBase {
    protected AndroidDriver driver;

    // Configuration values loaded once
    private static final String SERVER_URL = ConfigReaderWriter.getPropKey("appium.server.url");
    private static final String DEVICE_NAME = ConfigReaderWriter.getPropKey("device.name");
    private static final String APP_RELATIVE_PATH = ConfigReaderWriter.getPropKey("app.relative.path");
    private static final String APP_ABSOLUTE_PATH = Paths.get(APP_RELATIVE_PATH).toAbsolutePath().toString();

    static {
        // Verify APK exists during class loading
        if (!Paths.get(APP_RELATIVE_PATH).toFile().exists()) {
            throw new RuntimeException("APK file not found at: " + APP_ABSOLUTE_PATH);
        }
    }

    @BeforeMethod
    public void initAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(DEVICE_NAME)
                .setApp(APP_ABSOLUTE_PATH)
                .setAppWaitActivity("*")
                .setNoReset(true);

        driver = new AndroidDriver(new URL(SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}