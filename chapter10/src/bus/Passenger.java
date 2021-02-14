package bus;

public class Passenger {
    private final PayCard payCard;

    public Passenger(PayCard payCard) {
        this.payCard = payCard;
    }

    public void ride(Bus bus) {
        payCard.payFor(bus);
    }

}
