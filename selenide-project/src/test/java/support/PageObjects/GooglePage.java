package support.PageObjects;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class GooglePage {
    public static String inputSearchName = "q";
    public static String searchResultsClass = "g";

    public static SelenideElement getInputSearch() {
        SelenideElement inputElement = element(byName(inputSearchName));
        return inputElement;
    }

    public static List<SelenideElement> getListResultsSearch() {
        List<SelenideElement> list = elements(byClassName(searchResultsClass));
        return list;
    }
}
