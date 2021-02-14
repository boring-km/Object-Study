package chapter02.ticketing;

public class PercentDiscountPolicy extends DefaultDiscountPolicy{

    private double percent = 1;

    public PercentDiscountPolicy(double percent) {
        this.percent = percent;
    }

    @Override
    protected long apply(long fee) {
        return Double.valueOf(fee * this.percent).longValue();
    }
}
