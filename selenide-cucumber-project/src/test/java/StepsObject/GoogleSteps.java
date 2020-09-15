package StepsObject;

import PageObjects.GooglePage;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


public class GoogleSteps {
    @Given("Launch Chrome browser")
    public void launch_chrome_browser() {
        Configuration.startMaximized = true;
    }

    @When("Open Google page")
    public void open_google_page() {
        open("https://www.google.com/");
    }

    @Then("Input value in search field")
    public void input_value_in_search_field() {
        element(byName(GooglePage.inputSearchName)).setValue("GeForce 1650").pressEnter();
    }

    @Then("Check search result")
    public void check_search_result() {
        elements(GooglePage.searchResultsClass)
                .shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Игровая видеокарта GeForce GTX 1650 | NVIDIA"))
                .find(".r>a").click();
        Wait().until(titleIs("Игровая видеокарта GeForce GTX 1650 | NVIDIA"));
    }

    @And("Close browser")
    public void close_browser() {
        closeWindow();
        closeWebDriver();
    }
}
