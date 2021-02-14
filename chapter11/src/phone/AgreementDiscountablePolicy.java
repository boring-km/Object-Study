package phone;

import java.util.Arrays;

public class AgreementDiscountablePolicy extends AdditionalRatePolicy {

    private enum discountableAgreements{_5GXStandard, _5GXPrime, _5GXPlatinum}
    private final String agreement;
    private final Money discountAmount;

    public AgreementDiscountablePolicy(RatePolicy next, String agreement, Money discountAmount) {
        super(next);
        this.agreement = agreement;
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        if (Arrays.stream(discountableAgreements.values()).anyMatch(discountableAgreement -> discountableAgreement.name().equals(agreement)))
            return fee.minus(discountAmount);
        return fee;
    }
}
