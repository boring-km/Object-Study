package chapter02.ticketing;

public class SequenceDiscountCondition implements DiscountCondition{

    private final Integer order;

    public SequenceDiscountCondition(Integer order) {
        this.order = order;
    }

    @Override
    public boolean check(Screening screening) {
        return this.order.equals(screening.getOrder());
    }
}
