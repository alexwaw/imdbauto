package imdb.app.pages;

import imdb.app.base.BasePageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class TopRatedMoviesPage extends BasePageFactory {

    @FindBy(xpath = "//table[@data-caller-name='chart-top250movie']")
    WebElement TABLE_TOP250_MOVIE;

    public TopRatedMoviesPage(WebDriver driver){
        super(driver);
    }

    public Integer getNumberOfFilms() {
        return getRows(TABLE_TOP250_MOVIE).size();
    }

    public List<WebElement> getRows(WebElement table) {
        List<WebElement> rows =  table.findElements(By.xpath("./tbody/tr"));
        return rows;
    }

    public boolean areFilmsSortedByReleaseDateDescendingOrder() {
        List<WebElement> rows = getRows(TABLE_TOP250_MOVIE);
        ArrayList<Double> yearList = new ArrayList<>();
        for (WebElement row : rows) {
            yearList.add(Double.parseDouble(removeFirstandLast(row.findElement(By.xpath("./td[2]/span")).getText())));
        }
        double[] arr = yearList.stream().mapToDouble(i -> i).toArray();
        return isSortedDoubleDescendingOrder(arr);
    }

    public boolean areFilmsSortedByIMDbRatingDescendingOrder() {
        List<WebElement> rows = getRows(TABLE_TOP250_MOVIE);
        ArrayList<Double> yearList = new ArrayList<>();

        for (WebElement row : rows) {
            yearList.add(Double.parseDouble(row.findElement(By.xpath("./td[3]/strong")).getText()));
        }

        double[] arr = yearList.stream().mapToDouble(i -> i).toArray();
        return isSortedDoubleDescendingOrder(arr);
    }

    public void sortByReleaseDate() {
        Select sortBy  = new Select(driver.findElement(By.id("lister-sort-by-options")));
        sortBy.selectByValue("us:descending");
    }

    public void sortByIMDbRating() {
        Select sortBy  = new Select(driver.findElement(By.id("lister-sort-by-options")));
        sortBy.selectByValue("ir:descending");
    }

    public void clickMoviesBbyGenre(String linkText) {
       //unfortunately native selenium click() and sendKeys(Keys.ENTER) were not stable
        WebElement element = driver.findElement(By.xpath("//span[@class='ab_widget']//a[contains(text(),'" + linkText + "')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
