package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.ConfigApi;
import configs.ConfigMobile;
import configs.ConfigWeb;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.WebDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.GalleryPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static ConfigWeb configWeb = ConfigFactory.create(ConfigWeb.class, System.getProperties());
    public static ConfigMobile configMobile = ConfigFactory.create(ConfigMobile.class, System.getProperties());

    public MainPage mainPage = new MainPage();
    public GalleryPage galleryPage = new GalleryPage();


    @BeforeAll
    static void beforeAll(){
        switch (System.getProperty("taskName")){
            case "mobile":
                Configuration.browser = System.getProperty("env").equals("local") ? LocalMobileDriver.class.getName() : BrowserstackMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "web":
                new WebDriver();
                break;
            case "api":
                break;

        }
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;

    }

    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (!System.getProperty("taskName").equals("api")) open();
    }

    @AfterEach
    void afterEach(){
        switch (System.getProperty("taskName")){
            case "mobile":
                if(System.getProperty("env").equals("local")){
                    Attach.pageSource();
                    closeWebDriver();
                } else {
                    String sessiondId = Selenide.sessionId().toString();
                    Attach.pageSource();
                    closeWebDriver();
                    Attach.addVideo(sessiondId);
                }
                break;
            case "web":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                if (System.getProperty("env").equals("remote")) Attach.addVideo();
                clearBrowserCookies();
                sessionStorage().clear();;
                localStorage().clear();
                break;
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong taskName");
        }
    }
}
