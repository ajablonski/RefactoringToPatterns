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
        double cost = 0;
        switch (this.tape().movie().priceCode()) {
            case Movie.REGULAR:
                cost += 2;
                if (this.daysRented() > 2)
                    cost += (this.daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                cost += this.daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                cost += 1.5;
                if (this.daysRented() > 3)
                    cost += (this.daysRented() - 3) * 1.5;
                break;

        }
        return cost;
    }

    public int getFrequentRenterPoints() {
        if ((this.tape().movie().priceCode() == Movie.NEW_RELEASE) && this.daysRented() > 1)
            return 2;
        else
            return 1;
    }

    public String getReceiptSummaryLine() {
        return tape().movie().name() + "\t" + CURRENCY_FORMAT.format(getCost());
    }
}

