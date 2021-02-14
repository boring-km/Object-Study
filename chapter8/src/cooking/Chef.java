package cooking;

public class Chef {

    private final Recipe recipe;

    public Chef(Recipe recipe) {
        this.recipe = recipe;
    }

    public Food cook(String foodName) {
        Cooking cooking = recipe.howToCook(foodName);
        return cooking.makeNewFood();
    }
}
