package Helper;


import org.openqa.selenium.WebDriver;

public class Selenium {

    public static WebDriver driver;

    public static String getDriverPath() {
        String path = System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe";
        return path;
    }

    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", getDriverPath());
    }
}
