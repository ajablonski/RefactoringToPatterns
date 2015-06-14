package exercise;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChildrensMovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new ChildrensMovie("Movie title");
    }

    @Test
    public void shouldCalculateChildrensMoviePrices() {
        assertThat(movie.getCostForDays(1), is(1.5));
        assertThat(movie.getCostForDays(3), is(1.5));
        assertThat(movie.getCostForDays(4), is(3.0));
        assertThat(movie.getCostForDays(5), is(4.5));
    }

    @Test
    public void shouldCalculateChildrensMoviePoints() {
        assertThat(movie.getPointsForDays(1), is(1));
        assertThat(movie.getPointsForDays(10), is(1));
    }

}