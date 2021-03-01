package apptests.testcase;

import imdb.app.base.BaseTest;
import imdb.app.pages.TopRatedMoviesByGenrePage;
import imdb.app.pages.TopRatedMoviesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class IMDbGenreSortingTest extends BaseTest {

    @Test
    void test() {
        //Set up data
        String genre = System.getProperty("genre");
        if (genre==null) {
            genre = testData.get("Genre");
        }

        //Initialize pages
        TopRatedMoviesPage topRatedMoviesPage = new TopRatedMoviesPage(driver);
        TopRatedMoviesByGenrePage topRatedMoviesByGenrePage = new TopRatedMoviesByGenrePage(driver);

        //Testcase steps
        navigateToApp();

        topRatedMoviesPage.clickMoviesBbyGenre(genre);

        topRatedMoviesByGenrePage.clickSortBy("Number of Votes");
        assertTrue(topRatedMoviesByGenrePage.areFilmsSortedByNumberOfVotesAscendingOrder());

        topRatedMoviesByGenrePage.clickSortBy("Release Date");
        assertTrue(topRatedMoviesByGenrePage.areFilmsSortedByReleaseDateAscendingOrder());
    }
}

