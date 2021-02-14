package coffeeshop;

public class CoffeeShop {
    public static void main(String[] args) {
        Customer customer = new Customer();
        SugarServiceLocator.setSugar(new Sugar(2));
        Coffee coffee = customer.order(new Barista(), "아메리카노");
        System.out.println(coffee.taste());
    }
}
