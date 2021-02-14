package delivery;

public class DeliveryPackage {

    private final String name;
    private final long weight;
    private static final long BASIC_FEE = 2500;
    private final double discountPercent;

    public DeliveryPackage(String name, long weight, double discountPercent) {
        this.name = name;
        this.weight = weight;
        this.discountPercent = discountPercent;
    }

    public final long calculateWeightFee() {
        return (long) ((double)(BASIC_FEE + (weight / 10) * getWeightFee()) * (1 - discountPercent));
    }

    protected int getWeightFee() {
        return 1000;
    }
}
