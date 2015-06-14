package exercise;

public class RegularMovie extends Movie {

    public RegularMovie(String name) {
        super(name);
    }

    @Override
    public double getCostForDays(int days) {
        double cost = 2;
        if (days > 2) {
            cost += (days - 2) * 1.5;
        }
        return cost;
    }

    @Override
    public int getPointsForDays(int days) {
        return 1;
    }
}
