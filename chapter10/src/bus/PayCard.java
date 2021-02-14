package bus;

public abstract class PayCard {

    private final int userAge;

    public PayCard(int userAge) {
        this.userAge = userAge;
    }

    public final void payFor(Bus bus) {
        long busFee = bus.calculateFee(userAge);
        pay(busFee);
    }

    protected abstract void pay(long busFee);
    protected abstract long getMoney();
}
