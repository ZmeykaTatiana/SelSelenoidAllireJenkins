import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SelenideGoogleTest {

    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    @Description("first test")
    public void openGoogle(){

        $x("//textarea[@class='gLFyf']").setValue("Minsk").pressEnter();
        Selenide.sleep(10000);
        int a=0;
        // $x("//div[@id='result-stats']").shouldBe(Condition.visible);

    }

}

