package delivery;

public class HeavyDeliveryPackage extends DeliveryPackage {

    public HeavyDeliveryPackage(String name, long weight, double discountPercent) {
        super(name, weight, discountPercent);
    }

    @Override
    protected int getWeightFee() {
        return 2000;
    }
}
