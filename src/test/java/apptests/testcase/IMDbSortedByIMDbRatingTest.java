package apptests.testcase;

import imdb.app.base.BaseTest;
import imdb.app.pages.TopRatedMoviesPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class IMDbSortedByIMDbRatingTest extends BaseTest {

    @Test
    void test() {
        //Initialize pages
        TopRatedMoviesPage topRatedMoviesPage = new TopRatedMoviesPage(driver);

        //Testcase steps
        navigateToApp();
        topRatedMoviesPage.sortByIMDbRating();
        int films = topRatedMoviesPage.getNumberOfFilms();
        assertTrue(films > 1);
        assertTrue(topRatedMoviesPage.areFilmsSortedByIMDbRatingDescendingOrder());
    }
}

