package exercise;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NewReleaseMovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new NewReleaseMovie("Movie title");
    }

    @Test
    public void shouldCalculateNewReleasePrices() {
        assertThat(movie.getCostForDays(1), is(3.0));
        assertThat(movie.getCostForDays(2), is(6.0));
        assertThat(movie.getCostForDays(3), is(9.0));
    }

    @Test
    public void shouldCalculateNewReleasePoints() {
        assertThat(movie.getPointsForDays(1), is(1));
        assertThat(movie.getPointsForDays(2), is(2));
        assertThat(movie.getPointsForDays(10), is(2));
    }
}