package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalTest {
    private final String SERIAL_NUMBER = "SERIAL_NUMBER";
    private final Tape NEW_RELEASE_TAPE = new Tape(SERIAL_NUMBER, new Movie("New release", Movie.NEW_RELEASE));
    private final Tape CHILDRENS_TAPE = new Tape(SERIAL_NUMBER, new Movie("Childrens movie", Movie.CHILDRENS));
    private final Tape REGULAR_TAPE = new Tape(SERIAL_NUMBER, new Movie("Regular movie", Movie.REGULAR));

    @Test
    public void shouldCharge3DollarsForANewRelease() {
        Rental rental = new Rental(NEW_RELEASE_TAPE, 1);

        assertThat(rental.getCost(), is(3.00));
    }

    @Test
    public void shouldCharge3DollarsPerDayForMultipleDays() {
        Rental rental = new Rental(NEW_RELEASE_TAPE, 5);

        assertThat(rental.getCost(), is(15.00));
    }

    @Test
    public void shouldEarn1FrequentRenterPointForNewRelease() {
        Rental rental = new Rental(NEW_RELEASE_TAPE, 1);

        assertThat(rental.getFrequentRenterPoints(), is(1));
    }

    @Test
    public void shouldEarnExtraFrequentRenterPointIfNewReleaseForMoreThan1Day() {
        Rental rental = new Rental(NEW_RELEASE_TAPE, 10);

        assertThat(rental.getFrequentRenterPoints(), is(2));
    }

    @Test
    public void shouldCharge1Dollar50CentsForChildrensMovie() {
        Rental rental = new Rental(CHILDRENS_TAPE, 1);

        assertThat(rental.getCost(), is(1.50));
    }

    @Test
    public void shouldCharge1Dollar50CentsForChildrensMovieUntil3Days() {
        Rental rental = new Rental(CHILDRENS_TAPE, 3);

        assertThat(rental.getCost(), is(1.50));
    }

    @Test
    public void shouldCharge1Dollar50CentsExtraPerDayAfter3DaysForChildrensMovie() {
        Rental rental = new Rental(CHILDRENS_TAPE, 4);

        assertThat(rental.getCost(), is(3.00));
    }


    @Test
    public void shouldEarn1FrequentRenterPointForChildrensMovie() {
        Rental rental = new Rental(CHILDRENS_TAPE, 10);

        assertThat(rental.getFrequentRenterPoints(), is(1));
    }

    // Regular Movie tests

    @Test
    public void shouldCharge2DollarsForRegularMovie() {
        Rental rental = new Rental(REGULAR_TAPE, 1);

        assertThat(rental.getCost(), is(2.00));
    }

    @Test
    public void shouldCharge2DollarsForRegularMovieUntil2Days() {
        Rental rental = new Rental(REGULAR_TAPE, 2);

        assertThat(rental.getCost(), is(2.00));
    }

    @Test
    public void shouldCharge1Dollar50CentsExtraPerDayAfter2DaysForRegularMovie() {
        Rental rental = new Rental(REGULAR_TAPE, 3);

        assertThat(rental.getCost(), is(3.50));
    }

    @Test
    public void shouldEarn1FrequentRenterPointForRegularMovie() {
        Rental rental = new Rental(REGULAR_TAPE, 10);

        assertThat(rental.getFrequentRenterPoints(), is(1));
    }
}