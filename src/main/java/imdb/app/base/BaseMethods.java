package imdb.app.base;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {

    public void waitForElementToBeVisibleAndClickable(WebElement e, int sec) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, sec);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(e));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(e));
    }

    public static String  removeFirstandLast(String str)
    {
        str = str.substring(1, str.length() - 1);
        return str;
    }

    public boolean isSortedDoubleDescendingOrder(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }

    public boolean isSortedIntAscendingOrder(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}

