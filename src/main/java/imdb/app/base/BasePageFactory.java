package imdb.app.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageFactory extends BaseMethods {

    protected WebDriver driver;

    public BasePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
