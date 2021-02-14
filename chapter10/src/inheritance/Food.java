package inheritance;

public class Food {
    private final String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Vegetable extends Food {

    public Vegetable(String name) {
        super(name);
    }
}

class Meat extends Food {

    public Meat(String name) {
        super(name);
    }
}
