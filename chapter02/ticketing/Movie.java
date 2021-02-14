package chapter02.ticketing;

public class Movie {
    private final long fee;
    private final DiscountPolicy discountPolicy;

    public Movie(long fee, DiscountPolicy discountPolicy) {
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public long getDiscountFee(Screening screening) {
        return discountPolicy.discount(fee, screening);
    }
}
