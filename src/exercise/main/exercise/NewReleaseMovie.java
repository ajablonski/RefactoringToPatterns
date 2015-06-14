package exercise;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String name) {
        super(name, 0, 0, 3);
    }

    @Override
    public int getPointsForDays(int days) {
        return days > 1 ? 2 : 1;
    }
}
