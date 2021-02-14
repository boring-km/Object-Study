package restaurant;

public class Customer {

    private final int tableNumber;

    public Customer(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void order(Waiter waiter, String... foodNames) {
        FoodTable foodTable = receiveFoodTableBy(waiter, foodNames);
        printFoodNames(foodTable);
    }

    private void printFoodNames(FoodTable foodTable) {
        foodTable.getFoodList().forEach(food -> System.out.println(food.getName()));
    }

    private FoodTable receiveFoodTableBy(Waiter waiter, String... foodNames) {
        return waiter.take(new FoodOrder(tableNumber, foodNames));
    }

}
