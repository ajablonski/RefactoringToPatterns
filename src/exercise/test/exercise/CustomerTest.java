package exercise;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {
    private Customer bill;

    @Before
    public void setUp() {
        bill = new Customer("Bill");
    }

    @Test
    public void shouldUseRentalPriceToGetTotalOwed() {
        Rental rental = mock(Rental.class);
        when(rental.getCost()).thenReturn(20.0);

        bill.addRental(rental);

        assertThat(bill.statement(), containsString("Amount owed is $20.00"));
    }

    @Test
    public void shouldTotalAllRentalsInOrder() {
        Rental rental1 = mock(Rental.class);
        when(rental1.getCost()).thenReturn(20.0);
        Rental rental2 = mock(Rental.class);
        when(rental2.getCost()).thenReturn(10.0);

        bill.addRental(rental1);
        bill.addRental(rental2);

        assertThat(bill.statement(), containsString("Amount owed is $30.00"));
    }

    @Test
    public void shouldDisplayFrequentRenterPoints() {
        Rental rental = mock(Rental.class);
        when(rental.getFrequentRenterPoints()).thenReturn(1);

        bill.addRental(rental);

        assertThat(bill.statement(), containsString("You earned 1 frequent renter points"));
    }

    @Test
    public void shouldTotalFrequentRenterPointsFromMultipleRentals() {
        Rental rental1 = mock(Rental.class);
        when(rental1.getFrequentRenterPoints()).thenReturn(1);
        Rental rental2 = mock(Rental.class);
        when(rental2.getFrequentRenterPoints()).thenReturn(2);

        bill.addRental(rental1);
        bill.addRental(rental2);

        assertThat(bill.statement(), containsString("You earned 3 frequent renter points"));
    }

    @Test
    public void shouldPrintMovieDescriptionAndPrice() {
        Movie movie = mock(Movie.class);

        Double cost = 20.0;
        int days = 1;
        when(movie.getCostForDays(days)).thenReturn(cost);
        String title = "Movie title";
        when(movie.getName()).thenReturn(title);
        Rental rental = new Rental(new Tape("", movie), days);

        bill.addRental(rental);

        assertThat(bill.statement(), containsString(title + "\t$20.00"));
    }
}