package exercise;

public class ChildrensMovie extends Movie {

    public ChildrensMovie(String name) {
        super(name);
    }

    @Override
    public double getCostForDays(int days) {
        double cost = 1.5;
        if (days > 3) {
            cost += (days - 3) * 1.5;
        }
        return cost;
    }

    @Override
    public int getPointsForDays(int days) {
        return 1;
    }
}
