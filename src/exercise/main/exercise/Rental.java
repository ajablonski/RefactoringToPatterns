package exercise;


//The rental class represents a customer renting a movie.

import java.text.NumberFormat;
import java.util.Locale;

class Rental extends DomainObject {
    private int daysRented;
    private Tape tape;

    private final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    public Rental(Tape tape, int daysRented) {
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public int daysRented() {
        return daysRented;
    }

    public Tape tape() {
        return tape;
    }

    public double getCost() {
        return tape.movie().getPriceModel().costForDays(daysRented);
    }

    public int getFrequentRenterPoints() {
        return tape.movie().getPriceModel().pointsForDays(daysRented);
    }

    public String getReceiptSummaryLine() {
        return tape().movie().name() + "\t" + CURRENCY_FORMAT.format(getCost());
    }
}

