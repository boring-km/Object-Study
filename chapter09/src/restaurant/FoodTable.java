package restaurant;

import java.util.List;

public class FoodTable {

    private final List<Food> foodList;

    public FoodTable(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
