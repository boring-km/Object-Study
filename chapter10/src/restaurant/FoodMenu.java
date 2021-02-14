package restaurant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FoodMenu {
    private final Map foodMap = new HashMap();

    public Map getFoodMap() {
        return foodMap;
    }

    public FoodMenu(Food... foods) {
        Arrays.stream(foods).forEach(food -> foodMap.put(food.getName(), food.getPrice()));
    }

    public int getPrice(String[] foods) {
        return Arrays.stream(foods)
                .mapToInt(food -> (Integer) foodMap.getOrDefault(food, 0))
                .sum();
    }

    public void discount(String foodName, int discountPrice) {
        int targetFoodPrice = getTargetFoodPrice(foodName);
        foodMap.replace(foodName, targetFoodPrice - discountPrice);
    }

    private int getTargetFoodPrice(String foodName) {
        Integer targetFoodPrice = (Integer) foodMap.getOrDefault(foodName, 0);
        if (targetFoodPrice == 0)
            throw new IllegalStateException();
        return targetFoodPrice;
    }
}
