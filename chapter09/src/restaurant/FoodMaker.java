package restaurant;

public class FoodMaker {

    private final FoodFactory foodFactory;

    public FoodMaker(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    public FoodTable cook(FoodOrder foodOrder) {
        return foodFactory.createFoodTable(foodOrder);
    }
}
