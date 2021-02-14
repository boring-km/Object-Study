package cooking;

public class Kitchen {
    private final Chef chef;

    public Kitchen(Chef chef) {
        this.chef = chef;
    }

    public Food cookFood(String foodName) {
        return chef.cook(foodName);
    }
}
