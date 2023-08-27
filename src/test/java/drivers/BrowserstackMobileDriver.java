package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static tests.TestBase.configMobile;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", configMobile.getLogin());
        mutableCapabilities.setCapability("browserstack.key", configMobile.getPassword());
        mutableCapabilities.setCapability("app", configMobile.getAppUrl());
        mutableCapabilities.setCapability("device", configMobile.getDevice());
        mutableCapabilities.setCapability("os_version", configMobile.getOsVersion());
        mutableCapabilities.setCapability("project", configMobile.getProjectName());
        mutableCapabilities.setCapability("build", configMobile.getBuildName());
        mutableCapabilities.setCapability("name", configMobile.getTestName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(configMobile.getRemote());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
