package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import pages.components.HeaderMenuComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {
    HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent();

    SelenideElement stickyHeaderCtaEditor = $("b-page__header-cta");

    @Step("Open Main page")
    public MainPage openMainPage(){
        open(baseUrl);

        return this;
    }

    @Step("Open Gallery page via Header menu")
    public GalleryPage openGalleryPage(){
        headerMenuComponent.openGalleryPage();
        return new GalleryPage();
    }

    @Step("Change language to {language} via dropdown menu in Header")
    public MainPage changeLanguage(String language){
        headerMenuComponent.changeLanguage(language);

        return this;
    }

    @Step("Verify language switched to {language}")
    public void verifyLanguage(String language){
        headerMenuComponent.verifyLanguage(language);

        switch (language){
            case "English":
                stickyHeaderCtaEditor.shouldHave().shouldHave(
                        text("Get ideas"),
                        text("Upload a plan"),
                        text("Design school"),
                        text("Design battle"),
                        text("Use Cases"),
                        text("Sign Up"));
                break;
            case "Русский":
                stickyHeaderCtaEditor.shouldHave().shouldHave(
                        text("Идеи для дома"),
                        text("Загрузить план"),
                        text("Школа дизайна"),
                        text("Конкурс дизайнеров"),
                        text("Регистрация"));
                break;
            case "Polski":
                break;
            default:
                throw new RuntimeException("Wrong language");
        }

    }

}
