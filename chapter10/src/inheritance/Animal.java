package inheritance;

public abstract class Animal {   // LSP 위반?

    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    public final void eat(Food food) {
        isEdible(food);
        System.out.println(name + "가 " +food.getName() + "를 먹다.");
    }

    protected abstract void isEdible(Food food);

}

class Puppy extends Animal {    // 강아지는 야채와 고기를 둘 다 먹을 수 있다.

    Puppy(String name) {
        super(name);
    }

    @Override
    protected void isEdible(Food food) {

    }
}

class Lion extends Animal {    // 사자는 채소를 먹지 않는다.

    Lion(String name) {
        super(name);
    }

    @Override
    protected void isEdible(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException();
        }
    }

}

class Elephant extends Animal {     // 코끼리는 고기를 먹지 않는다.

    public Elephant(String name) {
        super(name);
    }

    @Override
    protected void isEdible(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException();
        }
    }
}
