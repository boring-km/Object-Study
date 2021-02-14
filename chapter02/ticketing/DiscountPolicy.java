package chapter02.ticketing;

public interface DiscountPolicy {
    long discount(long fee, Screening screening); // public default
}
