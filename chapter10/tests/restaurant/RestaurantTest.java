package restaurant;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {
    @Test
    public void 가격이_5000인_국수와_10000인_돈까스를_레스토랑에서_계산하면_계산표의_가격은_15000이다() {
        Restaurant restaurant = new Restaurant(new FoodMenu(new Food("국수", 5000), new Food("돈까스", 10000)));
        assertEquals(15000, restaurant.getFoodPrice("국수", "돈까스"));
    }
}