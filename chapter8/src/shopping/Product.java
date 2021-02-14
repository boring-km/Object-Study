package shopping;

import java.time.LocalDate;

public interface Product {
    long getPrice(LocalDate dateOfPurchase);
}

class NoneDiscountProduct implements Product{

    private final long price;

    public NoneDiscountProduct(long price) {   // NoneDiscountProduct
        this.price = price;
    }

    public long getPrice(LocalDate dateOfPurchase) {
        return price;
    }
}

class DiscountProduct implements Product { // DiscountProduct, NoneDiscountProduct
    private DiscountPolicy discountPolicy;
    private final long price;

    // 생성자를 통해 객체 생성 시 의존성을 해결하는 완전한 상태의 객체 생성을 하고,
    public DiscountProduct(DiscountPolicy discountPolicy, long price) {   // DiscountProduct
        this.discountPolicy = discountPolicy;
        this.price = price;
    }
    // 필요에 따라 setter 메서드를 이용해 의존 대상을 변경할 수 있다.
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public long getPrice(LocalDate dateOfPurchase) {    // discount()의 반환값을 할인되는 값으로 변경한다.
        PurchaseInfo purchaseInfo = new PurchaseInfo(price, dateOfPurchase);
        return price - discountPolicy.discount(purchaseInfo);
    }
}
