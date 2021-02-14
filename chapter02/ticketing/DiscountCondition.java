package chapter02.ticketing;

public interface DiscountCondition {
    boolean check(Screening screening); // public default
}
