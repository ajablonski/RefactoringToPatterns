package exercise;

// The customer class represents the customer. So far all the classes have been dumb encapsulated data. Customer holds all the behavior for producing a statement in its statement() method.

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Customer extends DomainObject {
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String statement = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            totalAmount += rental.getCost();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            statement += "\t" + rental.getReceiptSummaryLine() + "\n";
        }
        //add footer lines
        statement += "Amount owed is " + currencyFormat.format(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return statement;

    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public static Customer get(String name) {
        return (Customer) Registrar.get("Customers", name);
    }

    public void persist() {
        Registrar.add("Customers", this);
    }
}