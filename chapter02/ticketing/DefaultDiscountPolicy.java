package chapter02.ticketing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private final Set<DiscountCondition> conditions = new HashSet<>();
    private long fee;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    @Override
    public long discount(long fee, Screening screening) {
        conditions.stream().filter(condition -> condition.check(screening)).forEach(condition -> this.fee = apply(fee));
        return this.fee;
    }

    protected abstract long apply(long fee);
}
