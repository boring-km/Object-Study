package phone;

public class FixedRatePolicy extends BasicRatePolicy {  // 고정 요금제 추가?
    private final Money fixedAmount;

    public FixedRatePolicy(Money fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public Money calculateFee(Phone phone) {
        return fixedAmount;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return null;
    }
}
