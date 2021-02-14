package ticketing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class DiscountPolicy {

    private final Set<DiscountCondition> conditions = new HashSet<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    public Money calculateDiscountAmount(Screening screening, Money fee) {

        return conditions.stream()
                .filter(condition -> condition.check(screening))
                .map(condition -> getDiscountAmount(fee))
                .findFirst()
                .orElse(Money.ZERO);
    }

    protected abstract Money getDiscountAmount(Money fee);
}

class OvelappedDiscountPolicy extends DiscountPolicy {

    private final Set<DiscountPolicy> discountPolicies;

    public OvelappedDiscountPolicy(Set<DiscountPolicy> discountPolicies, DiscountCondition... conditions) {
        super(conditions);
        this.discountPolicies = discountPolicies;
    }

    @Override
    protected Money getDiscountAmount(Money fee) {
        Money result = Money.ZERO;
        return discountPolicies.stream()
                .map(discountPolicy -> discountPolicy.getDiscountAmount(fee))
                .map(result::plus)
                .findFirst()
                .orElse(Money.ZERO);
    }
}

class AmountDiscountPolicy extends DiscountPolicy {

    private final Money amount;

    public AmountDiscountPolicy(Money amount, DiscountCondition... conditions) {
        super(conditions);
        this.amount = amount;
    }

    @Override
    protected Money getDiscountAmount(Money fee) {
        return amount;
    }
}

class PercentDiscountPolicy extends DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Money fee) {
        return fee.times(percent);
    }
}

