package ticketing;

import java.time.Duration;
import java.util.Optional;

public abstract class Movie {

    private final String title;
    private final Duration duration;

    public Movie(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    public Ticket reserve(Customer customer, Screening screening, int audienceCount) {
        Money totalFee = calculateFee(screening, audienceCount);// customer.pay(totalFee)
        return generateTicket(customer, screening, totalFee, audienceCount);
    }

    private Ticket generateTicket(Customer customer, Screening screening, Money totalFee, int audienceCount) {

        return Optional.of(new Ticket(title, duration, customer, screening, totalFee, audienceCount))
                .filter(Ticket::sellToCustomer)
                .orElseThrow(NotEnoughMoneyException::new);
    }

    protected abstract Money calculateFee(Screening screening, int audienceCount);
}

class DiscountableMovie extends Movie {

    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public DiscountableMovie(String title, Duration duration, Money fee, DiscountPolicy discountPolicy) {
        super(title, duration);
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    @Override
    protected Money calculateFee(Screening screening, int audienceCount) {
        return calculateMovieFee(screening).times(audienceCount);
    }

    private Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening, fee));
    }
}

class NoneDiscountableMovie extends Movie {

    private final Money fee;

    public NoneDiscountableMovie(String title, Duration duration, Money fee) {
        super(title, duration);
        this.fee = fee;
    }

    @Override
    protected Money calculateFee(Screening screening, int audienceCount) {
        return fee.times(audienceCount);
    }

}