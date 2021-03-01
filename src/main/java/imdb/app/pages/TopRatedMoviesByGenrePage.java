package imdb.app.pages;

import imdb.app.base.BasePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static imdb.app.base.BaseTest.turnOffDriverImplicitWait;
import static imdb.app.base.BaseTest.turnOnDriverImplicitWait;

public class TopRatedMoviesByGenrePage extends BasePageFactory {

    public TopRatedMoviesByGenrePage(WebDriver driver){
        super(driver);
    }

    private List<WebElement> getRows() {
        List<WebElement> rows =  driver.findElements(By.xpath("//div[@class='lister-item-content']/p[@class='sort-num_votes-visible']"));
        return rows;
    }

    public boolean areFilmsSortedByNumberOfVotesAscendingOrder() {
        List<WebElement> rows = getRows();
        ArrayList<Integer> yearList = new ArrayList<>();

        for (WebElement row : rows) {
            yearList.add(Integer.parseInt(
                    row.findElement(By.xpath("./span[@name='nv'][1]")).getText().replaceAll(",","")));
        }
        int[] arr = yearList.stream().mapToInt(i -> i).toArray();
        return isSortedIntAscendingOrder(arr);
    }

    public boolean areFilmsSortedByReleaseDateAscendingOrder() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='lister-list']//h3[@class='lister-item-header']"));
        ArrayList<Integer> yearList = new ArrayList<>();
        for (WebElement row : rows) {
            yearList.add(Integer.parseInt(
                    removeFirstandLast(row.findElement(
                            By.xpath("./span[@class='lister-item-year text-muted unbold']")).getText())));
        }
        int[] arr = yearList.stream().mapToInt(i -> i).toArray();
        return isSortedIntAscendingOrder(arr);
    }

    public void clickSortBy(String linkText){
        WebElement e = driver.findElement(By.xpath("//div[@class='sorting']//a[contains(text(),'" + linkText + "')]"));
        turnOffDriverImplicitWait();
        waitForElementToBeVisibleAndClickable(e, 10);
        turnOnDriverImplicitWait();
        e.click();
    }
}
