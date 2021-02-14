package shopping;

import java.time.LocalDate;
import java.time.Month;

public interface DiscountCondition {
    boolean check(PurchaseInfo purchaseInfo);
}

class MonthlyCondition implements DiscountCondition {

    private final Month month;

    public MonthlyCondition(Month month) {
        this.month = month;
    }

    @Override
    public boolean check(PurchaseInfo purchaseInfo) {
        return month == purchaseInfo.getMonth();
    }
}

class PeriodCondition implements DiscountCondition {

    private final LocalDate beginDate;
    private final LocalDate endDate;

    PeriodCondition(LocalDate beginDate, LocalDate endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    @Override
    public boolean check(PurchaseInfo purchaseInfo) {
        return purchaseInfo.getDateOfPurchase().isAfter(beginDate) &&
                purchaseInfo.getDateOfPurchase().isBefore(endDate);
    }
}