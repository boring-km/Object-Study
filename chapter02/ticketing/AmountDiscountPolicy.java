package chapter02.ticketing;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private long amount = 0;

    public AmountDiscountPolicy(Long amount, DiscountCondition... conditions) {
        super(conditions);
        this.amount = amount;
    }

    @Override
    protected long apply(long fee) {
        return fee - amount;
    }
}
