package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceModelTest {

    @Test
    public void shouldCalculateRegularMoviePrices() {
        assertThat(PriceModel.REGULAR.costForDays(1), is(2.0));
        assertThat(PriceModel.REGULAR.costForDays(2), is(2.0));
        assertThat(PriceModel.REGULAR.costForDays(3), is(3.5));
        assertThat(PriceModel.REGULAR.costForDays(4), is(5.0));
    }

    @Test
    public void shouldCalculateChildrensMoviePrices() {
        assertThat(PriceModel.CHILDRENS.costForDays(1), is(1.5));
        assertThat(PriceModel.CHILDRENS.costForDays(3), is(1.5));
        assertThat(PriceModel.CHILDRENS.costForDays(4), is(3.0));
        assertThat(PriceModel.CHILDRENS.costForDays(5), is(4.5));
    }

    @Test
    public void shouldCalculateNewReleasePrices() {
        assertThat(PriceModel.NEW_RELEASE.costForDays(1), is(3.0));
        assertThat(PriceModel.NEW_RELEASE.costForDays(2), is(6.0));
        assertThat(PriceModel.NEW_RELEASE.costForDays(3), is(9.0));
    }

    @Test
    public void shouldCalculateRegularMoviePoints() {
        assertThat(PriceModel.REGULAR.pointsForDays(1), is(1));
        assertThat(PriceModel.REGULAR.pointsForDays(10), is(1));
    }

    @Test
    public void shouldCalculateChildrensMoviePoints() {
        assertThat(PriceModel.CHILDRENS.pointsForDays(1), is(1));
        assertThat(PriceModel.CHILDRENS.pointsForDays(10), is(1));
    }

    @Test
    public void shouldCalculateNewReleasePoints() {
        assertThat(PriceModel.NEW_RELEASE.pointsForDays(1), is(1));
        assertThat(PriceModel.NEW_RELEASE.pointsForDays(2), is(2));
        assertThat(PriceModel.NEW_RELEASE.pointsForDays(10), is(2));
    }
}