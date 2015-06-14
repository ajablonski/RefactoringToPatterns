package exercise;

import java.util.function.Function;

public enum PriceModel {
    CHILDRENS(days -> {
        double cost = 1.5;
        if (days > 3) {
            cost += (days - 3) * 1.5;
        }
        return cost;
    }, days -> 1),
    NEW_RELEASE(days -> 3.0 * days, days -> days >= 2 ? 2 : 1),
    REGULAR(days -> {
        double cost = 2;
        if (days > 2) {
            cost += (days - 2) * 1.5;
        }
        return cost;
    }, days -> 1);

    private final Function<Integer, Double> priceFunction;
    private final Function<Integer, Integer> pointsFunction;

    PriceModel(Function<Integer, Double> priceFunction, Function<Integer, Integer> pointsFunction) {
        this.priceFunction = priceFunction;
        this.pointsFunction = pointsFunction;
    }

    public double costForDays(int days) {
        return priceFunction.apply(days);
    }

    public int pointsForDays(int days) {
        return pointsFunction.apply(days);
    }
}
