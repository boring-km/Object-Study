package delivery;

public class Order {

    private final String name;
    private final long weight;
    private final double discountPercent;

    public Order(String name, long weight, double discountPercent) {
        this.name = name;
        this.weight = weight;
        this.discountPercent = discountPercent;
    }

    public DeliveryPackage makeDeliveryPackage() {
        return new DeliveryPackage(name, weight, discountPercent);
    }
}
