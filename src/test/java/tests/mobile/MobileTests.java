package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$x;


@Tag("mobile")
public class MobileTests extends TestBase {


    @Test
    void onboardingScreenTest(){
//        $x(".//android.widget.Button[@text='Allow']").click();
        $x("com.planner5d.planner5d:id/buttonText").click();
        $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup").click();
        $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView").click();

    }
}
