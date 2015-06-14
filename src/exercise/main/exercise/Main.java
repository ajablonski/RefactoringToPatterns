package exercise;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Bill");
        customer.addRental(new Rental(new Tape("1234", new Movie("Seven", PriceModel.REGULAR)), 2));
        customer.addRental(new Rental(new Tape("2345", new Movie("Usual Suspects", PriceModel.NEW_RELEASE)), 3));
        customer.addRental(new Rental(new Tape("3456", new Movie("American Beauty", PriceModel.CHILDRENS)), 2));

        System.out.println(customer.statement());
    }
}
