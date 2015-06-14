package exercise;

// Movie represents the notion of a film. A video store might have several tapes in stock of the same movie

public abstract class Movie extends DomainObject {
    private double baseCost;
    private int daysIncluded;
    private double ratePerDay;

    protected Movie(String name, double baseCost, int daysIncluded, double ratePerDay) {
        this.baseCost = baseCost;
        this.daysIncluded = daysIncluded;
        this.ratePerDay = ratePerDay;
        this.name = name;
    }

    public void persist() {
    	Registrar.add ("Movies", this);
    }

    public double getCostForDays(int days) {
        double cost = baseCost;
        if (days > daysIncluded) {
            cost += (days - daysIncluded) * ratePerDay;
        }
        return cost;
    }

    public int getPointsForDays(int days) {
        return 1;
    }

    public static Movie get(String name) {
		return (Movie) Registrar.get ("Movies", name);
	}
}
