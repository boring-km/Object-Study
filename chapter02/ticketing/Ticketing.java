package chapter02.ticketing;

import java.time.LocalDateTime;

public class Ticketing {
    public static void main(String[] args) {
        new Customer(100000L).reserve(new Screening(
                LocalDateTime.of(2020, 4, 27, 11, 0), 9,
                new Movie(10000L,
                        new AmountDiscountPolicy(800L,
                                new SequenceDiscountCondition(1),
                                new SequenceDiscountCondition(10),
                                new PeriodDiscountCondition(LocalDateTime.of(2020, 4, 27,10, 0), LocalDateTime.of(2020, 4, 27,12, 0)),
                                new PeriodDiscountCondition(LocalDateTime.of(2020, 4, 27,18, 0), LocalDateTime.of(2020, 4, 27,21, 0))
                        )
                )
        ));
    }
}
