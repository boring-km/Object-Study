package delivery;

public class OvernightDelivery extends Delivery {

    private final long extraFee;

    public OvernightDelivery(long deliveryDistance, long extraFee) {
        super(deliveryDistance);
        this.extraFee = extraFee;
    }

    @Override
    protected long getExtraFee() {
        return extraFee;
    }

}
