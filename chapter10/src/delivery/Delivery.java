package delivery;

public abstract class Delivery {

    private final long deliveryDistance;
    private static final long LONG_DISTANCE = 200;
    private static final long DISTANCE_FEE_UNIT = 1000;
    private static final long NORMAL_DISTANCE_FEE = 0;

    protected Delivery(long deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public final boolean receive(Customer customer, Order order) {
        DeliveryPackage deliveryPackage = order.makeDeliveryPackage();
        long deliveryFee = getDeliveryFee(deliveryPackage);
        return customer.pay(deliveryFee);
    }

    private long getDeliveryFee(DeliveryPackage deliveryPackage) {
        return deliveryPackage.calculateWeightFee() + calculateDistanceFee() + getExtraFee();
    }

    private long calculateDistanceFee() {
        if (deliveryDistance > LONG_DISTANCE) return DISTANCE_FEE_UNIT * (deliveryDistance - LONG_DISTANCE);
        else return NORMAL_DISTANCE_FEE;
    }

    protected abstract long getExtraFee();
}
