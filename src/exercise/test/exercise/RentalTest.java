package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalTest {
    private final String SERIAL_NUMBER = "SERIAL_NUMBER";

    @Test
    public void shouldUsePriceModelOfAssignedMovieType() {
        PriceModel priceModel = PriceModel.REGULAR;
        final int DAYS = 2;
        Rental rental = new Rental(new Tape(SERIAL_NUMBER, new Movie("Movie title", priceModel)), DAYS);

        assertThat(rental.getCost(), is(priceModel.costForDays(DAYS)));
    }

    @Test
    public void shouldUsePointsModelOfAssignedMovieType() {
        PriceModel priceModel = PriceModel.NEW_RELEASE;
        final int DAYS = 2;
        Rental rental = new Rental(new Tape(SERIAL_NUMBER, new Movie("Movie title", priceModel)), DAYS);

        assertThat(rental.getFrequentRenterPoints(), is(priceModel.pointsForDays(DAYS)));
    }
}