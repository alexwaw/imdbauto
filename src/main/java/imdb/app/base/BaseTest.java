package imdb.app.base;

import imdb.app.drivers.configuration.BaseDriverConfiguration;
import imdb.app.drivers.configuration.ChromeDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static imdb.app.drivers.configuration.BaseDriverConfiguration.WEBDRIVER.*;

@Listeners(TestNGListener.class)
public abstract class BaseTest {

    public static WebDriver driver;
    public static Map<String, String> testData;
    private static String xmlSuiteName;
    public static void navigateToApp() {
        driver.navigate().to(getWeb());
    }

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        xmlSuiteName = context.getCurrentXmlTest().getName();
        launchBrowser();
    }

    private static String getWeb() {
        return new ReadDataFromJSON().getDefaultWebFromJSON();
    }

    private static String getBrowser() {
        return new ReadDataFromJSON().getBrowserFromJSON();
    }

    private static void launchBrowser() {
        String browser = getBrowser();
        switch (browser.toLowerCase()) {
            case "firefox":
                driver =  new BaseDriverConfiguration().createLocalDriver(FIREFOX);
                break;
            default:
                driver = new ChromeDriverConfiguration().createLocalDriver(CHROME);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void turnOffDriverImplicitWait() {
        driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void turnOnDriverImplicitWait() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterSuite
    public static void closeDriver() {
        if(driver != null)
        {
            driver.quit();
        }
    }
}
