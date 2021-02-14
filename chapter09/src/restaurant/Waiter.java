package restaurant;

public class Waiter {

    private final FoodMaker foodMaker;

    public Waiter(FoodMaker foodMaker) {
        this.foodMaker = foodMaker;
    }

    public FoodTable take(FoodOrder foodOrder) {
        return foodMaker.cook(foodOrder);
    }
}
