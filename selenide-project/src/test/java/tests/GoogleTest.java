package tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;

import org.junit.jupiter.api.Test;

public class GoogleTest {
    @Test
    void testSearch(){
        open("https://www.google.com/");
        element(byName("q")).setValue("GeForce 1650").pressEnter();
        elements("#search .g").shouldHave(size(10));
    }
}
