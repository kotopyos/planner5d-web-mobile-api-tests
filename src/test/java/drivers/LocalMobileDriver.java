package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static tests.TestBase.configMobile;

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(configMobile.getDevice())
                .setPlatformVersion(configMobile.getOsVersion())
                .setApp(getAppPath())
                .setAppPackage("com.planner5d.planner5d")
                .setAppActivity("com.planner5d.library.activity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appUrl = "https://apk.apkmonk.com/apks-26/com.planner5d.planner5d_2023-07-26.apk?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=IFVYHACUO60QSGWW9L9Z%2F20230825%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230825T115200Z&X-Amz-Expires=2400&X-Amz-SignedHeaders=host&X-Amz-Signature=8be5c6b9d860d9644a2cbf6052117f6e5d8373c14d29250039f91bb5a9196836";
        String appPath = "src/test/resources/apps/com.planner5d.planner5d_2023-07-26.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}
