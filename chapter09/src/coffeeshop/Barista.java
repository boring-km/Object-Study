package coffeeshop;

import java.util.Arrays;

public class Barista implements SugarInjectable {

    private Sugar sugar;

    public Coffee drop(String coffeeName) {
        return CoffeeFactory.createCoffee(coffeeName, sugar);
    }

    @Override
    public void inject(Sugar sugar) {
        this.sugar = sugar;
    }
}

enum CoffeeFactory {
    LATTE("라떼"),
    AMERICANO("아메리카노"),
    ESPRESSO("에스프레소"),
    MOCHA("모카"),
    CAPPUCCINO("카푸치노");

    private final String coffeeName;

    CoffeeFactory(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public static Coffee createCoffee(String coffeeName, Sugar sugar) {
        CoffeeFactory coffeeFactory = getCoffeeFactory(coffeeName);
        return new Coffee(coffeeFactory.coffeeName, sugar);
    }

    private static CoffeeFactory getCoffeeFactory(String coffeeName) {
        return Arrays.stream(CoffeeFactory.values())
                .filter(coffee -> coffee.coffeeName.equals(coffeeName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
