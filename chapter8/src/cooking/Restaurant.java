package cooking;

import java.util.Map;

public class Restaurant {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(
                new Chef(
                        Map.of(
                                "불고기", new RoastingCooking(
                                        new Meat("소고기"),
                                        new Vegetable("양파")),
                                "치킨", new FryingCooking(
                                        new Meat("닭고기"))
                        )
                )
        );
        Food chicken = kitchen.cookFood("치킨");
        System.out.println(chicken.getFoodName());

        Food bulgogi = kitchen.cookFood("불고기");
        System.out.println(bulgogi.getFoodName());
    }
}
