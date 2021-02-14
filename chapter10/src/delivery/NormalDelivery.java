package delivery;

public class NormalDelivery extends Delivery {

    public NormalDelivery(long deliveryDistance) {
        super(deliveryDistance);
    }

    @Override
    protected long getExtraFee() {
        return 0;
    }

}
