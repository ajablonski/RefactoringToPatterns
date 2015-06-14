package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalTest {
    private final String SERIAL_NUMBER = "SERIAL_NUMBER";

    @Test
    public void shouldUsePriceModelOfAssignedMovieType() {
        Movie movie = mock(Movie.class);
        final int days = 2;
        final double cost = 20.0;
        when(movie.getCostForDays(days)).thenReturn(cost);
        Rental rental = new Rental(new Tape(SERIAL_NUMBER, movie), days);

        assertThat(rental.getCost(), is(cost));
    }

    @Test
    public void shouldUsePointsModelOfAssignedMovieType() {

        Movie movie = mock(Movie.class);

        final int days = 2;
        int points = 3;
        when(movie.getPointsForDays(days)).thenReturn(points);
        Rental rental = new Rental(new Tape(SERIAL_NUMBER, movie), days);

        assertThat(rental.getFrequentRenterPoints(), is(points));
    }
}