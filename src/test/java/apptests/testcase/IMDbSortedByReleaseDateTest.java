package apptests.testcase;

import imdb.app.base.BaseTest;
import imdb.app.pages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class IMDbSortedByReleaseDateTest extends BaseTest {

    @Test
    void test() {
        //Initialize pages
        TopRatedMoviesPage topRatedMoviesPage = new TopRatedMoviesPage(driver);

        //Testcase steps
        navigateToApp();
        topRatedMoviesPage.sortByReleaseDate();
        int films = topRatedMoviesPage.getNumberOfFilms();
        assertTrue(films > 1);
        assertTrue(topRatedMoviesPage.areFilmsSortedByReleaseDateDescendingOrder());
    }
}

