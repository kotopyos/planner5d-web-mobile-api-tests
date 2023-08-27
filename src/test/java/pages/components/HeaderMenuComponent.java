package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import pages.GalleryPage;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderMenuComponent {

    private final SelenideElement
        getIdeasElement = $("a.b-header__menu-item[href='https://planner5d.com/ru/gallery']"),
        changeLanguageDropdownElement = $("b-header__menu-link");


    @Step("Click 'Get ideas' button on HeaderMenu")
    public HeaderMenuComponent openGalleryPage(){
        getIdeasElement.click();
        return this;
    }

    @Step("Change language to {language} via dropdown menu in Header")
    public HeaderMenuComponent changeLanguage(String language){
        changeLanguageDropdownElement.hover();
        $x("//header//span[contains(text(), '" +
                language +
                "')]").click();
        return this;
    }

    public void verifyLanguage(String language){

        switch (language){
            case "English":
                assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("https://planner5d.com"));
                break;
            case "Русский":
                assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("https://planner5d.com/ru"));
                getIdeasElement.shouldHave(
                        text("Идеи для дома"),
                        text("Загрузить план"),
                        text("Школа дизайна"),
                        text("Конкурс дизайнеров"),
                        text("Регистрация"));
                break;
            case "Polski":
                assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("https://planner5d.com/pl"));
                break;
            default:
                throw new RuntimeException("Wrong language");
        }




    }





}
