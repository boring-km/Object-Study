package shopping;

import java.time.LocalDate;
import java.time.Month;

public class PurchaseInfo {

    private final long price;
    private final LocalDate dateOfPurchase;

    public PurchaseInfo(long price, LocalDate dateOfPurchase) {
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getPrice() {
        return price;
    }

    public Month getMonth() {
        return this.dateOfPurchase.getMonth();
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

}
