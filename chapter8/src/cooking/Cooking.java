package cooking;

public interface Cooking {
    Food makeNewFood();
}
class NoneCooking implements Cooking {

    @Override
    public Food makeNewFood() {
        throw new IllegalStateException("요리할 수 없는 음식입니다!");
    }
}
