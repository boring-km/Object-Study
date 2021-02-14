package restaurant;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnackShopTest {
    @Test
    public void 가격이_3000인_튀김을_분식점에서_1000만큼_할인하면_계산표의_가격은_2000이다() {
        SnackShop snackShop = new SnackShop(new FoodMenu(new Food("튀김", 3000)));
        snackShop.discount("튀김", 1000);
        assertEquals(2000, snackShop.getOrderSheet().get("튀김"));
    }


}