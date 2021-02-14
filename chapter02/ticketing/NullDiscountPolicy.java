package chapter02.ticketing;

public class NullDiscountPolicy implements DiscountPolicy{
    @Override
    public long discount(long fee, Screening screening) {
        System.out.println("할인 없음");
        return fee;
    }
}
