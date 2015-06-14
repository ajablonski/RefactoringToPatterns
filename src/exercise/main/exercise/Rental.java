package exercise;


//The rental class represents a customer renting a movie.

import java.text.NumberFormat;
import java.util.Locale;

class Rental extends DomainObject {
    private int daysRented;
    private Tape tape;

    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

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
        return tape.getMovie().getCostForDays(daysRented);
    }

    public int getFrequentRenterPoints() {
        return tape.getMovie().getPointsForDays(daysRented);
    }

    public String getReceiptSummaryLine() {
        return tape().getMovie().getName() + "\t" + CURRENCY_FORMAT.format(getCost());
    }
}

