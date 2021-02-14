package coffeeshop;

public class Coffee {
    private final String coffeeName;
    private final Sugar sugar;

    public Coffee(String coffeeName, Sugar sugar) {
        this.coffeeName = coffeeName;
        this.sugar = sugar;
    }
    public String taste() {
        return coffeeName + " 맛에 설탕 " + sugar.getSpoon() + "스푼 들어간 커피";
    }
}
