package exercise;

// Movie represents the notion of a film. A video store might have several tapes in stock of the same movie

public class Movie extends DomainObject {
    private final PriceModel priceModel;

    public Movie(String name, PriceModel priceModel) {
        this.name = name;
        this.priceModel = priceModel;
    }

    public PriceModel getPriceModel() {
        return priceModel;
    }

    public void persist() {
    	Registrar.add ("Movies", this);
    }

    public static Movie get(String name) {
		return (Movie) Registrar.get ("Movies", name);
	}
}
