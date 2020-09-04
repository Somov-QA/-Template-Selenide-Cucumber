package tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Test;

import support.StepsObject.GoogleSteps;

public class GoogleTest {
    @Test
    void testSearch1() {
        Configuration.startMaximized = true;
        open("https://www.google.com/");
        element(byName("q")).setValue("GeForce 1650").pressEnter();
        //ElementsCollection list = elements("#search .g").shouldHave(size(9));
        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Игровая видеокарта GeForce GTX 1650 | NVIDIA"))
                .find(".r>a").click();
        Wait().until(titleIs("Игровая видеокарта GeForce GTX 1650 | NVIDIA"));
    }

    @Test
    void testSearch2() {
        open("https://www.google.com/");
        GoogleSteps tester = new GoogleSteps();
        tester.searchValue("Radeon RX 5500");
        int amount =  tester.getCountResultSearch();
        Asserts.check((amount > 0), "Error: amount is 0");
    }
}
