package imdb.app.drivers.configuration;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfiguration extends BaseDriverConfiguration
{
    protected static ChromeOptions chromeOptions = new ChromeOptions();

    public ChromeDriverConfiguration()
    {
        chromeOptions.addArguments("incognito");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-features=NetworkService");
    }
}

