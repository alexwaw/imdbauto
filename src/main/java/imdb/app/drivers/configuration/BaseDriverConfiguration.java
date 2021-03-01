package imdb.app.drivers.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriverConfiguration {

    public enum WEBDRIVER {
        CHROME, FIREFOX
    }

    public WebDriver createLocalDriver(WEBDRIVER webDriver) {
        switch (webDriver)
        {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                WebDriver driverFF = new FirefoxDriver();
                return driverFF;
            default:
                WebDriverManager.chromedriver().setup();
                WebDriver driverChrome = new ChromeDriver();
                return driverChrome;
        }
    }
}
