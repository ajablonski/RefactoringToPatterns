package exercise;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String name) {
        super(name);
    }

    @Override
    public double getCostForDays(int days) {
        return days * 3;
    }

    @Override
    public int getPointsForDays(int days) {
        return days > 1 ? 2 : 1;
    }
}
