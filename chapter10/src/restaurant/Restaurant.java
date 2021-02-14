package restaurant;

import java.util.Map;

public class Restaurant {
    private final FoodMenu foodMenu;
    private final Map orderSheet;

    public Restaurant(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
        this.orderSheet = foodMenu.getFoodMap();
    }

    public int getFoodPrice(String... foods) {
        return foodMenu.getPrice(foods);
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public Map getOrderSheet() {
        return orderSheet;
    }
}