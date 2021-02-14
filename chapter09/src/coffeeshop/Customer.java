package coffeeshop;

public class Customer {
    public Coffee order(Barista barista, String coffee) {
        return barista.drop(coffee);
    }
}
