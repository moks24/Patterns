import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import options.RegistrationInfo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import utils.DataGenerator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartDeliveryTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldFillInTheForm(){
        RegistrationInfo info = DataGenerator
                .Registration
                .generateInfo("ru");
        String planningDate = DataGenerator.Registration.generateDate(3);
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val(info.getCity());
        $("[type='tel']").sendKeys(Keys.CONTROL + "a");
        $("[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").val(DataGenerator.Registration.generateDate(3));
        $("[data-test-id='name'] input").val(info.getName());
        $("[name='phone']").val(info.getPhoneNumber());
        $("[class='checkbox__box']").click();
        $("[class='button__text']").click();
        SelenideElement blocks = $("[data-test-id='success-notification']");
        blocks.$("[class= 'notification__content']").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " + planningDate));
        $("[type='tel']").sendKeys(Keys.CONTROL + "a");
        $("[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").val(DataGenerator.Registration.generateDate(5));
        $("[class='button__text']").click();
        SelenideElement block = $("[data-test-id='replan-notification']");
        block.$("[class= 'notification__content']").shouldBe(visible);
        $("[class='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $("[class= 'notification__content']").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " +
                        DataGenerator.Registration.generateDate(5)));


    }

}
