package ticketing;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticketing {
    public static void main(String[] args) {
        NoneDiscountableMovie noneDiscountableMovie = new NoneDiscountableMovie("아바타", Duration.ofMinutes(200), Money.wons(10000));
        DiscountableMovie discountableMovie = new DiscountableMovie("어벤져스3", Duration.ofMinutes(210), Money.wons(12000),
                new AmountDiscountPolicy(
                        Money.wons(2000),
                        new PeriodCondition(LocalDateTime.of(2020, 6, 10, 9, 0),
                                LocalDateTime.of(2020, 6, 12, 23, 59))
                ));

        Customer kangmin = new Customer("진강민", Money.wons(50000));

        Ticket noneDiscountableTicket = noneDiscountableMovie.reserve(
                kangmin,
                new Screening(2, LocalDateTime.of(2020, 6, 9, 22, 55)),
                3);
        noneDiscountableTicket.printReservationInfo();  // 30000

        Ticket discountableTicket = discountableMovie.reserve(
                kangmin,
                new Screening(2, LocalDateTime.of(2020, 6, 10, 22, 55)),
                2);
        discountableTicket.printReservationInfo();

        Ticket isNotPayableTicket = noneDiscountableMovie.reserve(
                kangmin,
                new Screening(2, LocalDateTime.of(2020, 6, 9, 22, 55)),
                2);
        isNotPayableTicket.printReservationInfo();
    }
}
