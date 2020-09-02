package support.StepsObject;

import com.codeborne.selenide.SelenideElement;
import support.PageObjects.GooglePage;

import java.util.List;

public class GoogleSteps {
    public void searchValue(String value) {
        SelenideElement inputElement = GooglePage.getInputSearch();
        inputElement.setValue(value).pressEnter();
    }

    public int getCountResultSearch() {
        List<SelenideElement> list = GooglePage.getListResultsSearch();
        return list.size();
    }
}
