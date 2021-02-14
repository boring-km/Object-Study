package restaurant;

import java.util.List;
import java.util.Objects;

public class FoodOrder {

    private final int tableNumber;
    private List<String> foodNames;

    public FoodOrder(int tableNumber, String... foodNames) {
        this.tableNumber = tableNumber;
        this.foodNames = List.of(foodNames);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<String> getFoodNames() {
        return foodNames;
    }

    public void changeFoodNames(String... foodNames) {
        this.foodNames = List.of(foodNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodOrder)) return false;

        FoodOrder foodOrder = (FoodOrder) o;

        if (tableNumber != foodOrder.tableNumber) return false;
        return Objects.equals(foodNames, foodOrder.foodNames);
    }
}
