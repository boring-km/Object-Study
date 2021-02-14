package coffeeshop;

public class SugarServiceLocator {  // 필요가 없어짐

    private static final SugarServiceLocator sugarServiceLocator = new SugarServiceLocator();
    private Sugar sugar;

    public static Sugar sugar() {
        return sugarServiceLocator.sugar;
    }

    public static void setSugar(Sugar sugar) {
        sugarServiceLocator.sugar = sugar;
    }

    private SugarServiceLocator() {
        // 생성자를 못 만들게 하려고?
    }
}
