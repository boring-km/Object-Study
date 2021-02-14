package cooking;

public class RoastingCooking implements Cooking {

    private final Meat meat;
    private final Vegetable vegetable;

    public RoastingCooking(Meat meat, Vegetable vegetable) {
        this.meat = meat;
        this.vegetable = vegetable;
    }

    public Food makeNewFood() {
        return new Food(meat.getName() + "와 " + vegetable.getName() +"를 익힌 음식");
    }
}
