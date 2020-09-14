package StepsObject;

import Helper.Selenium;
import java.util.List;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        Selenium.initWebDriver();
        Selenium.driver = new ChromeDriver();
    }

    @When("I open google page")
    public void i_open_google_page() {
        Selenium.driver.manage().window().maximize();
        Selenium.driver.get("https://www.google.com/");
    }

    @Then("I set value in search")
    public void i_set_value_in_search() {
        By inputSearch = By.name("q");
        WebElement element = Selenium.driver.findElement(inputSearch);
        element.sendKeys("GeForce 1650");
        element.sendKeys(Keys.ENTER);
    }

    @Then("I verify that the amount result is not zero")
    public void i_verify_that_the_amount_result_is_not_zero() {
        By searchResult = By.className("g");
        List<WebElement> elements = Selenium.driver.findElements(searchResult);
        int result = elements.size();
        Assert.assertNotEquals(0, result);
    }

    @And("Close browser")
    public void close_browser() {
        Selenium.driver.close();
        Selenium.driver.quit();
    }
}
