package restaurant;

public class SnackShop extends Restaurant{

    public SnackShop(FoodMenu foodMenu) {
        super(foodMenu);
    }

    public void discount(String foodName, int discountPrice) {
        getFoodMenu().discount(foodName, discountPrice);
    }
}
