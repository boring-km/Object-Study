package cooking;

public class FryingCooking implements Cooking {

    private final Meat meat;

    public FryingCooking(Meat meat) {
        this.meat = meat;
    }

    @Override
    public Food makeNewFood() {
        return new Food(meat.getName() + "를 튀긴 음식");
    }
}
