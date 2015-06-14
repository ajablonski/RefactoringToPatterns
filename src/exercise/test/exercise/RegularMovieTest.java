package exercise;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RegularMovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new RegularMovie("Movie Title");
    }

    @Test
    public void shouldCalculateRegularMoviePrices() {
        assertThat(movie.getCostForDays(1), is(2.0));
        assertThat(movie.getCostForDays(2), is(2.0));
        assertThat(movie.getCostForDays(3), is(3.5));
        assertThat(movie.getCostForDays(4), is(5.0));
    }

    @Test
    public void shouldCalculateRegularMoviePoints() {
        assertThat(movie.getPointsForDays(1), is(1));
        assertThat(movie.getPointsForDays(10), is(1));
    }

}