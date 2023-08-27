package tests.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;



import static tests.TestData.Language.*;

@DisplayName("Web UI tests")
@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Main page is accessible after changing language to Russian")
    public void changingLanguageToRussian(){
        mainPage.changeLanguage(RUSSIAN.getValue())
                .verifyLanguage(RUSSIAN.getValue());
    }

    @Test
    @DisplayName("Main page is accessible after changing language to English")
    public void chagingLanguageFromDefaultToRussianAndBack(){
        mainPage.changeLanguage(RUSSIAN.getValue())
                .changeLanguage(ENGLISH.getValue())
                .verifyLanguage(ENGLISH.getValue());
    }
}
