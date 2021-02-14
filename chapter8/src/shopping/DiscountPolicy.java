package shopping;

import java.util.*;

public abstract class DiscountPolicy {

    private final Set<DiscountCondition> conditions;

    protected DiscountPolicy(Set<DiscountCondition> conditions) {
        this.conditions = conditions;
    }

    public long discount(PurchaseInfo purchaseInfo) {
        return conditions.stream()
                .filter(condition -> condition.check(purchaseInfo))
                .mapToLong(condition -> getDiscountablePrice(purchaseInfo))
                .findFirst()
                .orElse(0);
    }

    protected abstract long getDiscountablePrice(PurchaseInfo purchaseInfo);
}

class OverlappedDiscountPolicy extends DiscountPolicy {

    private final Set<DiscountPolicy> discountPolicies;

    protected OverlappedDiscountPolicy(Set<DiscountCondition> conditions, DiscountPolicy... discountPolicies) {
        super(conditions);
        this.discountPolicies = Set.of(discountPolicies);
    }

    @Override
    protected long getDiscountablePrice(PurchaseInfo purchaseInfo) {

        return discountPolicies.stream()
                .mapToLong(discountPolicy -> discountPolicy.getDiscountablePrice(purchaseInfo))
                .sum();
    }
}

class AmountDiscountPolicy extends DiscountPolicy {

    private final int discountPrice;

    protected AmountDiscountPolicy(Set<DiscountCondition> conditions, int discountPrice) {
        super(conditions);
        this.discountPrice = discountPrice;
    }

    @Override
    protected long getDiscountablePrice(PurchaseInfo purchaseInfo) {
        return discountPrice;
    }
}

class PercentDiscountPolicy extends DiscountPolicy {

    private final double percent;

    protected PercentDiscountPolicy(Set<DiscountCondition> conditions, double percent) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected long getDiscountablePrice(PurchaseInfo purchaseInfo) {
        return (long) (purchaseInfo.getPrice() * percent);
    }
}