package tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Test;
import support.StepsObject.GoogleSteps;

public class GoogleTest {
    @Test
    void testSearch1() {
        open("https://www.google.com/");
        element(byName("q")).setValue("GeForce 1650").pressEnter();
        elements("#search .g").shouldHave(size(10));
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
