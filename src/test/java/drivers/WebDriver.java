package drivers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import static tests.TestBase.configWeb;

public class WebDriver {
    public WebDriver() {
        Configuration.browser = configWeb.getBrowser();
        Configuration.baseUrl = configWeb.getBaseUrl();
        Configuration.browserVersion = configWeb.getBrowserVersion();
        Configuration.remote = configWeb.getRemote();
        Configuration.browserSize = configWeb.getBrowserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", java.util.Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;
    }

}
