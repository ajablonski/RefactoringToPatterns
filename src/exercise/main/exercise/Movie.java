package exercise;

// Movie represents the notion of a film. A video store might have several tapes in stock of the same movie

public abstract class Movie extends DomainObject {

    public Movie(String name) {
        this.name = name;
    }

    public void persist() {
    	Registrar.add ("Movies", this);
    }

    public abstract double getCostForDays(int days);

    public abstract int getPointsForDays(int days);

    public static Movie get(String name) {
		return (Movie) Registrar.get ("Movies", name);
	}
}
