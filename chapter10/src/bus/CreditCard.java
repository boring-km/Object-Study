package bus;

public class CreditCard extends PayCard {

    private long usedMoney;
    private final double discountPercent;
    private final long payLimit;
    private static final long START_MONEY = 0;

    public CreditCard(int userAge, double discountPercent, long payLimit) {
        super(userAge);
        this.usedMoney = START_MONEY;
        this.discountPercent = discountPercent;
        this.payLimit = payLimit;
    }

    @Override
    protected void pay(long busFee) {
        long discountedFee = (long) (busFee * discountPercent);
        if (isNotOverLimit(discountedFee)) usedMoney += discountedFee;
        else throw new IllegalStateException("버스에 탈 돈이 부족함");
    }

    @Override
    protected long getMoney() {
        return usedMoney;
    }

    private boolean isNotOverLimit(long discountedFee) {
        return usedMoney + discountedFee <= payLimit;
    }

}
