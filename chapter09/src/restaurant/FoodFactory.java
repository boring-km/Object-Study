package restaurant;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {
    public FoodTable createFoodTable(FoodOrder foodOrder) {
        List<Food> foodList = new ArrayList<>();    // 문제가 있어 보이지만 아직 해결 방법을 못 찾음!
        addToFoodList(foodOrder.getFoodNames(), foodList);
        return new FoodTable(foodList);
    }

    private void addToFoodList(List<String> foodNames, List<Food> foodList) {
        foodNames.forEach(foodName -> foodList.add(new Food(foodName)));    // 리스트로 만들어서 깔끔하게 반환하고 싶은데 아직 방법을 못 찾음
    }
}
